#include <iostream>
#include<conio.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main() {
	struct file{
	int all[10];
    int max[10];
    int need[10];
    int flag;
	
	};
	
    struct file f[10];
    int fl;
    int i, j, k, p, b, n, r, g, cnt=0, id, newr;
    int avail[10],seq[10];
    system("CLS");
    cout<<" A C++ program to simulate Bankers algorithm for the purpose of deadlock avoidance.";
    cout<<"\nEnter number of processes -- ";
    cin>>n;
    cout<<"\nEnter number of resources -- ";
    cin>>r;
    for(i=0;i<n;i++)
    {
    cout<<"Enter details for P" <<i ;
    cout<<"\nEnter allocation\t -- \t";
    for(j=0;j<r;j++)
    cin>>f[i].all[j];
    cout<<"Enter Max\t\t -- \t";
    for(j=0;j<r;j++)
    cin>>f[i].max[j];
    f[i].flag=0;
   }  
    cout<<"\nEnter Available Resources\t -- \t";
    for(i=0;i<r;i++)
    cin>>avail[i];
    cout<<"\nEnter New Request Details -- ";
    cout<<"\nEnter pid \t -- \t";
    cin>>id;
    cout<<"Enter Request for Resources \t -- \t";
    for(i=0;i<r;i++)
    {
      cin>>newr;
      f[id].all[i] += newr;
      avail[i]=avail[i] - newr;
    }
      for(i=0;i<n;i++)
      {
        for(j=0;j<r;j++)
      {
        f[i].need[j]=f[i].max[j]-f[i].all[j];
        if(f[i].need[j]<0)
        f[i].need[j]=0;
      }
       }
        cnt=0;
        fl=0;
       while(cnt!=n)
      {
       g=0;
      for(j=0;j<n;j++)
      {
       if(f[j].flag==0)
      {
        b=0;
      for(p=0;p<r;p++)
      {
      if(avail[p]>=f[j].need[p])
       b =b+1;
      else
       b=b-1;
       } 
        if(b==r)
       {
       cout<<"\nP"<<j<<" is visited";
        seq[fl++]=j;
        f[j].flag=1;
        for(k=0;k<r;k++)
        avail[k]=avail[k]+f[j].all[k];
        cnt=cnt+1;
        printf("(");
         for(k=0;k<r;k++)
         printf("%3d",avail[k]);
         printf(")");

        g=1;
        } 
        }
          }
        if(g==0)
        {
        cout<<"\n REQUEST NOT GRANTED -- DEADLOCK OCCURRED";
        cout<<"\n SYSTEM IS IN UNSAFE STATE";
        goto y;
        }
        }
        printf("\nSYSTEM IS IN SAFE STATE");
printf("\nThe Safe Sequence is -- (");
for(i=0;i<fl;i++)
printf("P%d ",seq[i]);
printf(")");
 y: printf("\n\nProcess\t\tAllocation\t\t\tMax\t\t\t\tNeed\n");
for(i=0;i<n;i++)
{
printf("P%d\t",i);
for(j=0;j<r;j++)
printf("%6d",f[i].all[j]);
printf("\t\t");
for(j=0;j<r;j++)
printf("%6d",f[i].max[j] );
printf("\t\t");
for(j=0;j<r;j++)
printf("%6d",f[i].need[j]);
printf("\n");
}
         getch();

	return 0;
}
