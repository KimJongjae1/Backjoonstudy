import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int[][][] dp;
     static int[][] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
     static int[] diy= {-1,1,0,0};
     static int[] dix= {0,0,-1,1};
     static boolean flag;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
  

	       StringTokenizer st=new StringTokenizer(br.readLine());
	       N=Integer.parseInt(st.nextToken());
	       arr=new int[N][N];
	       dp=new int[N][N][2];
	       for(int i=0;i<N;i++) {
	    	   String str=br.readLine();
	    	   for(int k=0;k<N;k++) {
	    		   arr[i][k]=str.charAt(k)-'0';
	    		   dp[i][k][0]=1000000;
	    		   dp[i][k][1]=1000000;
	    	   }
	       }
	   
	       BFS();
	       System.out.println(dp[N-1][N-1][1]);
	       
	     
    }
    public static void BFS() {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {0,0,0,0});
    	dp[0][0][0]=0;
    	dp[0][0][1]=0;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		if(dp[cur[0]][cur[1]][1]<cur[3])continue;
    		if(dp[cur[0]][cur[1]][0]<cur[2])continue;
    		
    		for(int i=0;i<4;i++) {
    			int y=cur[0]+diy[i];
    			int x=cur[1]+dix[i];
    			if(y<0||y>=N||x<0||x>=N)continue;
    			
    			int brake=cur[3];
    			if(arr[y][x]==0)brake++;
    			
    			if(dp[y][x][1]<brake)continue;
    			else if(dp[y][x][1]>brake) dp[y][x][1]=brake;
    			else {
    				if(dp[y][x][0]<=cur[2]+1)continue;
    			}
    			dp[y][x][0]=cur[2]+1;
    			dp[y][x][1]=brake;
				qu.offer(new int[] {y,x,cur[2]+1,brake});
    		}
    	}
    	
    }
 }