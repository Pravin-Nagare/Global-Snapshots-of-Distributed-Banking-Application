
import org.apache.thrift.server.TServer;

import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class MyBranch {
	public static int port;
	public static BranchHandler handler;
	public static Branch.Processor processor;
	public static String branchName = null;
	
	public static void main(String [] args) {
		if(args.length < 2){
			System.out.println("Invalid Parameters: <Branch_Name> <Port>");
		}
		branchName = args[0];
		//port= Integer.valueOf(args[1]);
		
	    try {
	      handler = new BranchHandler();
	      processor = new Branch.Processor(handler);
	      port= Integer.valueOf(args[1]);
	      Runnable simple = new Runnable() {
	    	 public void run() {
		          simple(processor);
		        }
		  };
		
		  new Thread(simple).start();
		  }catch (Exception x) {
		    	System.err.println("Exception in thread creation" + x);
		    	System.exit(1);
		  }
	}

	public static void simple(Branch.Processor processor) {
	    try {
	    	TServerTransport serverTransport = new TServerSocket(port);
		    //TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
		    // Use this for a multithreaded server
		     TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

		    System.out.println(branchName + " started at port " + port);
	        server.serve();
	    } catch (Exception e) {
	    	System.err.println("Exception in TserverSocket: ");
		}
	}
}
