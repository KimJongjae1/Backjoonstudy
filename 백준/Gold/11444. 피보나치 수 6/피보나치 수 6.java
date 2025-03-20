import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static long N;
    static long[][] hang;
    static long C=1000000007;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		 N=Long.parseLong(br.readLine());
	     hang=new long[2][2];
	     hang[0][0]=1;
	     hang[0][1]=1;
	     hang[1][0]=1;
	     hang[1][1]=0;
	     if(N==1) {
	    	 System.out.println(1);
	    	 return;
	     }else if(N==2) {
	    	 System.out.println(1);
	    	 return;
	     }
	     
	     long[][] ans=time(N-1);
	   
	     System.out.println(ans[0][0]);
	     
   }     
   public static long[][] time(long N) {
	   if(N==1) return hang;
	   
	   long[][] temp=time(N/2);
	   
	   temp=timeprocession(temp,temp);
	   //temp=temp*temp;
	   if(N%2==1) {
		   temp=timeprocession(temp,hang);
	   }
	   
	   return temp;
   }
   
   public static long[][] timeprocession(long[][] temp,long[][] b){
	   long[][] result=new long[2][2];
	   result[0][0]=((temp[0][0]%C)*(b[0][0]%C)+(temp[0][1]%C)*(b[1][0]%C))%C;
	   result[0][1]=((temp[0][0]%C)*(b[0][1]%C)+(temp[0][1]%C)*(b[1][1]%C))%C;
	   result[1][0]=((temp[1][0]%C)*(b[0][0]%C)+(temp[1][1]%C)*(b[1][0]%C))%C;
	   result[1][1]=((temp[1][0]%C)*(b[0][1]%C)+(temp[1][1]%C)*(b[1][1]%C))%C;
	   //temp=temp*temp;                            
	   return result;
	   
   }
}