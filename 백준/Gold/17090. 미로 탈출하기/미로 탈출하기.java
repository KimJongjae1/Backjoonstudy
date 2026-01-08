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
   static char[][] arr;
   static int[] dp;
   static long[] sum;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static int[][] OUT;
   static List<Integer> list;
   static Set<int[]> set;  
   static Queue<int[]> qu;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    
    	arr=new char[N][M];
    	
	    for(int i=0;i<N;i++) {
	    	String str=br.readLine();
	    	for(int k=0;k<M;k++) {
	    		arr[i][k]=str.charAt(k);
	    	}
	    }

	    OUT=new int[N][M];
	    for(int i=0;i<N;i++) {
	    	for(int k=0;k<M;k++) {
	    		if(OUT[i][k]==0) {
	    			DFS(i,k,0);
	    		}
	    	}
	    }
	    System.out.println(ans);
    }
    public static int DFS(int y,int x,int cnt) {
    	if(!range(y,x)||OUT[y][x]==2) {
    		ans+=cnt;
    		return 2;
    	}
    	
    	if(OUT[y][x]==1) return 1;
    	OUT[y][x]=1;
    	

    	if(arr[y][x]=='D') {
    		OUT[y][x]=DFS(y+1,x,cnt+1);
    	}else if(arr[y][x]=='U') {
    		OUT[y][x]=DFS(y-1,x,cnt+1);
    	}else if(arr[y][x]=='L') {
    		OUT[y][x]=DFS(y,x-1,cnt+1);
    	}else {
    		OUT[y][x]=DFS(y,x+1,cnt+1);
    	}
    	
    	return OUT[y][x];
    }
    public static boolean range(int y,int x) {
    	if(y<0||y>=N||x<0||x>=M)return false;
    	return true;
    }
}