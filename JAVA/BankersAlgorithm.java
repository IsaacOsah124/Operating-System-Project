package com.company;

import java.util.Scanner;

public class BankersAlgorithm {

    public static void main(String[] args) {
	// write your code here
        int all[][] = new int[10][10];         // a two dimentional array to hold the allocated elements
        int max[][] = new int[10][10];         // a two dimentional array to hold the max elements
        int need[][] = new int[10][10];        // a two dimentional array to hold the need elements
        int flag[] = new int[10];              // a two dimentional array to hold the [0/1] to represent boolean values
        int fl;                                 // to determine the index of visited processes.
        int i;                                  // loop counting variable
        int j;                                  // loop counting variable
        int k;                                  // loop counting variable
        int p;                                  // loop counting variable
        int b;                                  // value to determine if all needs are satisfied.
        int n = 0;                                  // number of process
        int r = 0;                                  // number of resources
        int g;                                  // value to determined if deadlock has occurred.
        int cnt = 0;                            // loop terminating value
        int id;                                 // value to determine the index of  a process
        int newr;                               // to hold the new resource values
        int avail[] = new int[10];              // to hold available resources
        int seq[] = new int[10];                // to hold sequence values
        boolean yes = false;                    // to implement goto

        Scanner input = new Scanner(System.in);


        // call the user interaction method
        int ui = userInteractionBankers();

        switch(ui){
            case 0:
                System.exit(0);

            case 1:
                n = 5;
                r = 3;

                // Available instances of resources
                avail = new int[]{3, 3, 2};

                // Maximum R that can be allocated
                // to processes
                max = new int[][]{{7, 5, 3},
                        {3, 2, 2},
                        {9, 0, 2},
                        {2, 2, 2},
                        {4, 3, 3}};

                // Resources allocated to processes
                all = new int [][]{{0, 1, 0},
                        {2, 0, 0},
                        {3, 0, 2},
                        {2, 1, 1},
                        {0, 0, 2}};
                // Initialize flag values to false
                for( i=0; i < flag.length; i ++)
                    flag[i] = 0;
                break;

            case 2:
                System.out.println("Bankers Algorithm\n\n\n\n");
                System.out.printf("Enter number of processes -- ");
                n = input.nextInt();
                System.out.printf("Enter number of resources -- ");
                r = input.nextInt();

                // re-initilizing the two dimensional arrays
                all = new int[n][r];
                max = new int[n][r];
                avail = new int[r];
                need = new int[n][r];

                for (i = 0; i < n; i++) {
                    System.out.printf("Enter details for P%d", i);
                    System.out.printf("\nEnter allocation\t -- \t");
                    for (j = 0; j < r; j++){
                        all[i][j] = input.nextInt();

                    }
                    System.out.printf("Enter Max\t\t -- \t");
                    for (j = 0; j < r; j++){
                        max[i][j] = input.nextInt();
                    }
                    // initilize the flag value of the process to false  state(0)
                    // this determines an unfinished state of the process.
                    flag[i] = 0;
                }

                System.out.printf("\nEnter Available Resources\t -- \t");
                for (i = 0; i < r; i++){
                    avail[i] = input.nextInt();
                }

                break;

            default:
                System.out.println("You input is Invalid\nProgam terminated.");

        }




        System.out.printf("\nEnter New Request Details -- ");
        System.out.printf("\nEnter pid \t -- \t");
        id = input.nextInt();
        System.out.printf("Enter Request for Resources \t -- \t");

        for (i = 0; i < r; i++) {
            newr = input.nextInt();
            // f[id].all[i] += newr;
            all[id][i] += newr;             // add the newr to the process' resource
            avail[i] = avail[i] - newr;     // subtract the newr from the avail
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < r; j++) {
                // f[i].need[j] = f[i].max[j] - f[i].all[j];
                need[i][j] = max[i][j] - all[i][j];

                if (need[i][j] < 0)
                    need[i][j] = 0;     // need is initialize to 0 if it is less than 0
            }
        }

        cnt = 0;
        fl = 0;

        while (cnt != n) {
            g = 0;
            for (j = 0; j < n; j++) {

                // check if a process is not finished,
                // this is determined by the flag value 0
                if (flag[j] == 0) {
                    b = 0;
                    for (p = 0; p < r; p++) {
                        if (avail[p] >= need[j][p])
                            b = b + 1;
                        else
                            b = b - 1;
                    }

                    // if all needs of p above are satisfied
                    if (b == r) {
                        System.out.printf("\nP%d is visited", j);
                        seq[fl++] = j;                          // add the process to the seq[] list
                        flag[j] = 1;                            // to indicate the process is in safe mode
                        for (k = 0; k < r; k++)
                            avail[k] = avail[k] + all[j][k];    // add allocation to available since
                        cnt = cnt + 1;                          // increament cnt by 1
                        System.out.printf("(");
                        // the loop displays the available elements
                        for (k = 0; k < r; k++)
                            System.out.printf("%3d", avail[k]);
                        System.out.printf(")");
                        g = 1;
                    }
                }
            }

            // if there is a deadlock display this
            if (g == 0) {
                System.out.printf("\n REQUEST NOT GRANTED -- DEADLOCK OCCURRED");
                System.out.printf("\n SYSTEM IS IN UNSAFE STATE");
                // goto y;
                yes = true;
                break;
            }
        }

        // to implement goto
        // Display this if there is no deadlock.
        if (yes == false) {
            System.out.printf("\nSYSTEM IS IN SAFE STATE");
            System.out.printf("\nThe Safe Sequence is -- (");

            for (i = 0; i < fl; i++)
                System.out.printf("P%d ", seq[i]);

            System.out.printf(")");
        }


        // y:
        System.out.printf("\nProcess\t\tAllocation\t\tMax\t\t\tNeed\n");
        for (i = 0; i < n; i++) {
            System.out.printf("P%d\t", i);
            for (j = 0; j < r; j++)
                System.out.printf("%6d", all[i][j]);
            System.out.print("\t");
            for (j = 0; j < r; j++)
                System.out.printf("%6d", max[i][j]);
            System.out.print("\t");
            for (j = 0; j < r; j++)
                System.out.printf("%6d", need[i][j]);
            System.out.printf("\n");
        }
        input.nextLine();
    }

    public static int userInteractionBankers(){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Your choice to Proceed.");
        System.out.println("Run with : \n1 -> Default values \n\tExcept for Resquested resource.");
        System.out.println("2 ->  User's input Values");
        System.out.println("0 -> Quit");
        int choi = in.nextInt();

        return choi;
    }
}
