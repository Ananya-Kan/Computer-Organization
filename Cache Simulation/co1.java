
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class co1
{
	public static void main(String[] args) 
	{ Scanner in= new Scanner(System.in);
      int a=in.nextInt(); //size of cache
      int b=in.nextInt(); //size of block
      int c=a/b;          //no. of cache lines
      int tagarr[]= new int [c];
      for(int i=0;i<c;i++)
      {tagarr[i]=-1;}
      int var=-1;
      int arr1[][]=new int [(int)(Math.pow(2, 16))/b][b];
      int arr[][]= new int[c][b];
      int query= in.nextInt();   // no. of queries
      for (int i=0; i<query;i++)
      { String s=in.next();
      String sub= s.substring(0,(int)(16-(Math.log(b)/Math.log(2))));
      int j1= Integer.parseInt(sub,2);
      System.out.println(j1);
      String sub1=s.substring((int)(16-(Math.log(b)/Math.log(2))));
      int j2=Integer.parseInt(sub1,2);
      System.out.println(j2);
      int choice=in.nextInt();
      int indexx=0;
      
      if (choice==1)      //for writing data into cache
      { int data= in.nextInt();       
        arr1[j1][j2]=data;
        
        int pos=0;
        for(int k=0;k<c;k++)
        {if(tagarr[k]==j1) { 
        	indexx=k;//added
            pos=1;
        	}
         }
        
        if(pos==0)
        {   var++;

        	arr[var%c]=arr1[j1];

        	tagarr[var%c]=j1;
}
        else {

        	arr[indexx][j2]=data;//added

        }

       
      }
      if(choice==0)       //for reading data from cache
      {   int det=0;
          for(int u=0;u<c;u++)
          {if(tagarr[u]==j1)
        	  det=1;}
          if(det==1)	  
    	  System.out.println("cache hit");
      else
    	  {System.out.println("cache miss");
    	    tagarr[var%c]=j1;
    	    arr[var%c]=arr1 [j1];
    	  var=var+1;//added
    	  }
        }

      System.out.println(Arrays.deepToString(arr));
//      System.out.println();
      }
	}
}