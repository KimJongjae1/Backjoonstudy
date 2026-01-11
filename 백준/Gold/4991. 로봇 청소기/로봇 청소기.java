import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
   static int[][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<Set<Integer>>[] list;
   static Set<Integer> set;  
   static Queue<int[]> qu;
   static Map<Integer,Integer> map;
   static int[] index;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
        while(true) {
		    StringTokenizer st=new StringTokenizer(br.readLine());
		    M=Integer.parseInt(st.nextToken());
		    N=Integer.parseInt(st.nextToken());
		    if(N==0)break; 
		    arr=new char[N][M];
		    map=new HashMap<>();	
		    idx=1;
		    index=new int[11];

		    for(int i=0;i<N;i++) {
		    	String str=br.readLine();
		    	for(int k=0;k<M;k++) {
		    		arr[i][k]=str.charAt(k);
		    		
		    		if(arr[i][k]=='*') {
		    			index[idx]=i*M+k;
		    			map.put(i*M+k, idx++);

		    		}
		    		 if(arr[i][k]=='o') {
		    			index[0]=i*M+k;
		    			map.put(i*M+k, 0);
		    		 }
		    		
		    	}
		    }
		   dp=new int[map.size()+1][map.size()+1];
		   BFS(0);
		   for(int dirt:map.keySet()) {
			   BFS(map.get(dirt));
		   }
		   
		  
		   
		   ans=Integer.MAX_VALUE;
		   for(int dirt:map.keySet()) {
			   boolean[] v=new boolean[11];
			   int id=map.get(dirt);
			   v[id]=true;
			   if(dp[0][id]==0)continue;
			   BACK(id,1,dp[0][id],v);
		   }
		   
		   if(ans==Integer.MAX_VALUE)System.out.println(-1);
		   else System.out.println(ans);
		   
        }
    }
    public static void BFS(int id) {
    	
    	qu=new LinkedList<>();
    	qu.offer(new int[] {index[id]/M,index[id]%M,0});
    	visit=new boolean[N][M];
    	visit[index[id]/M][index[id]%M]=true;
    	
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		for(int i=0;i<4;i++) {
    			int Y=cur[0]+diy[i];
    			int X=cur[1]+dix[i];
    			if(Y<0||Y>=N||X<0||X>=M)continue;
    			if(visit[Y][X])continue;
    			   visit[Y][X]=true;
    			   
    			if(arr[Y][X]=='x')continue;
    			if(arr[Y][X]=='*') {
    			    int Tidx=map.get(Y*M+X);
    			    dp[id][Tidx]=cur[2]+1;
    			}

    			  qu.offer(new int[] {Y,X,cur[2]+1});
    			
    		}
    	}
    	
    	
    }
    public static void BACK(int cur,int cnt,int Cost,boolean[] v) {
    	if(cnt==map.size()-1) {
    		
    		ans=Math.min(ans, Cost);
    	}else {
    		
    		for(int dirt:map.keySet()) {
    			int id=map.get(dirt);
 
    			if(v[id])continue;
    			if(dp[cur][id]==0)continue;
    			v[id]=true;
    			BACK(id,cnt+1,Cost+dp[cur][id],v);
    			v[id]=false;
    		}
    		
    	}
    }
}