package com.company;

import java.util.Scanner;

public class FCFSCPU
 {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int bt[] = new int[20];                 // to hold the burst time of the processes.
        int  wt[] = new int[20];                // to hold the waiting time
        int tat[] = new int[20];                // to hold the turnaround time
        int i;                                  // loop counter variable
        int n;                                  // to hold the number of processes.

        double wtavg;                           // to hold the average waiting time
        double tatavg;                          // to hold the average turnaround time.

        System.out.println("This program is FCFS CPU Scheduling Algorithm\n"
                + "which reads the number of jobs and cpu burst time and "
                + "perform scheduling based on arrival time and some parameters\n\n\n");

        System.out.printf("\nEnter the number of processes -- ");
        n = input.nextInt();

        // the loop is used to hold number of user's burst time input.
        // based on the number of processes input.
        for(i=0;i<n;i++)
        {
            System.out.printf("\nEnter Burst Time for Process %d -- ", i);
            bt[i] = input.nextInt();
        }

        // initializing the first elements of waiting time
        // and average waiting time to zero
        wt[0] = (int) (wtavg = 0);

        // initializing the first elements of turnaround time
        // and average turnaround time to zero
        tat[0] = (int) (tatavg = bt[0]);


        // the loop computes the waiting time, turnaround time
        // waiting time average, and turnaround time average
        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] +bt[i-1];       // curren wt determine by adding the previous element of wt and bt
            tat[i] = tat[i-1] +bt[i];       // current atat determine by adding previous element of tat and current bt.
            wtavg = wtavg + wt[i];          // determine by the running total of wt[] elements.
            tatavg = tatavg + tat[i];       // determine by the running total of tat[] elements.
        }
        System.out.printf("\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");

        // loop displays the values stored in bt[], wt[] and tat[]
        for(i=0;i<n;i++)
            System.out.printf("\n\t P%d \t\t %d \t\t %d \t\t %d", i, bt[i], wt[i], tat[i]);

        System.out.printf("\nAverage Waiting Time -- %f", wtavg);
        System.out.printf("\nAverage Turnaround Time -- %f", tatavg);
        input.nextLine();
    }
}
