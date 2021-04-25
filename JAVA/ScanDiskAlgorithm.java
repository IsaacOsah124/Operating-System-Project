//package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] t = new int[20], d = new int[20],atr = new int[20];
        int h, i, j = 0, n, temp, k, tot, p, sum=0;

        Scanner input = new Scanner(System.in);
        System.out.println("enter the no of tracks to be traveresed");
        n = input.nextInt();

        System.out.println("enter the position of head");
        h = input.nextInt();

        t[0]=0;t[1]=h;
        System.out.println("enter total tracks");
        tot = input.nextInt();
        t[2]=tot-1;

        System.out.println("enter the tracks");
        for(i=3;i<=n+2;i++) {
            t[i] = input.nextInt();
        }
        for(i=0;i<=n+2;i++) {
            for (j = 0; j <= (n + 2) - i - 1; j++) {
                if (t[j] > t[j + 1]) {
                    temp = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = temp;
                }
            }
        }
        for(i=0;i<=n+2;i++) {
            if (t[i] == h)
            {
                j = i;
            }
            break;
        }
        p=0;
        while(t[j]!=tot-1)
        {
            atr[p]=t[j];
            j++;
            p++;
        }
        atr[p]=t[j];
        p++;
        i=0;
        while(p!=(n+3) && t[i]!=t[h])
        {
            atr[p]=t[i];
            i++;
            p++;
        }
        for(j=0;j<n+2;j++)
        {
            if(atr[j]>atr[j+1])
                d[j]=atr[j]-atr[j+1];
            else
                d[j]=atr[j+1]-atr[j];
            sum+=d[j];

        }
        System.out.println("total header movements " + sum);
        System.out.println("Avg is " + (float)sum/n);
    }
}
