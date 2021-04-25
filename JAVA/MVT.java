package com.company;

import java.util.Scanner;

public class MFT {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);

        int ms;                 // to hold memory size available
        int mp[] = new int[10];     // memory required for process
        int i;                  // loop counter
        int temp;               // to hold temporal value
        int n=0;                // loop incremental
        char ch = 'y';          // to store user choice input

        System.out.println("This program is multiprogramming with variable number of task"
                + " A memory management technique where each job is assigned the "
                + "the amount of memory it needs.\n\n\n");

        System.out.println("\nEnter the total memory available (in Bytes)--");
        ms = input.nextInt();
        temp = ms;          // assign hold the values stored in available memory

        // loop for storing values into the mp array
        // and to determine if memory is full
        for(i = 0; ch == 'y'; i++, n++){
            System.out.printf("\nEnter memory required for process %d (in Bytes) -- ",i+1);
            mp[i] = input.nextInt();
            if(mp[i] <= temp){                  // the statement executes if value in mp[i] is less or equals to temp
                System.out.printf("\nMemory is allocated for Process %d ",i+1);
                temp = temp - mp[i];            // computes available memory
            }
            else{
                System.out.printf("\nMemory is Full");
                break;
            }
            System.out.printf("\nDo you want to continue(y/n) -- ");
            String tc = input.next();
            ch = tc.charAt(0);
        }
        System.out.printf("\n\nTotal Memory Available -- %d", ms);

        System.out.printf("\n\n\tPROCESS\t\t MEMORY ALLOCATED ");

        // loop to display values stored in mp variable
        for(i = 0; i < n; i++){
            System.out.printf("\n \t%d\t\t%d",i+1,mp[i]);
        }

        // display allocated memory (ms - temp(which holds the memory size value)).
        System.out.printf("\n\nTotal Memory Allocated is %d",ms-temp);
        System.out.printf("\nTotal External Fragmentation is %d",temp);

        input.nextLine();
    }
}
