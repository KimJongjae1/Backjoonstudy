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
   static boolean[][] visit;
   static List<Integer>[] list;
   static Set<int[]> set;  
   static int[] indegree;
   static int[] cost;
   static Queue<int[]> qu;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        indegree=new int[N+1];
        cost=new int[N+1];
        dp=new int[N+1];
        qu=new LinkedList<>();
        list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) 
        	list[i]=new ArrayList<>();
        
        for(int i=1;i<=N;i++) {       	
            st=new StringTokenizer(br.readLine());
            int co=Integer.parseInt(st.nextToken());
            //dp[i]=Integer.MAX_VALUE;
            cost[i]=co;
            dp[i]=co;

            while(st.hasMoreElements()) {
            	int n=Integer.parseInt(st.nextToken());
            	if(n==-1)break;
            	indegree[i]++;
            	list[n].add(i);
            }
            if(indegree[i]==0) {
            	qu.offer(new int[] {i,co});
            	dp[i]=co;
            }
        }
        DFS();
        for(int i=1;i<=N;i++) {
        	sb.append(dp[i]+"\n");
        }
        System.out.println(sb);
    }
    public static void DFS() {

    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		for(int next:list[cur[0]]) {
    			indegree[next]--;
    			dp[next]=Math.max(dp[cur[0]]+cost[next], dp[next]);
    				
    			if(indegree[next]==0) {
    				qu.offer(new int[] {next,dp[next]});
    			}
    		}
    		
    	}
    	
    }
}