import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,-1,1};
   static boolean[] visit;
   static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
       arr=new int[N+1][N+1];
       list=new ArrayList[N+1];
       for(int i=1;i<=N;i++)
    	   list[i]=new ArrayList<>();
        for(int i=0;i<N-1;i++) {
        	st=new StringTokenizer(br.readLine());
        	int p=Integer.parseInt(st.nextToken());
        	int q=Integer.parseInt(st.nextToken());
        	int r=Integer.parseInt(st.nextToken());
        	arr[p][q]=r;
        	arr[q][p]=r;
        	list[p].add(q);
        	list[q].add(p);
        }
        visit=new boolean[N+1];
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	int k=Integer.parseInt(st.nextToken());
        	int v=Integer.parseInt(st.nextToken());
        	Arrays.fill(visit, false);
        	visit[v]=true;
        	DFS(v,v,Integer.MAX_VALUE, k);
        	int cnt=0;
        	for(int q=1;q<=N;q++) {
        		if(arr[v][q]>=k)cnt++;
        	}
        	sb.append(cnt+"\n");
        }
        
        
        
        System.out.println(sb);
        
    }
    public static void DFS(int S,int cur,int min,int k) {
    	
    	for(int next:list[cur]) {
    		if(visit[next])continue;
    		visit[next]=true;
    		int USADO=Math.min(min,arr[cur][next]);
    		if(k>USADO)continue;
    		arr[S][next]=USADO;
    		DFS(S,next,USADO,k);
    		
    	}
    	
    	
    }
}