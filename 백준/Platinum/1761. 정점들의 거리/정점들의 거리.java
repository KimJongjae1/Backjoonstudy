import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<int[]>[] list;
    static int parent[][];
    static int dist[][];
    static int depth[];
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;
     
        N=Integer.parseInt(st.nextToken());
        int log=(int)Math.ceil(Math.log(N)/Math.log(2))+1;
        list=new ArrayList[N+1];
     
        parent=new int[N+1][log];
        dist=new int[N+1][log];
        depth=new int[N+1];
        for(int i=1;i<=N;i++){
        	list[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++) {
        	 st=new StringTokenizer(br.readLine()) ;
        	 int a=Integer.parseInt(st.nextToken());
        	 int b=Integer.parseInt(st.nextToken());
        	 int c=Integer.parseInt(st.nextToken());
        	
        	 list[a].add(new int[] {b,c});
        	 list[b].add(new int[] {a,c});
        	 
        }
        dfs(1,1);
        dist[1][0]=1;
        
        for(int k=1;k<log;k++) {
        	for(int i=1;i<=N;i++) {
        		parent[i][k]=parent[parent[i][k-1]][k-1];
        		dist[i][k]=dist[i][k-1]+dist[parent[i][k-1]][k-1];
        	}
        }
        
    
        int M=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++) {
        	 st=new StringTokenizer(br.readLine()) ;
        	 int a=Integer.parseInt(st.nextToken());
        	 int b=Integer.parseInt(st.nextToken());
        	 
        	 if(depth[a]<depth[b]) {
        		 int temp=a;
        		 a=b;
        		 b=temp;
        	 }
        	int ret=0;
        	for(int k=log-1;k>=0;k--) {
        		if(depth[a]-depth[b]>=(1<<k)) {
        			ret+=dist[a][k];
        			a=parent[a][k];
        			
        		}
        	}
        	
        	if(a==b) {
        		sb.append(ret).append("\n");
        		continue;
        	}
        	
        	for(int k=log-1;k>=0;k--) {
        		if(parent[a][k]!=0&&parent[a][k]!=parent[b][k]) {
        			ret+=dist[a][k]+dist[b][k];
        			a=parent[a][k];
        			b=parent[b][k];
        		}
        	}
        	ret+=dist[a][0]+dist[b][0];
        	sb.append(ret).append("\n");
        	 
        }
        System.out.println(sb);
    }
    public static void dfs(int cur,int par) {
    	
    	for(int[] next:list[cur]) {
    		if(par!=next[0]) {
    			depth[next[0]]=depth[cur]+1;
    			parent[next[0]][0]=cur;
    			dist[next[0]][0]=next[1];
    			dfs(next[0],cur);
    		}
    	}
    	
    }
}