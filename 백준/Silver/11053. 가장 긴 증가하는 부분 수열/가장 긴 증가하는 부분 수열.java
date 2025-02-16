import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N=Integer.parseInt(br.readLine());
         StringTokenizer st = new StringTokenizer(br.readLine());	    
	     int[] arr= new int[N];
	     int[] dp = new int[N];
	     for(int i=0;i<N;i++) {
	    	 arr[i]=Integer.parseInt(st.nextToken());
	     }
	     
	     Arrays.fill(dp,1);
	     for(int i=0;i<N;i++) {
	    	 
	    	 for(int k=0;k<i;k++) {
	    		 if(arr[k]<arr[i]&&dp[i]==dp[k])
	    			 dp[i]=dp[k]+1;
	  
	    	 }
	     }
	     Arrays.sort(dp);
	     System.out.println(dp[N-1]);
	
	     //10 100 10 20 30 40 50 30 70 50
	     //1   2   1  2
	     //10 20 10 1 2 3 4 30 20 50
	     //1   2  1 1 2 3 4 5  5   6   
		
	}
  }