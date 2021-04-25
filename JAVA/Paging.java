package com.company;

import java.util.Scanner;

public class Paging {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);

        System.out.println("Paging Memory Management Technique\n");

        int ms;                         // to store memory size
        int ps;                         // to store pate size
        int nop;                        // to store pages available
        int np;                         // to store number of processes
        int rempages;                   // to store total number of pages
        int i;                          // loop counter
        int j;                          // loop counter
        int x;                          // to store process number
        int y;                          // to store paging number
        int pa;
        int offset;                     // to store offset
        int s[] = new int[10];          // to store pages required for processes
        int fno[][] = new int[10][20];  // to store pagetables


        System.out.println("The paging memory management technique make use of main memory\n"
                + "and secondary memory which are divided into equal size of  frame and pages\n"
                + "repectively.\n\n\n\n");

        System.out.printf("\nEnter the memory size -- ");
        ms = in.nextInt();
        System.out.printf("\nEnter the page size -- ");
        ps = in.nextInt();
        nop = ms/ps;
        System.out.printf("\nThe no. of pages available in memory are -- %d ",nop);
        System.out.printf("\nEnter number of processes -- ");
        np = in.nextInt();
        rempages = nop;
        for(i=1;i<=np;i++)
        {
            System.out.printf("\nEnter no. of pages required for p[%d]-- ",i);
            s[i] = in.nextInt();
            if(s[i] >rempages)
            {
                System.out.printf("\nMemory is Full");
                break;
            }
            rempages = rempages - s[i];
            System.out.printf("\nEnter pagetable for p[%d] --- ",i);
            for(j=0;j<s[i];j++)
                fno[i][j] = in.nextInt();
        }
        System.out.printf("\nEnter Logical Address to find Physical Address ");
        System.out.printf("\nEnter process no. -- ");

        x = in.nextInt();
        System.out.printf("\nEnter pagenumber -- ");
        y = in.nextInt();
        System.out.printf("\nEnter offset -- ");
        offset = in.nextInt();

        if(x>np || y>=s[i] || offset>=ps)
            System.out.printf("\nInvalid Process or Page Number or offset");
        else
        {
            pa=fno[x][y]*ps+offset;
            System.out.printf("\nThe Physical Address is -- %d",pa);
        }
        in.nextLine();
    }
}
