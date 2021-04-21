#include <iostream>
#include<stdio.h>
#include<conio.h> 
using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
 
int ms, ps, nop, np, rempages, i, j, x, y, pa, offset;  int s[10], fno[10][20]; 
 
 cout<<"\n A program to simulate paging technique of memory management";
 cout<<"\nEnter the memory size -- ";  
 cin>>ms; 
 
 cout<<"\nEnter the page size -- ";  
 cin>>ps; 
 
 nop = ms/ps;  
 cout<<"\nThe no. of pages available in memory are --- " << nop; 
 
 cout<<"\nEnter number of processes --- ";  
 cin>>np; 
 
 rempages = nop; 
 
 for(i=1;i<=np;i++)  { 
 
  cout<<"\nEnter no. of pages required for p[" << i <<"]---";   
  cin>>s[i]; 
 
  if(s[i] >rempages)   {    
  cout<<"\nMemory is Full";
  break;   
  }   
  rempages = rempages - s[i]; 
 
  cout<<"\nEnter pagetable for p[" << i << "]---";   
  for(j=0;j<s[i];j++)    
  cin>>fno[i][j];  
  } 
 
 cout<<"\nEnter Logical Address to find Physical Address ";  
 cout<<"\nEnter process no: --- ";
 cin>>x;
 cout<<"Enter Pagenumber: ";
 cin>>y;
 cout<<"Enter offset --  "; 
 cin>>offset; 
 
 
 if(x>np || y>=s[i] || offset>=ps)   
 cout<<"\nInvalid Process or Page Number or offset";  

 else  {  
      pa=fno[x][y] * ps + offset;
      cout<<"\nThe Physical Address is --- " << pa ;  
 } 
  
	return 0;
}
