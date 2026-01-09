import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int[][] sum;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<Integer> list;
   static Set<int[]> set;  
   static Queue<int[]> qu;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    
    	arr=new int[N][M];
        dp=new int[N][M];
	    for(int i=0;i<N;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int k=0;k<M;k++) {
	    		arr[i][k]=Integer.parseInt(st.nextToken());
	    		dp[i][k]=-1;
	    	}
	    }
	    for(int i=0;i<N;i++) {
	    	for(int k=0;k<M;k++) {
	    		if(dp[i][k]==-1)
	    			DFS(i,k);
	    	}
	    }
	    sum=new int[N][M];
	   for(int i=0;i<N;i++) {
		   for(int k=0;k<M;k++) {
			   int y=dp[i][k]/M;
			   int x=dp[i][k]%M;
			   sum[y][x]++;
		   }
	   }
	   for(int i=0;i<N;i++) {
		   for(int k=0;k<M;k++) {
			   sb.append(sum[i][k]+" ");
		   }
		   sb.append("\n");
	   }
	   System.out.println(sb);

    }
    public static int DFS(int y,int x) {
    	if(dp[y][x]!=-1) 
    		return dp[y][x];
    	
    	int n=arr[y][x];
    	int AY=y;
    	int AX=x;
    	for(int i=0;i<8;i++) {
    		int Y=y+diy[i];
    		int X=x+dix[i];
    		if(!range(Y,X))continue;
    		if(arr[Y][X]<n) {
    			n=arr[Y][X];
    			AY=Y;
    			AX=X;
    		}
    	}
    	
    	if(AY==y&&AX==x) {
    		dp[y][x]=y*M+x;
    		return dp[y][x];
    	}
    	
    	dp[y][x]=DFS(AY,AX);
    	return dp[y][x];

    }
    
    public static boolean range(int y,int x) {
    	if(y<0||y>=N||x<0||x>=M)return false;
    	return true;
    }
}