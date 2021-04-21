#include <iostream>
#include<stdio.h>
#include<conio.h> 
#include <iomanip>
# define max 25 

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main() { 
int frag[max],b[max],f[max],i,j,nb,nf,temp;  
static int bf[max],ff[max];  
 
 cout<<"\n\tMemory Management Scheme - First Fit";  
 cout<<"\nEnter the number of blocks:";  
 cin>>nb;  
 cout<<"Enter the number of files:";  
 cin>>nf;  
 cout<<"\nEnter the size of the blocks:-\n";  
 for(i=1;i<=nb;i++) 
  { 
  cout<<"Block :"+ i; 
  cin>>b[i]; 
  }  
  cout<<"Enter the size of the files :-\n";  
  for(i=1;i<=nf;i++)  {
   cout<<"File:"+ i ; 
   cin>>f[i]; 
   }  
   for(i=1;i<=nf;i++)  
   {    
   for(j=1;j<=nb;j++)    
   { if(bf[j]!=1)      
   {   
   temp=b[j]-f[i]; 
   if(temp>=0)          
    { 
	ff[i]=j; 
 break;        
 }     
  }   
   } 
	   frag[i]=temp; bf[ff[i]]=1; 
	    }
		  cout<<"\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement";  
		  for(i=1;i<=nf;i++)   
		  cout<<"\n\t\t\t\t\t\t\t\t",i,f[i],ff[i],b[ff[i]],frag[i];  
		  getch(); 
	
	
	
	return 0;
}
