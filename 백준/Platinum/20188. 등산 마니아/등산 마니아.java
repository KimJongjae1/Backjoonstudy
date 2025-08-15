import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;



public class Main { 
    static int N;
    static int[] team;
    static Set<Integer>[] set;
    static List<Integer>[] list;
    static int[] dist;
    static int[][] parent;
    static int log;
    public static void main(String[] args) throws Exception {
    	StringBuilder sb=new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
        team=new int[N+1];
       log=(int)Math.ceil(Math.log(N)/Math.log(2))+1;
        parent=new int[N+1][log];
        list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++) {
        	 st=new StringTokenizer(br.readLine()) ;
        	 int a=Integer.parseInt(st.nextToken());
        	 int b=Integer.parseInt(st.nextToken());
        	 
        	 list[a].add(b);
        	 list[b].add(a);
        }
        
        bfs();

        for(int i=1;i<log;i++) {
        	for(int k=1;k<=N;k++) {
        		parent[k][i]=parent[parent[k][i-1]][i-1];
        	}
        }
        
        
        
        long ret=0;
        for(int i=2;i<=N;i++) {
        	ret+=dist[i];
        }
        
        for(int i=2;i<N;i++) {
        	for(int k=i+1;k<=N;k++) {
        		int par=LCA(i,k);
        		int ItoKdist=dist[i]+dist[k]-dist[par];
        		
        		ret+=ItoKdist;
        	}
        }
        System.out.println(ret);
    }
    public static void bfs() {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {1,1});
    	dist=new int[N+1];
    	while(!qu.isEmpty()) {
    		int[] now=qu.poll();
    		
    		for(int next:list[now[0]]) {
    			if(next==now[1]) continue;
    			parent[next][0]=now[0];
    			dist[next]=dist[now[0]]+1;
    			qu.offer(new int[] {next,now[0]});
    		}
    	}
    }
    public static int LCA(int n1,int n2) {
    	int a=n1;
    	int b=n2;
    	if(dist[a]<dist[b]) {
    		int temp=a;
    		a=b;
    		b=temp;
    	}
    	
    	for(int i=log-1;i>=0;i--) {
    		if(dist[a]-dist[b]>=(1<<i)) {
    			a=parent[a][i];
    		}
    	}

    	if(a==b) return a;
    	
    	for(int i=log-1;i>=0;i--) {
    		if(parent[a][i]!=0&&parent[a][i]!=parent[b][i]) {
    			a=parent[a][i];
    			b=parent[b][i];
    		}
    	}
    	return parent[a][0];
    }
    
    
    
  }
 