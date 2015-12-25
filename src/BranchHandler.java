

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class BranchHandler implements Branch.Iface{
	private List<BranchID> list = null;
	private volatile int balance;
	private BranchID branchID = null;
	public  LocalSnapshot localSnapshot = null;
	private volatile Map<String, Boolean> mapForMarker = null;
	private volatile boolean snapshotON;
	private volatile boolean firstMarker;
	private volatile boolean stopSending;
	
	public BranchHandler(){
		list = new ArrayList<BranchID>();
		balance = 0;
		branchID = new BranchID();
		mapForMarker = new ConcurrentHashMap<String, Boolean>();
		snapshotON = false;
		firstMarker = false;
		stopSending = false;
	}
	
	public void initBranch(int balance, List<BranchID> list){
		for(int i=0;i<list.size();i++){
			if(list.get(i).name.equals(MyBranch.branchName)){
				branchID = list.get(i);
				list.remove(i);
				break;
			}
		}
		this.list = list;
		this.balance = balance;
		sendMoneyToOtherBranch();
	}
	
	public void sendMoneyToOtherBranch() {
				
		Thread sendThread = new Thread(new Runnable(){
			public void run() {
				int index = 0;
				int percent = 0;
				int wait = 0;
				TransferMessage trans = null;
				while(true){
					if(stopSending){
						Random rand = new Random();
						if(list.size() == 1)
							index = 0;
						else
							index = rand.nextInt(list.size());
						percent = rand.nextInt(5) + 1;
						wait = rand.nextInt(5) + 0;
						trans = new TransferMessage();
						try {
							 TTransport transport;
						     transport = new TSocket(list.get(index).ip, Integer.valueOf(list.get(index).port));
						     transport.open();
						     TProtocol protocol = new  TBinaryProtocol(transport);
						     Branch.Client client = new Branch.Client(protocol);
						     trans.orig_branchId = branchID;
							 trans.amount = (int) ((percent* balance) /100);
							 if(trans.amount > 0){
								 balance -= trans.amount;
						     	 client.transferMoney(trans);
							 }
						     transport.close();
						     Thread.sleep(wait * 1000);
						 } catch (TException x) {
							   System.err.println("Socket Exception: In Run of sendMoneyToOtherBranch!!!");
							   System.exit(1);
							   x.printStackTrace();
						 } catch (InterruptedException e) {
							 	System.err.println("Thread Exception: In Sleep!!!");
							 	System.exit(1);
							    e.printStackTrace();
						}
					}
				}
			}
			
		});
		sendThread.start();
	}

	public void transferMoney(TransferMessage message){
		if(snapshotON){
			if( !mapForMarker.containsKey(message.getOrig_branchId().getName()) ) {
				localSnapshot.getMessages().add(message.getAmount());
			}
		}
		this.balance += message.amount;
	}

	@Override
	public void initSnapshot(int snapshot_num) throws SystemException,
			TException {
		List<Integer> messages = new ArrayList<Integer>();
		localSnapshot = new LocalSnapshot(snapshot_num, this.balance, messages);
		mapForMarker.clear();
		snapshotON = true;
		firstMarker = true;
		
		//Send marker messages to other branches
		stopSending = false;
		sendMarkerMessages(snapshot_num);
	}

	private void sendMarkerMessages(int snapshot_num) {
		stopSending = false;
				TTransport transport = null;
				TProtocol protocol = null;
				Branch.Client client = null;
				for(BranchID branch : list){
					try {
					     transport = new TSocket(branch.ip, Integer.valueOf(branch.port));
					     transport.open();
					     protocol = new  TBinaryProtocol(transport);
					     client = new Branch.Client(protocol);
					     client.Marker(branchID, snapshot_num);	
					     transport.close();
					   } catch (TException x) {
						   System.err.println("Socket Exception: In Run of sendMarkerMessages!!!");
						   System.exit(1);
						   x.printStackTrace();
					}finally{
						  
					   }
				}
		stopSending = true;
	}

	@Override
	public void Marker(BranchID branchId, int snapshot_num)
			throws SystemException, TException  {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Thread Exception!!");
			System.exit(1);
			e.printStackTrace();
		}
		if(!firstMarker){
			firstMarker = true;
			List<Integer> messages = new ArrayList<Integer>();
			localSnapshot = new LocalSnapshot(snapshot_num, this.balance, messages);
			mapForMarker.clear();
			mapForMarker.put(branchId.name, true);
			snapshotON = true;
			sendMarkerMessages(snapshot_num);
		}
		else{
			mapForMarker.put(branchId.name, true);
		}
	}

	@Override
	public LocalSnapshot retrieveSnapshot(int snapshot_num)
			throws SystemException, TException {
		firstMarker = false;
		snapshotON = false;
		return localSnapshot;
	}
}

