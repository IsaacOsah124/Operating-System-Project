#include <iostream>
#include <stdlib.h>
#include<stdio.h>
#include<conio.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;
int main() {
	
	//Declaring a choice variable
	int choice3;
	cout<<"A C++ program to simulate the following non-preemptive CPU scheduling algorithms to find turn around time and waiting time.\n1. FCFS CPU scheduling algorithms\n2. SJF CPU scheduling algorithms \n3. Round Robin CPU scheduling algorithms \n4. Priority CPU scheduling algorithms";
    cout<<"\n\nEnter your Choice:  ";
    //Processing user input
    cin>> choice3;
    //Clearing screen
    system("CLS");
    //Validating user input
    if (choice3 == 1){
    	
    	//Declaring local variables
    	int burstTime[20], waitingTime[20], turnAroundTime[20], i, process;
        float avgWaitingTime, avgturnAroundTime;
        
        //Clearing screen
        system("CLS");
        
        cout<<" FCFS CPU SCHEDULING ALGORITHM "<<endl;
        //Prompting user to enter number of processes
        cout<<"\nEnter the number of processes -- ";
        
        //Accepting user input
        cin>>process;
        
        //Validating user input
        for(i=0;i<process;i++)
      {
      	//Prompting user to enter burst time 
       cout<<"\nEnter Burst Time for Process "<< i <<" --" ;
       
       ///Accepting user burst process 
       cin>>burstTime[i];
     }
       
       //Assigning waiting Time to average waiting time
       waitingTime[0] = avgWaitingTime = 0;
       
	   //Assigning turn around time to average turn around time and to burst time
      turnAroundTime[0] = avgturnAroundTime = burstTime[0];
      
      //Validating for a for loop
    for(i=1;i<process;i++)
     {
       //Calculating waiting time
      waitingTime[i] =  waitingTime[i-1] +burstTime[i-1];
      
       //Calculating turn around time
     turnAroundTime[i] = turnAroundTime[i-1] +burstTime[i];
     
      //Calculating average waiting time
     avgWaitingTime = avgWaitingTime +  waitingTime[i];
      //Calculating average turn around time
     avgturnAroundTime = avgturnAroundTime + turnAroundTime[i];
     }
     //Displaying processed inputs
    cout<<"\n\n\t PROCESS \tBURST TIME \t WAITING TIME\tTURNAROUND TIME\n";
    //Validating for loop
    for(i=0;i<process;i++)
    //Displaying processed data
     cout<<"\n\t P" << i <<"  \t\t  "<< burstTime[i] << "  \t\t  "  << waitingTime[i] << "  \t\t   " << turnAroundTime[i];
     cout<<"\n\nAverage Waiting Time -- "<< avgWaitingTime ;
     cout<<"\nAverage Turnaround Time -- " <<avgturnAroundTime ;
     getch();

	}
	
	
	
	
   else	if (choice3 == 2){
   	int p[20], bt[20], wt[20], tat[20], i, k, n, temp;
    float wtavg, tatavg;
    system("CLS");
    cout<<" SJF CPU SCHEDULING ALGORITHM "<<endl;
    cout<<"\nEnter the number of processes -- ";
    cin>>n;
    for(i=0;i<n;i++)
     {
     p[i]=i;
    cout<<"Enter Burst Time for Process " <<i <<" -- ";
    cin>>bt[i];
     }
     for(i=0;i<n;i++)
     for(k=i+1;k<n;k++)
    if(bt[i]>bt[k])
    {
      temp=bt[i];
      bt[i]=bt[k];
      bt[k]=temp;
      temp=p[i];
      p[i]=p[k];
      p[k]=temp;
    }
      wt[0] = wtavg = 0;
      tat[0] = tatavg = bt[0];
      for(i=1;i<n;i++)
     {
       wt[i] = wt[i-1] +bt[i-1];
       tat[i] = tat[i-1] +bt[i];
       wtavg = wtavg + wt[i];
       tatavg = tatavg + tat[i];
     }
      cout<<"\n\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n";
      for(i=0;i<n;i++)
      cout<<"\n\t P" << p[i] <<"  \t\t  " << bt[i] <<"  \t\t  "<< wt[i] <<"  \t\t  "<< tat[i];
      cout<<"\n\nAverage Waiting Time -- "<< wtavg ;
      cout<<"\nAverage Turnaround Time -- "<< tatavg ;
      getch();
   	
	}
	
	
	else if (choice3 == 3){
		int i,j,n,bu[10],wa[10],tat[10],t,ct[10],max;
        float awt=0,att=0,temp=0;
        system("cls");
        cout<<" ROUND ROBIN CPU SCHEDULING ALGORITHM "<<endl;
        cout<<"Enter the no of processes -- ";
        cin>>n;
        for(i=0;i<n;i++)
    {
        cout<<"\nEnter Burst Time for process"<< (i+1) <<"--";
        cin>>bu[i];
        ct[i]=bu[i];
    }
        cout<<"\nEnter the size of time slice -- ";
        cin>>t;
        max=bu[0];
       
	    for(i=1;i<n;i++)
        if(max<bu[i])
        max=bu[i];
        for(j=0;j<(max/t)+1;j++)
        for(i=0;i<n;i++)
        if(bu[i]!=0)
        if(bu[i]<=t)
    {
        tat[i]=temp+bu[i];
        temp=temp+bu[i];
        bu[i]=0;
    }
      else
    {
        bu[i]=bu[i]-t;
        temp=temp+t;
    }
        for(i=0;i<n;i++)
    {
         wa[i]=tat[i]-ct[i];
         att+=tat[i];
         awt+=wa[i];
    }
        cout<<"\nThe Average Turnaround time is -- "<< att;
        cout<<"\nThe Average Waiting time is --  "<< awt;
        cout<<"\n\n\tPROCESS\t BURST TIME \t WAITING TIME\tTURNAROUND TIME\n";
        for(i=0;i<n;i++)
        cout<<"\n\t "<< (i+1) <<"\t\t" << ct[i] <<"\t\t" << wa[i]<<"\t\t  "<<tat[i];
        getch();

	}
	
	
	else if (choice3 == 4){
		int p[20],bt[20],pri[20], wt[20],tat[20],i, k, n, temp;
        float wtavg, tatavg;
        system("CLS");
        cout<<" PRIORITY CPU SCHEDULING ALGORITHM "<<endl;
        cout<<"Enter the number of processes --- ";
        cin>>n;
        for(i=0;i<n;i++)
     {
        p[i] = i;
        cout<<"Enter the Burst Time & Priority of Process"<< i <<"---";
         cin>>bt[i]>>pri[i];
     }
        for(i=0;i<n;i++)
        for(k=i+1;k<n;k++)
        if(pri[i] > pri[k])
     {
        temp=p[i];
        p[i]=p[k];
        p[k]=temp;
        temp=bt[i];
        bt[i]=bt[k];
        bt[k]=temp;
        temp=pri[i];
        pri[i]=pri[k];
        pri[k]=temp;
     }
        wtavg = wt[0] = 0;
        tatavg = tat[0] = bt[0];
        for(i=1;i<n;i++)
     {
        wt[i] = wt[i-1] + bt[i-1];
        tat[i] = tat[i-1] + bt[i];
        wtavg = wtavg + wt[i];
        tatavg = tatavg + tat[i];
     }
        cout<<"\nPROCESS\t\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME";
        for(i=0;i<n;i++)
        cout<<"\n\t "<< p[i]<<"\t\t" << pri[i] <<"\t\t" << bt[i] <<"\t\t"<< wt[i]<<"\t\t  "<<tat[i];
        cout<<"\n\nAverage Waiting Time is --- "<< wtavg;
        cout<<"\nAverage Turnaround Time is --- " << tatavg;
        getch();

	}
	
	
	
	else {
		system("CLS");
		cout<<"Invalid Input\n\tSystem Shutting down";
	}
	
	return 0;
}
