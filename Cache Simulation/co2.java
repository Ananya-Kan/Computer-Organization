
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class co2 {
	public static void main(String[] args) 
	{ Scanner in= new Scanner(System.in);
      int a=in.nextInt(); //size of cache
      int b=in.nextInt(); //size of block
      int c=a/b;          //no. of cache lines
      int k=in.nextInt();
      int sets=c/k;
      int arr1[][]=new int [(int)(Math.pow(2, 16))/b][b];
      int arr[][]= new int[c][b];
      int tagarr[][]=new int[sets][k];
      for(int i=0;i<sets;i++)
      {  for (int j = 0; j <k; j++) {
		   tagarr[i][j]=-1;
	}
    	  }
      int var[]=new int [sets];
      for (int i = 0; i < var.length; i++) {
    	  var[i]=-1;
		
	}
      int indexx=0;
      int query= in.nextInt();   // no. of queries
      for (int i=0; i<query;i++)
      { String s=in.next();
      String sub= s.substring(0,(int)(16-(Math.log(b)/Math.log(2))));
      int j1= Integer.parseInt(sub,2);
      System.out.println(j1);
      String sub1=s.substring((int)(16-(Math.log(b)/Math.log(2))));
      int j2=Integer.parseInt(sub1,2);
      System.out.println(j2);
      int whichset=j1%sets;
      int choice=in.nextInt();
      if (choice==1)      //for writing data into cache
      { int data= in.nextInt();       
        arr1[j1][j2]=data;
        int pos=0;
        
        for(int p=0;p<k;p++)
        {if(tagarr[whichset][p]==j1) { 
        	indexx=p;//added
            pos=1;
        	}
         }
        
        if(pos==0)
        {   var[whichset]++;

        	arr[k*(whichset%k)+(var[whichset]%k)]=arr1[j1];

        	tagarr[whichset][var[whichset]%k]=j1;
}
        else {

        	arr[indexx][j2]=data;//added

        }

              
      }
      if(choice==0)       //for reading data from cache
      { 
	
    	  int det=0;
          for(int u=0;u<k;u++)
          {if(tagarr[whichset][u]==j1)
        	  det=1;}
          if(det==1)	  
    	  System.out.println("cache hit");
      else
    	  {System.out.println("cache miss");
    	    tagarr[whichset][var[whichset]%k]=j1;
    	    arr[k*(whichset%k)+(var[whichset]%k)]=arr1 [j1];
    	  var[whichset]=var[whichset]+1;//added 
    	  }
        }
      
    
      System.out.println(Arrays.deepToString(arr));
	}
}
}