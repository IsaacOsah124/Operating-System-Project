package com.company;

import java.util.Scanner;

public class MFT {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        // Variable declaration
        int ms;                 // to hold memory size
        int bs;                 // to hold block size
        int nob;                // to hold number of blocks
        int ef;                 // to store external memory
        int n;                  // to hold the number of process
        int mp[] = new int[10]; // memory required for process
        int tif=0;              // total internal fragmentation
        int i;                  // loop counter
        int p=0;                // incremental variable that determines the end of nob.


        System.out.println("This program is multiprogramming fixed number of task. "
                + "\nMemory is divided into fixed number of partition and "
                + "\neach job is assigned to a partition.\n\n\n");

        System.out.println("Enter the total memory available (in Bytes) --");
        ms = input.nextInt();
        System.out.println("Enter the block size in (Bytes) --");
        bs = input.nextInt();
        nob = ms / bs;          // calculates the number of blocks by
                                // dividing available memory by block size.

        ef = ms - nob * bs;     // calculates the eternal fragmentation
                                // determined by subtracting (number of block multiply by block size)
                                // from available memory.

        System.out.println("Enter the number of processes --");
        n = input.nextInt();

        // loop to store memory required values into the mp array variable
        for(i = 0; i < n; i++){
            System.out.printf("Enter memory required for process %d (in Bytes)--", i+1);
            mp[i] = input.nextInt();
        }


        System.out.printf("\nNo. of blocks available in memory -- %d", nob);
        System.out.println("\n\nPROCESS\tMEMORY REQUIRED\t ALLOCATED\tINTERNAL FRAGMENTATION");

        // loop to display the process required and to compute the total internal fragment
        for(i = 0; i < n && p < nob; i++){
            System.out.printf("\n %d\t\t%d",i+1,mp[i]);
            if(mp[i] > bs){
                System.out.println("\t\tNO\t\t---");
            }
            else{
                System.out.printf("\t\tYES\t%d",bs-mp[i]);
                tif = tif + bs - mp[i];
                p++;
            }

        }

        // display information if expression is true
        if(i<n)
            System.out.println("\nMemory is Full, Remaining Process cannot be accomadated");


        System.out.println("\\n\\nTotal Number of Memory available is" + ms);
        System.out.println("\\n\\nTotal Number of Block size is "+ bs);
        System.out.printf("\n\nTotal Internal Fragmentation is %d",tif);
        System.out.printf("\nTotal External Fragmentation is %d",ef);
        input.nextLine();

    }
}
