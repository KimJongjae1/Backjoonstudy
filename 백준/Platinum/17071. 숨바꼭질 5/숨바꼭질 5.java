import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
   static int idxB;
   static  StringBuilder sb;
   static int[] arr;
   static int[] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[][] visit;
   static List<Integer> list;
   static Set<Integer>[] set;  
   static Map<Integer,Integer>[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer.parseInt(st.nextToken());
		 K=Integer.parseInt(st.nextToken());
		 list=new ArrayList<>();
		idx=1;
		int n=K;
		list.add(n);
		while(true) {
			n+=idx;
			if(n>500000)break;
			list.add(n);
			idx++;
		}
		 
	

		

		BFS();
		System.out.println(-1);
		
    }
    public static void BFS() {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {N,0});
    	visit=new boolean[500001][2];
    	visit[N][0]=true;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		if(cur[1]>=idx)continue;
    		
    		//System.out.println(cur[0]+" "+cur[1]);
    		int left=cur[1]%2;
    		int k=list.get(cur[1]);
    		
    		if(visit[k][left]) {
    			System.out.println(cur[1]);

    			System.exit(0);
    		}
    		int next=0;
    		if(left==0)next=1;
    		
    		if(cur[0]<500000) {
    			if(!visit[cur[0]+1][next]) {
    				visit[cur[0]+1][next]=true;
    				qu.offer(new int[] {cur[0]+1,cur[1]+1});
    			}
    		}
    		
    		if(cur[0]>0) {
    			if(!visit[cur[0]-1][next]) {
    				visit[cur[0]-1][next]=true;
    				qu.offer(new int[] {cur[0]-1,cur[1]+1});
    			}
    		}
    		
    		if(cur[0]<=250000) {
    			if(!visit[cur[0]*2][next]) {
    				visit[cur[0]*2][next]=true;
    				qu.offer(new int[] {cur[0]*2,cur[1]+1});
    			}
    		}
    	}
    }
}