import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][][] dp; 
	static int[] dix= {-1,0,1};
	static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
       
        arr=new int[N+1][M];
        dp=new int[N+2][M][3];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
        	for(int k=0;k<M;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        		dp[i][k][0]=Integer.MAX_VALUE;
        		dp[i][k][1]=Integer.MAX_VALUE;
        		dp[i][k][2]=Integer.MAX_VALUE;
        	
        	}
        }
        
        for(int i=0;i<M;i++) {
        	dp[0][i][0]=arr[0][i];
        	dp[0][i][1]=arr[0][i];
        	dp[0][i][2]=arr[0][i];
        	
        }
        //0은 아래 1 왼대각선 2도 대각선 
        for(int i=1;i<N;i++) {
        	for(int k=0;k<M;k++) {
        		if(k==0) {
	        		dp[i][k][0]=dp[i-1][k][1]+arr[i][0];
	        		dp[i][k][1]=Math.min(dp[i-1][k+1][2],dp[i-1][k+1][0])+arr[i][k];
        		}
        		else if(k==M-1) {
        			dp[i][k][0]=dp[i-1][k][2]+arr[i][k];
            		dp[i][k][2]=Math.min(dp[i-1][k-1][0],dp[i-1][k-1][1])+arr[i][k];
        		}
        		else {
	        		dp[i][k][0]=Math.min(dp[i-1][k][2], dp[i-1][k][1])+arr[i][k];
	     			dp[i][k][1]=Math.min(dp[i-1][k+1][0], dp[i-1][k+1][2])+arr[i][k];
	        		dp[i][k][2]=Math.min(dp[i-1][k-1][0], dp[i-1][k-1][1])+arr[i][k];
        		}
        	}
        }
        
        for(int i=0;i<M;i++) {
        	ans=Math.min(Math.min(dp[N-1][i][0], dp[N-1][i][1]), Math.min(dp[N-1][i][2],ans));
        }
        
        System.out.println(ans);
    }
   
}