package com.company;

import java.util.Scanner;

public class FirstFit {

    public static void main(String[] args) {
	// write your code here
        // Create an instance of the scanner class.

        Scanner in = new Scanner(System.in);

        // Variables
        final int max = 25;                 // the size of the arrays
        int frag[] = new int[max];          // to hold the fragments
        int b[] = new int[max];             // to hold the block size
        int f[] = new int[max];             // to hold the size of the files
        int i;                              // loop counter
        int j;                              // loop counter
        int nb;                             // to hold number of block
        int nf;                             // to hold number of files
        int temp = 0;                       // to temporally hold fragment value
        int highest=0;
        int bf[] = new int[max];            //
        int ff[]= new int[max];


        System.out.println("This program is the first fit memory management technique\n"
                + "Job is allocated the first memory block that is large enough.\n\n\n");

        System.out.printf("\n\tMemory Management Scheme - Worst Fit");
        System.out.printf("\nEnter the number of blocks:");
        nb = in.nextInt();
        System.out.printf("Enter the number of files:");
        nf = in.nextInt();
        System.out.printf("\nEnter the size of the blocks:-\n");
        // looping to store each block size in b[] array variable.
        for(i=1;i<=nb;i++)
        {
            System.out.printf("Block %d :",i);
            b[i] = in.nextInt();
        }
        System.out.printf("Enter the size of the files :-\n");
        // storing each file size in f[] array variable using a for loop.
        for(i=1;i<=nf;i++)
        {
            System.out.printf("File %d:",i);
            f[i] = in.nextInt();
        }
        for(i=1;i<=nf;i++)
        {
            for(j=1;j<=nb;j++)
            {
                if(bf[j]!=1) //if bf[j] is not allocated
                {
                    temp=b[j]-f[i];     // get the current fragments
                    if(temp>=0)
                        if(highest<temp)
                        {
                            ff[i]=j;
                            highest=temp;
                        }
                }
            }
            frag[i]=highest;
            bf[ff[i]]=1;
            highest=0;
        }

        // Display format
        System.out.printf("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement");

        // Displaying results using loop.
        for(i=1;i<=nf;i++)
            System.out.printf("\n%d\t\t%d\t\t%d\t\t%d\t\t%d",i,f[i],ff[i],b[ff[i]],frag[i]);
        in.nextLine();
    }
}
