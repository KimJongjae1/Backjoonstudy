import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;



public class Main {
	static int N;
	static int M;
	static long[][] dp;
	static long[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;
        StringBuilder sb=new StringBuilder();
      
        N=Integer.parseInt(st.nextToken());
        
      
    	dp=new long[2][N];
    	arr=new long[2][N];
    	for(int i=0;i<2;i++) {
    		st=new StringTokenizer(br.readLine()) ;
    		for(int k=0;k<N;k++) {
    			arr[i][k]=Long.parseLong(st.nextToken());
    		}
    	}
    	
    	dp[0][0]=Math.max(arr[0][0], arr[0][0]+arr[1][0]);
    	dp[1][0]=arr[0][0]+arr[1][0];

    	for(int i=1;i<N;i++) {
    		dp[0][i]=Math.max(dp[0][i-1]+arr[0][i], Math.max(dp[0][i-1], dp[1][i-1])+arr[0][i]+arr[1][i]);
    		dp[1][i]=Math.max(dp[1][i-1]+arr[1][i], Math.max(dp[1][i-1], dp[0][i-1])+arr[0][i]+arr[1][i]);
    	}
    	System.out.println(dp[1][N-1]);
    	
    	
    
    }
    
}