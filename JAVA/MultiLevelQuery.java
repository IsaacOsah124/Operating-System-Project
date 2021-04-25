package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int p[] = new int[20];				// to store process values
        int bt[] = new int[20];				// to store the bust time of processes
        int su[] = new int[20];				// to store the system/user processes
        int wt[] = new int[20];				// to store the waiting time
        int tat[] = new int[20];			// to store the turnaround time
        int i;								// loop counter variable
        int k;								// loop counter variable
        int n;								// to store the number of processes
        int temp;							// to store temporal value
        double wtavg;						// to hold the waiting time average
        double tatavg;						// to hold the turnaround time average

        Scanner input = new Scanner(System.in);
        System.out.println("Multi-Level Queue Scheduling Algorithm\n"
                + "All processes are divided into system and user process.\n\n\n\n");

        System.out.printf("Enter the number of processes --- ");
        n = input.nextInt();

        // the for loop iterates and initialize p[] with the loop counter values
        // and also stores each input of the user's bt[] and su[] variable
        for(i=0;i<n;i++)
        {
            p[i] = i;
            System.out.printf("Enter the Burst Time of Process %d --- ", i + 1);
            bt[i] = input.nextInt();
            System.out.printf("System/User Process (0/1) ? --- ");
            su[i] = input.nextInt();
        }

        // The nexted for loop order the arrays holding the number of process,
        // the bust time and the system/user process in ascending order.
        for(i=0;i<n;i++)
            for(k=i+1;k<n;k++)
                if(su[i] > su[k])
                {
                    temp=p[i];
                    p[i]=p[k];
                    p[k]=temp;
                    temp=bt[i];
                    bt[i]=bt[k];
                    bt[k]=temp;
                    temp=su[i];
                    su[i]=su[k];
                    su[k]=temp;
                }

        // the waiting time, turnaround time, waiting time average,
        // bust time and turnaround time average initialize to zero
        wtavg = wt[0] = 0;
        tatavg = tat[0] = bt[0];


        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] + bt[i-1];
            tat[i] = tat[i-1] + bt[i];

            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }
        System.out.printf("\nPROCESS\t\t SYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for(i=0;i<n;i++)
            System.out.printf("\n%d \t\t %d \t\t %d \t\t %d \t\t %d ",p[i],su[i],bt[i],wt[i],tat[i]);

        System.out.printf("\nAverage Waiting Time is --- %f",wtavg/n);
        System.out.printf("\nAverage Turnaround Time is --- %f",tatavg/n);
        input.nextLine();
    }
}
