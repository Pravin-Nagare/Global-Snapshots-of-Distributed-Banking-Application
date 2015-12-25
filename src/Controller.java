

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle.Control;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


public class Controller {
	private static int iBalance = 0;
	private static String branchFile = null;
	private static int balance = 0; 
	public static List<BranchID> list = new ArrayList<BranchID>();;
	public static int snapshot_num = 1;
	
	public Controller(){
		
	}
	
	static void getListBalance (File file, List<BranchID> list, int iBalance){
        int branchCount = 0;
        
        Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!!!");
			System.exit(1);
			e.printStackTrace();
		}finally{
		}
        while (input.hasNextLine()) {
        	BranchID branch = new BranchID();
            String data = input.nextLine();
            String[] split = data.split("\\s+");
            branch.name = split[0];
            branch.ip = split[1];
            branch.port = Integer.parseInt(split[2]);
            list.add(branch);
            branchCount++;
        }
        if(branchCount > 0)
			balance = iBalance / branchCount;
		else{
			System.err.println("No branches in the file");
			input.close();
			System.exit(1);
		}
        input.close();
    }
	
	public static void assignInitialBalance(int iBalance, String branchFile){
		File file = new File(branchFile);
		getListBalance(file, list, iBalance);
		TTransport transport;
		//System.out.println(list);
		for(BranchID branch : list){
			try {
			     transport = new TSocket(branch.ip, Integer.valueOf(branch.port));
			     transport.open();
			     TProtocol protocol = new  TBinaryProtocol(transport);
			     Branch.Client client = new Branch.Client(protocol);
			     client.initBranch(balance, list);
			     transport.close();
			   } catch (TException x) {
				   System.err.println("Socket Exception!!!");
				   System.exit(1);
				   x.printStackTrace();
			   }finally{
				  
			   }
		}
	}

	private static void startSnapShotAlgorithm() {
		
		while(true){
			callInitSnapshot();
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				System.err.println("Interrupted exception in main program");
				System.exit(1);
				e.printStackTrace();
			}
			callRetreiveSnapshot(snapshot_num);
			snapshot_num++;
		}
	}

	private static void callRetreiveSnapshot(int snapshot_num) {
		LocalSnapshot localSnapshot = null;
		TTransport transport;
		for(BranchID branch : list){
			try {
			     transport = new TSocket(branch.ip, Integer.valueOf(branch.port));
			     transport.open();
			     TProtocol protocol = new  TBinaryProtocol(transport);
			     Branch.Client client = new Branch.Client(protocol);
			     localSnapshot = client.retrieveSnapshot(snapshot_num);
			     System.out.println("Snapshot Nummber:" + localSnapshot.getSnapshot_num() + " Branch Name:" + branch.getName() + " " + " Balance:"+localSnapshot.getBalance() + " Channel Messages:"+localSnapshot.getMessages());
			     transport.close();
			   } catch (TException x) {
				   System.err.println("Socket Exception in callRetreive Method!!!");
				   System.exit(1);
				   x.printStackTrace();
			   }finally{
				  
			   }
		}
		System.out.println("--------------------------------------------------------------------------");
	}

	private static void callInitSnapshot() {
		Random rand = new Random();
		int index = 0;
		if(list.size() == 1)
			index = 0;
		else
			index = rand.nextInt(list.size());
		try {
			 TTransport transport;
		     transport = new TSocket(list.get(index).ip, Integer.valueOf(list.get(index).port));
		     transport.open();
		     TProtocol protocol = new  TBinaryProtocol(transport);
		     Branch.Client client = new Branch.Client(protocol);
		     client.initSnapshot(snapshot_num);
		     transport.close();
		 } catch (TException x) {
			   System.err.println("Socket Exception to start initSnapshot!!!");
			   System.exit(1);
			   x.printStackTrace();
		 }
	}
	
	public static void main(String args[]){
		if(args.length < 2){
			System.out.println("Invalid Parameters: <Initial Amount> <Branch Filename>");
			System.exit(1);
		}
		iBalance = Integer.parseInt(args[0]);
		branchFile = args[1];
		assignInitialBalance(iBalance, branchFile);
		startSnapShotAlgorithm();
	}
}
