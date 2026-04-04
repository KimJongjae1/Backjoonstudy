import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int K;
    static int[][] dp;
     static int[][] arr;
     static List<int[]>[] list;
     static boolean[][] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
     static int[] diy= {-1,1,0,0};
     static int[] dix= {0,0,-1,1};
     static boolean flag;
     static int mac;
     static int starbuck;
     static List<Integer> MacList;
     static List<Integer> StarList;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
  
	       StringTokenizer st=new StringTokenizer(br.readLine());
	       N=Integer.parseInt(st.nextToken());
	       M=Integer.parseInt(st.nextToken());
	       list=new ArrayList[N+1];
	       dp=new int[N+1][2];
	       for(int i=1;i<=N;i++) {
	    	   list[i]=new ArrayList<>();
	    	   dp[i][0]=Integer.MAX_VALUE;
	    	   dp[i][1]=Integer.MAX_VALUE;
	       }
	       for(int i=0;i<M;i++) {
	    	   st=new StringTokenizer(br.readLine());
	    	   int u=Integer.parseInt(st.nextToken());
	    	   int v=Integer.parseInt(st.nextToken());
	    	   int E=Integer.parseInt(st.nextToken());
	    	   list[u].add(new int[] {v,E});
	    	   list[v].add(new int[] {u,E});
	    	}
	        	
	       st=new StringTokenizer(br.readLine());
	       int n=Integer.parseInt(st.nextToken());
	       mac=Integer.parseInt(st.nextToken());
	       MacList=new ArrayList<>();
	       st=new StringTokenizer(br.readLine());
	       for(int i=0;i<n;i++) {
	    	   MacList.add(Integer.parseInt(st.nextToken()));
	       }
	       
	       st=new StringTokenizer(br.readLine());
	       n=Integer.parseInt(st.nextToken());
	       starbuck=Integer.parseInt(st.nextToken());
	       StarList=new ArrayList<>();
	       st=new StringTokenizer(br.readLine());
	       for(int i=0;i<n;i++) {
	    	   StarList.add(Integer.parseInt(st.nextToken()));
	       }
	       BFS();
	       ans=0;
	       int min=Integer.MAX_VALUE;
	       for(int i=1;i<=N;i++) {
	
	    	   if(dp[i][0]==0||dp[i][1]==0)continue;
	    	   if(dp[i][0]==Integer.MAX_VALUE||dp[i][1]==Integer.MAX_VALUE)continue;
	    	   min=Math.min(min, dp[i][0]+dp[i][1]);
	    	  
	       }
	       if(min==Integer.MAX_VALUE)System.out.println(-1);
	       else System.out.println(min);   
    }
    public static void BFS() {
    	Queue<int[]> qu=new LinkedList<>();
    	start(qu);
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		int MAX=0;
    		if(cur[2]==0)MAX=mac; 
    		else MAX=starbuck;
    	
    		for(int[] next:list[cur[0]]) {
    			int newcost=next[1]+cur[1];   			
    			if(newcost>MAX)continue;
    			
    			
    			if(dp[next[0]][cur[2]]<=newcost)continue;
    			dp[next[0]][cur[2]]=newcost;
    			qu.offer(new int[] {next[0],newcost,cur[2]});
    		}
    	}
    	
    	
    }
    public static void start(Queue<int[]> qu) {
    	for(int Star:StarList) {
    		qu.offer(new int[] {Star,0,1});
    		dp[Star][1]=0;
    	}
    	for(int MAC:MacList) {
    		qu.offer(new int[] {MAC,0,0});
    		dp[MAC][0]=0;
    	}
    }
 }