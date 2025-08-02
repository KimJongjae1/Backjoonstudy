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
    static int K;
    static List<int[]>[] list;
   static class node implements Comparable<node>{
    	long cost;
    	int now;
    	int k;
    	
    	node(int now,long cost,int k){
    		this.now=now;
    		this.cost=cost;
    		this.k=k;
    	}
    	
    	public int compareTo(node a) {
    		if(a.cost!=this.cost)return Long.compare(this.cost, a.cost);
			else return this.k-a.k;
    	}
    }
  
    
    
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;
        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
         K=Integer.parseInt(st.nextToken());

        list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
        	 st=new StringTokenizer(br.readLine()) ;
        	 int a=Integer.parseInt(st.nextToken());
        	 int b=Integer.parseInt(st.nextToken());
        	 int c=Integer.parseInt(st.nextToken());
        	 list[a].add(new int[] {b,c});
        	 list[b].add(new int[] {a,c});
        
        }
       
        long ret=dij();
        
        System.out.println(ret);
        

    }
    public static long dij() {
    	PriorityQueue<node> pq=new PriorityQueue<>();
    	pq.offer(new node(1,0,0));
    	long[][] dist=new long[N+1][K+1];
    	for(int i=1;i<=N;i++)
    	Arrays.fill(dist[i], Long.MAX_VALUE);
    	dist[1][0]=0;
    	while(!pq.isEmpty()) {
    		node now=pq.poll();
    		int cur=now.now;
    		int k=now.k;
    		
    		if(dist[cur][k]<now.cost)continue;
    		
    		for(int[] next:list[cur]) {
    			long cost=now.cost;
    			int pack=k;
    			
    			if(pack+1<=K) {
    				pack++;
    				if(dist[next[0]][pack]>cost) {
    					dist[next[0]][pack]=cost;
    					pq.offer(new node(next[0],dist[next[0]][pack],pack));
    				}
    			}
    			
    			if(dist[next[0]][k]>cost+(long)next[1]) {
    				dist[next[0]][k]=cost+(long)next[1];
    				pq.offer(new node(next[0],dist[next[0]][k],k));
    			}
    				
    			
    		}

    }
    	long ret=Long.MAX_VALUE;
    	for(int i=0;i<=K;i++) {
    		ret=Math.min(ret, dist[N][i]);
    	}
    	return ret;
    }
}