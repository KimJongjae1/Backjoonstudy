import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static List<int[]>[] child;
	public static int[][] parent;
	public static int[][] max;
	public static int[][] min;
	public static int[] depth;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
	
			StringTokenizer st=new StringTokenizer(br.readLine());  		 
			 
			 N=Integer.parseInt(st.nextToken());
			 child=new ArrayList[N+1];
			 for(int i=0;i<=N;i++) {
				 child[i]=new ArrayList<>();
			 }
			 int log=(int)Math.ceil(Math.log(N)/Math.log(2))+1;
			 
			 parent=new int[N+1][log];
			 max=new int[N+1][log];
			 min=new int[N+1][log];
			 depth=new int[N+1];
			 
			 for(int i=0;i<N-1;i++) {
				 st=new StringTokenizer(br.readLine());  
				 int a=Integer.parseInt(st.nextToken());
				 int b=Integer.parseInt(st.nextToken());
				 int cost=Integer.parseInt(st.nextToken());
				 child[a].add(new int[] {b,cost});
				 child[b].add(new int[] {a,cost});
			}
			
			 depth[1]=1;
			 dfs(1,1);
			 min[1][0]=Integer.MAX_VALUE;
			 for(int i=1;i<log;i++) {
				 for(int k=1;k<=N;k++) {
					 parent[k][i]=parent[parent[k][i-1]][i-1];
					 
					 max[k][i]=Math.max(max[k][i-1],max[parent[k][i-1]][i-1]);
					 min[k][i]=Math.min(min[k][i-1],min[parent[k][i-1]][i-1]);
				 }
			 }
			 
			 
			 
			 int M=Integer.parseInt(br.readLine());
			 StringBuilder sb=new StringBuilder();
			 for(int i=0;i<M;i++) {
				 st=new StringTokenizer(br.readLine());  
				 int a=Integer.parseInt(st.nextToken());
				 int b=Integer.parseInt(st.nextToken());
				 
				 if(depth[a]<depth[b]) {
					 int temp=a;
					 a=b;
					 b=temp;
				 }
				 
				 int mx=0;
				 int mn=Integer.MAX_VALUE;
				 
				 for(int k=log-1;k>=0;k--) {
					 if(depth[a]-depth[b]>=(1<<k)) {
						 mn=Math.min(mn, min[a][k]);
						 mx=Math.max(mx, max[a][k]);
						 a=parent[a][k];
					 }
				 }
				 
				 if(a==b) {
					 sb.append(mn+" "+mx).append("\n");
					 continue;
				 }
				 
				 
				 for(int k=log-1;k>=0;k--) {
					 if(parent[a][k]!=parent[b][k]) {
						 mn=Math.min(mn, Math.min(min[a][k], min[b][k]));
						 mx=Math.max(mx, Math.max(max[a][k], max[b][k]));
						 a=parent[a][k];
						 b=parent[b][k];
					 }
				 }
				 
				 mn=Math.min(mn, Math.min(min[a][0], min[b][0]));
				 mx=Math.max(mx, Math.max(max[a][0], max[b][0]));
				 
				 sb.append(mn+" "+mx).append("\n");
			 }
			 
			 System.out.println(sb);
			 
	 }
	 public static void dfs(int pa,int a) {


		 for(int[] ch:child[a]) {
			 if(pa!=ch[0]) {
				 depth[ch[0]]=depth[a]+1;
				 parent[ch[0]][0]=a;
				 max[ch[0]][0]=ch[1];
				 min[ch[0]][0]=ch[1];
				 dfs(a,ch[0]);
			 }
			
		 }
		 
	 }
 }