
import java.io.*;
import java.util.*;

public class Main {
     static int N;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        N=Integer.parseInt(br.readLine());
        
        arr=new int[N+2];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        
        dp=new int[N+2];
        dp[1]=arr[1];
        dp[2]=Math.max(dp[1]*2, arr[2]);
        for(int i=3;i<=N;i++) {
        	for(int k=1;k<i;k++) {
        		int n=i/k;
        		int left=i%k;
        		dp[i]=Math.max(dp[i], dp[k]*n+dp[left]);	
        	}
        	dp[i]=Math.max(dp[i], arr[i]);
        }
        	System.out.println(dp[N]);
    
    }
}