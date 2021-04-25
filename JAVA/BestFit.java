package com.company;

import java.util.Scanner;

public class BestFit
 {

    public static void main(String[] args) {
	// write your code here
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
        int bf[] = new int[max];            //
        int ff[]= new int[max];
        int lowest=10000;

        System.out.println("This program is the best fit memory management technique \n"
                + "Job is allocated the block that is closest to the size of the request.\n\n\n\n");

        System.out.printf("\nEnter the number of blocks:");
        nb = in.nextInt();
        System.out.printf("Enter the number of files:");
        nf = in.nextInt();
        System.out.printf("\nEnter the size of the blocks:-\n");
        // storing block size of each block using the loop.
        for(i=1;i<=nb;i++) {
            System.out.printf("Block %d:", i);
            b[i] = in.nextInt();
        }
        System.out.printf("Enter the size of the files :-\n");
        // storing file size of each file in the f array value using loop
        for(i=1;i<=nf;i++)
        {
            System.out.printf("File %d:",i);
            f[i] = in.nextInt();
        }

        for(i=1;i<=nf;i++)
        {
            for(j=1;j<=nb;j++)
            {

                if(bf[j]!=1)            // checking if bf[i] is no allocated
                {
                    temp=b[j]-f[i];     // computing current fragment
                    if(temp>=0)
                        if(lowest>temp)
                        {
                            ff[i]=j;
                            lowest=temp;
                        }
                }
            }
            frag[i]=lowest;
            bf[ff[i]]=1;
            lowest=10000;
        }

        // Displaying the inforamtion on the screen
        System.out.printf("\nFile No\tFile Size \tBlock No\tBlock Size\tFragment");
        for(i=1;i<=nf && ff[i]!=0;i++)
            System.out.printf("\n%d\t\t%d\t\t%d\t\t%d\t\t%d",i,f[i],ff[i],b[ff[i]],frag[i]);
        in.nextLine();
    }
}
