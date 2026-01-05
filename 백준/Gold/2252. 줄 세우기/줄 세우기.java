import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
   static int[] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[] visit;
   static List<Integer>[] list;
   static Set<int[]> set;  
   static Queue<Integer> qu;
   static int[] indegree;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
 
        list=new ArrayList[N+1];
        indegree=new int[N+1];
        visit=new boolean[N+1];
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }
        
        
        
        for(int i=0;i<M;i++) {
        	 st=new StringTokenizer(br.readLine());
        	 int shrt=Integer.parseInt(st.nextToken());
        	 int tall=Integer.parseInt(st.nextToken());
        	 
        	 list[shrt].add(tall);
        	 indegree[tall]++;
        	 
        }
       DFS();
       System.out.println(sb);
   
    }
    public static void DFS() {
    	qu=new LinkedList<>();
    	for(int i=1;i<=N;i++) {
    		if(indegree[i]==0)qu.offer(i);
    	}
    	
    	while(!qu.isEmpty()) {
    		int cur=qu.poll();
    		sb.append(cur+" ");
    		visit[cur]=true;
    		for(int next:list[cur]) {
    			indegree[next]--;
    			
    			if(indegree[next]==0) {
    				qu.offer(next);
    			}
    		}
    		
    	}
    	for(int i=1;i<=N;i++) {
    		if(!visit[i])sb.append(i+" ");
    	}
    }
}