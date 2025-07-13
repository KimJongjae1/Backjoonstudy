import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N;
	static int K;
	public static List<List<int[]>> list;
	public static PriorityQueue<Integer>[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());
        
        list=new ArrayList<>();
        for(int i=0;i<=N;i++) {
        	list.add(new ArrayList<>());
        }
        for(int i=1;i<=M;i++) {
        	 st=new StringTokenizer(br.readLine());
        	int start=Integer.parseInt(st.nextToken());
        	int end=Integer.parseInt(st.nextToken());
        	int cost=Integer.parseInt(st.nextToken());
        	list.get(start).add(new int[] {end,cost});
        }
        
     
        dij();
        StringBuilder sb=new StringBuilder();
    
        for(int i=1;i<=N;i++) {
        	if(dist[i].size()<K) sb.append(-1).append("\n");
        	else sb.append(dist[i].peek()).append("\n");
 
        }
        System.out.println(sb);
    }
    public static void dij() {
    	PriorityQueue<int[]> qu=new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a,int[] b) {
    			if(a[1]!=b[1]) return Integer.compare(a[1], b[1]);
    			else return Integer.compare(a[0], b[0]);
    		}
    	});
    	 dist=new PriorityQueue[N+2];
    	for(int i=1;i<=N+1;i++) {
    		dist[i]=new PriorityQueue<>(Collections.reverseOrder());
    	}
    	qu.offer(new int[] {1,0});
    	dist[1].add(0);
    	while(!qu.isEmpty()) {
    		int[] now=qu.poll();
    		
    		for(int[] next:list.get(now[0])) {
    			if(dist[next[0]].size()<K) {
    				dist[next[0]].add(next[1]+now[1]);
    				qu.offer(new int[] {next[0],now[1]+next[1]});
    			}
    			else if(dist[next[0]].peek()>next[1]+now[1]) {
    				dist[next[0]].poll();
    				dist[next[0]].add(next[1]+now[1]);
    				qu.offer(new int[] {next[0],now[1]+next[1]});
    			}
    		}
    		
    	}
    	
    }
}