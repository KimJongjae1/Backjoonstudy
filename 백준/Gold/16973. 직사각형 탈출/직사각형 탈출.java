import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int K;
    static int[][][] dp;
     static int[][] arr;
     static List<Integer>[] list;
     static boolean[][] visit;
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
	       M=Integer.parseInt(st.nextToken());


	       arr=new int[N][M];
	          
	       for(int i=0;i<N;i++) {
	    	   st=new StringTokenizer(br.readLine());
	    	   for(int k=0;k<M;k++) {
	    		   arr[i][k]=Integer.parseInt(st.nextToken());
	    	   }
	       }
	       
	       st=new StringTokenizer(br.readLine());
	       int H=Integer.parseInt(st.nextToken());
	       int W=Integer.parseInt(st.nextToken());
	       int Sr=Integer.parseInt(st.nextToken())-1;
	       int Sc=Integer.parseInt(st.nextToken())-1;
	       int Fr=Integer.parseInt(st.nextToken())-1;
	       int Fc=Integer.parseInt(st.nextToken())-1;
	       for(int i=0;i<N-H+1;i++) {
	    	   for(int k=0;k<M-W+1;k++) {
	    		   if(arr[i][k]==1)continue;
	    		   if(!check(i,k,H,W))
	    			   arr[i][k]=1;
	    	   }
	       }
	      for(int i=N-H+1;i<N;i++) 
	    	  Arrays.fill(arr[i], 1);
	      
	       for(int i=0;i<N-1;i++) {
	    	   for(int k=M-W+1;k<M;k++) {
	    		   arr[i][k]=1;
	    	   }
	       }
	    	   
	    	   
	       BFS(Sr,Sc,Fr,Fc);
	      
    }
    public static boolean check(int y,int x,int H,int W) {
    	
    	for(int i=y;i<y+H;i++) {
    		for(int k=x;k<x+W;k++) {
    			if(arr[i][k]==1)return false;
    		}
    	}
    	return true;
    }
    public static void BFS(int Sr,int Sc,int Fr,int Fc) {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {Sr,Sc,0});
    	visit=new boolean[N][M];
    	visit[Sr][Sc]=true;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		if(cur[0]==Fr&&cur[1]==Fc) {
    			System.out.println(cur[2]);
    			return;
    		}
    		for(int i=0;i<4;i++) {
    			int y=cur[0]+diy[i];
    			int x=cur[1]+dix[i];
    			if(y<0||y>=N||x<0||x>=M)continue;
    			if(arr[y][x]==1)continue;
    			if(visit[y][x])continue;
    			visit[y][x]=true;
    			qu.offer(new int[] {y,x,cur[2]+1});
    			
    		}
    	}
    	System.out.println(-1);
    }
 }