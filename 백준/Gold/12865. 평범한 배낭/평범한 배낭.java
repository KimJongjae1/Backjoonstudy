import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        cost=new int[N+1][2];
        for(int i=1;i<=N;i++) {
        	 st=new StringTokenizer(br.readLine());
        	 int a =Integer.parseInt(st.nextToken());
             int b=Integer.parseInt(st.nextToken());
        	 cost[i][0]=a;
        	 cost[i][1]=b;
             
        }
        
    	dp=new int[N+1][K+1];
    	
    	for(int i=1;i<=K;i++) {//x좌표
    		for(int k=1;k<=N;k++) {//y좌표
    			if(i-cost[k][0]>=0) {
    				dp[k][i]=Math.max(cost[k][1]+dp[k-1][i-cost[k][0]], Math.max(dp[k-1][i], dp[k][i-1]));
    			}else {
    				dp[k][i]=Math.max(dp[k-1][i], dp[k][i-1]);
    			}
    			
    		}
    	}
    	System.out.println(dp[N][K]);
    } 
   
    
 }