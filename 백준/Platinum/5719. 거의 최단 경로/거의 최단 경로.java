import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
    static List<List<int[]>> list;
    static List<Integer>[] remove;
    static int[] dist;
    static int min;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        while(true) {
	        StringTokenizer st=new StringTokenizer(br.readLine());
	         N = Integer.parseInt(st.nextToken());
	         M = Integer.parseInt(st.nextToken());
	       
	         if(N==0) break;
	         list=new ArrayList<>();
	         remove=new ArrayList[N];
	         for(int i=0;i<N;i++) {
	        	 list.add(new ArrayList<>());
	        	 remove[i]=new ArrayList<>();
	         }
	         st=new StringTokenizer(br.readLine());
	         int s=Integer.parseInt(st.nextToken());
	         int e=Integer.parseInt(st.nextToken());
	       
	        for(int i=0;i<M;i++) {
	        	st=new StringTokenizer(br.readLine());
	           int a=Integer.parseInt(st.nextToken());
	           int b=Integer.parseInt(st.nextToken());
	           int cost=Integer.parseInt(st.nextToken());
	           
	           list.get(a).add(new int[] {b,cost});
	        }
	      
	        visit=new boolean[N][N];
	         dij(s,e);
	         min=dist[e];
	       
	         dfs(s,e);
	         dij(s,e);
	         if(dist[e]==Integer.MAX_VALUE)sb.append(-1+"\n");
	         else sb.append(dist[e]+"\n");
	        
        }
        System.out.println(sb);
    }
    public static void dij(int s,int e) {
    	PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a,int[] b) {
    			if(a[1]!=b[1])return a[1]-b[1];
    			else return a[0]-b[0];
    		}
    	}); 
    	pq.offer(new int[] {s,0});

    	dist=new int[N];
    	Arrays.fill(dist,Integer.MAX_VALUE);
    	dist[s]=0;
    	
    	while(!pq.isEmpty()) {
    		int[] now=pq.poll();
    		if(dist[now[0]]<now[1]) continue;
    		
    		for(int[] next:list.get(now[0])) {
    			if(visit[now[0]][next[0]]) continue;
    			int c=next[1]+now[1];
    			if(dist[next[0]]>c) {
    				dist[next[0]]=c;
    				remove[next[0]]=new ArrayList<>();
    				remove[next[0]].add(now[0]);
    				pq.offer(new int[] {next[0],c});
    			}else if(dist[next[0]]==c) {
    				remove[next[0]].add(now[0]);

    			}
    		}
    	}
    }
    
    public static void dfs(int cur,int end) {
    	if(cur==end) {
    		return;
    	}
    	for(int next:remove[end]) {
    		if(!visit[next][end]) {
    			visit[next][end]=true;
    			dfs(cur,next);
    		}
    	}
    	
    }
}
