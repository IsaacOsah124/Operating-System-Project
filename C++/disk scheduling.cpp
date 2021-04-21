#include <iostream>
#include<conio.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int main() {
	int choice;
	cout<<"A C++ program to simulate disk scheduling algorithms \n1. FCFS DISK SCHEDULING ALGORITHM \n2. SCAN  DISK SCHEDULING ALGORITHM\n3. C-SCAN DISK SCHEDULING ALGORITHM\n\tEnter your choice: ";
	cin>> choice;
	switch(choice){
	
		case 1: {
			int t[20], n, i, j, tohm[20], tot=0;
            float avhm;
            system("CLS");
            cout<<" FCFS DISK SCHEDULING ALGORITHM";
            cout<<"\nenter the no.of tracks: -- " ;
            cin>>n;
            cout<<"enter the tracks to be traversed: -- ";
            for(i=2;i<n+2;i++)
             cin>>t[i];
            for(i=1;i<n+1;i++)
            {
              tohm[i]=t[i+1]-t[i];
              if(tohm[i]<0)
              tohm[i]=tohm[i]*(-1);
            }
              for(i=1;i<n+1;i++)
               tot+=tohm[i];
               avhm=(float)tot/n;
             cout<<"\nTracks traversed\tDifference between tracks";
             for(i=1;i<n+1;i++)
             cout<<"\n"<< t[i] <<"  \t\t\t"<<tohm[i];
            cout<<"\n\nAverage header movements: " <<avhm;
            getch();
			break;
		}
		
		case 2: {
			system("CLS");
			cout<<"SCAN  DISK SCHEDULING ALGORITHM";
			     int t[20], d[20], h, i, j, n, temp, k, atr[20], tot, p, sum=0;
                 cout<<"enter the no of tracks to be traveresed--";
                 cin>>n;
                 cout<<"enter the position of head--";
                 cin>>h;
                 t[0]=0;t[1]=h;
                 cout<<"enter the tracks--";
                 for(i=2;i<n+2;i++)
                 cin>>t[i];
                   for(i=0;i<n+2;i++)
                     {
                        for(j=0;j<(n+2)-i-1;j++)
                         { if(t[j]>t[j+1])
                          {
                            temp=t[j];
                            t[j]=t[j+1];
                            t[j+1]=temp;
                          } 
						} 
						
					}
                       for(i=0;i<n+2;i++)
                        if(t[i]==h)
                         j=i;k=i;
                         p =0;
                         while(t[j]!=0)
                         {
                           atr[p]=t[j];
                              j--;
                                p++;
                          }
                            atr[p]=t[j];
                            for(p=k+1;p<n+2;p++,k++)
                             atr[p]=t[k+1];
                              for(j=0;j<n+1;j++)
                             {
                               if(atr[j]>atr[j+1])
                               d[j]=atr[j]-atr[j+1];
                              else
                               d[j]=atr[j+1]-atr[j];
                                sum+=d[j];
                                 }
                             cout<<"\nAverage header movements: "<<(sum/n);
                            getch();
			break;
		}
		
		case 3: {
			system("CLS");
			cout<<"C-SCAN DISK SCHEDULING ALGORITHM";
			int t[20], d[20], h, i, j, n, temp, k, atr[20], tot, p, sum=0;
            cout<<"\nEnter the no of tracks to be traveresed--";
            cin>>n;
            cout<<"Enter the position of head--";
            cin>>h;
            t[0]=0;t[1]=h;
            cout<<"Enter total tracks--";
            cin>>tot;
            t[2]=tot-1;
			cout<<"enter the tracks--";
            for(i=3;i<=n+2;i++)
            cin>>t[i];
            for(i=0;i<=n+2;i++)
            for(j=0;j<=(n+2)-i-1;j++)
            if(t[j]>t[j+1])
             {
              temp=t[j];
               t[j]=t[j+1];
              t[j+1]=temp;
             }
            for(i=0;i<=n+2;i++)
               if(t[i]==h)
            j=i;break;
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
           cout<<"\nTotal header movements: "<<sum;
           cout<<"Average Seeking Time is " <<(sum/n);
           getch();

			break;
		}
		
		default : {
			cout<<"Invalid Input\n\tSystem Shutting down";
			break;
		}
	}
	
	
	return 0;
}
