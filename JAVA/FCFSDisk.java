package com.company;

import java.util.Scanner;

public class FCFSDick
 {

    public static void main(String[] args) {
	// write your code here
        int[] tracksTrav = new int[20];
        int []diffTracks = new int[20];
        int noTracks, i, tot = 0;
        float avgheaderMov;
        Scanner input = new Scanner(System.in);

        System.out.println("enter the no.of tracks");
        noTracks = input.nextInt();

        System.out.println("enter the tracks to be traversed");
        for(i=2; i<noTracks+2; i++){
            tracksTrav[i] = input.nextInt();
        }

        for(i=1;i<noTracks+1; i++)
        {
            diffTracks[i]=tracksTrav[i+1]-tracksTrav[i];
            if(diffTracks[i]<0)
                diffTracks[i]=diffTracks[i]*(-1);
        }

        for(i=1;i<noTracks+1;i++)
        {
            tot += diffTracks[i];
        }
        avgheaderMov=(float)tot/noTracks;

        System.out.println("Tracks traversed\tDifference between tracks\n");
        for(i=1;i<noTracks+1;i++){
            System.out.println(tracksTrav[i] +"\t\t\t\n"+ diffTracks[i]);
        }

        System.out.println("\nAverage header movements: "+ avgheaderMov);
    }
}
