import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
   static int N;
   static int M;
   static int ret;
   static boolean cycle;
   static int[][] arr;
   static int[][] dp;
   static boolean[][] visit;
   static int[] dix= {-1,1,0,0};
   static int[] diy= {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
     	  N=Integer.parseInt(st.nextToken());
    	  M=Integer.parseInt(st.nextToken());
    	  
    	   arr=new int[N][M];
    	   for(int i=0;i<N;i++) {
    		   String str=br.readLine();
    		   for(int k=0;k<M;k++) {
    			   if(str.charAt(k)=='H')arr[i][k]=-1;
    			   else arr[i][k]=str.charAt(k)-'0';
    		   }
    	   }
    	   ret=0;
    	   dp=new int[N][M];
    	 visit=new boolean[N][M];
    	 visit[0][0]=true;
    	 DFS(0,0,0);
    	 if(cycle)System.out.println(-1);
    	 else System.out.println(ret);
    }
    public static void DFS(int y,int x,int move) {
    	if(cycle) {
    		return;
    	}
    	dp[y][x]=move;
    	for(int i=0;i<4;i++) {
    		int Y=y+diy[i]*arr[y][x];
    		int X=x+dix[i]*arr[y][x];
    		if(Y<0||Y>=N||X<0||X>=M||arr[Y][X]==-1) {
        		ret=Math.max(ret, move+1);
        		continue;
        	}
    		if(visit[Y][X]) {
    			cycle=true;
    			return;
    		}
      		if(dp[Y][X]>move) continue;
    		visit[Y][X]=true;
    		DFS(Y,X,move+1);
    		if(cycle)return;
    		visit[Y][X]=false;
    		
    	}
    }
}