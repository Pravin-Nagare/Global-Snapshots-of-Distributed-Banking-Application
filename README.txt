CS557 Distributed Systems
Fall 2015
PROJECT <1> README FILE

Due Date: <Wed, Niv 18, 2015>
Submission Date: <Wed, Niv 18, 2015>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Pravin Nagare> 
e-mail(s): <pnagare1@binghamton.edu> 

DESIGN and IMPLEMENTATION:
[
	I have controller file which initiates chandy-lamport snapshot algorithm on bank branches. Used TThreadPoolServer to deal with multiple servers.
]

PERCENT COMPLETE:
[
   I have completed insert, search, view, join and leave.
]


BUGS:

[
  None
]

FILES:

[

bank.thrift   BranchHandler.java  Branch.java  Controller.java	LocalSnapshot.java  MyBranch.java  SystemException.java
branches.txt  BranchID.java	  branch.sh    controller.sh	makefile	    README.txt	   TransferMessage.java
README.txt the text file you are presently reading
]

SAMPLE OUTPUT:

[
	remote03:~/DS/pnagare1-project3/GlobalSnapshot> ./controller.sh 4000 branches.txt 
Snapshot Nummber:1 Branch Name:b1  Balance:1000 Channel Messages:[]
Snapshot Nummber:1 Branch Name:b2  Balance:1000 Channel Messages:[]
Snapshot Nummber:1 Branch Name:b3  Balance:1000 Channel Messages:[]
Snapshot Nummber:1 Branch Name:b4  Balance:1000 Channel Messages:[]
--------------------------------------------------------------------------
Snapshot Nummber:2 Branch Name:b1  Balance:973 Channel Messages:[31]
Snapshot Nummber:2 Branch Name:b2  Balance:1007 Channel Messages:[]
Snapshot Nummber:2 Branch Name:b3  Balance:964 Channel Messages:[]
Snapshot Nummber:2 Branch Name:b4  Balance:1025 Channel Messages:[]
--------------------------------------------------------------------------
Snapshot Nummber:3 Branch Name:b1  Balance:940 Channel Messages:[]
Snapshot Nummber:3 Branch Name:b2  Balance:1050 Channel Messages:[32]
Snapshot Nummber:3 Branch Name:b3  Balance:910 Channel Messages:[]
Snapshot Nummber:3 Branch Name:b4  Balance:1050 Channel Messages:[]
--------------------------------------------------------------------------
Snapshot Nummber:4 Branch Name:b1  Balance:800 Channel Messages:[39, 58]
Snapshot Nummber:4 Branch Name:b2  Balance:1234 Channel Messages:[23]
Snapshot Nummber:4 Branch Name:b3  Balance:743 Channel Messages:[]
Snapshot Nummber:4 Branch Name:b4  Balance:1103 Channel Messages:[]
--------------------------------------------------------------------------
Snapshot Nummber:5 Branch Name:b1  Balance:886 Channel Messages:[]
Snapshot Nummber:5 Branch Name:b2  Balance:1278 Channel Messages:[38]
Snapshot Nummber:5 Branch Name:b3  Balance:750 Channel Messages:[]
Snapshot Nummber:5 Branch Name:b4  Balance:1048 Channel Messages:[]
--------------------------------------------------------------------------
Snapshot Nummber:6 Branch Name:b1  Balance:853 Channel Messages:[]
Snapshot Nummber:6 Branch Name:b2  Balance:1342 Channel Messages:[]
Snapshot Nummber:6 Branch Name:b3  Balance:691 Channel Messages:[]
Snapshot Nummber:6 Branch Name:b4  Balance:1114 Channel Messages:[]
--------------------------------------------------------------------------
Snapshot Nummber:7 Branch Name:b1  Balance:866 Channel Messages:[]
Snapshot Nummber:7 Branch Name:b2  Balance:1368 Channel Messages:[47]
Snapshot Nummber:7 Branch Name:b3  Balance:817 Channel Messages:[]
Snapshot Nummber:7 Branch Name:b4  Balance:902 Channel Messages:[]
--------------------------------------------------------------------------
Snapshot Nummber:8 Branch Name:b1  Balance:939 Channel Messages:[]
Snapshot Nummber:8 Branch Name:b2  Balance:1435 Channel Messages:[25]
Snapshot Nummber:8 Branch Name:b3  Balance:615 Channel Messages:[]
Snapshot Nummber:8 Branch Name:b4  Balance:878 Channel Messages:[33, 75]

]

TO COMPILE:

[
  make
]

TO RUN:

[
	./branch <branch-name> <port>   
	./controller.sh 4000 branches.txt
]

HELP ON COMMANDS:

[
	
]