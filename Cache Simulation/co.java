import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class co {
	public static void main(String[] args) 
	{ Scanner in= new Scanner(System.in);
      int a=in.nextInt(); //size of cache
      int b=in.nextInt(); //size of block
      int c=a/b;          //no. of cache lines
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
      if (choice==1)      //for writing data into cache
      { int data= in.nextInt();       
        arr1[j1][j2]=data;
        arr[j1%c][j2]=data;        
      }
      if(choice==0)       //for reading data from cache
      { if(arr[j1%c][j2]==arr1[j1][j2]&& arr[j1%c][j2]!=0 && arr1[j1][j2]!=0)
    	  System.out.println("cache hit");
      else
    	  {System.out.println("cache miss");
    	    
    	  arr[j1%c]=arr1 [j1];
    	  
    	  }
     
      }
      System.out.println(Arrays.deepToString(arr));
      }
      
	}
}
