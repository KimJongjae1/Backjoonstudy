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
	public static List<Integer>[] child;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
	
			StringTokenizer st=new StringTokenizer(br.readLine());  		 
			 
			 N=Integer.parseInt(st.nextToken());
			 int log = 1;
			 while ((1 << log) <= N) log++;
			 int[][] parent=new int[log+1][N+1];
			 int[] depth=new int[N+1];
			 child=new ArrayList[N+1];
			 for(int i=1;i<=N;i++) {
				 child[i]=new ArrayList<>();
			 }
			 
			 for(int i=0;i<N-1;i++) {
				 st=new StringTokenizer(br.readLine());  
				 int a=Integer.parseInt(st.nextToken());				 
				 int b=Integer.parseInt(st.nextToken());				 
				 
				 child[a].add(b);
				 child[b].add(a);
			 }
			 
			 depth[1]=1;
			 Queue<Integer> qu=new LinkedList<>();
			 qu.offer(1);
			 boolean[] visit=new boolean[N+1];
			 visit[1]=true;
			 while(!qu.isEmpty()) {
				 int now=qu.poll();
				 
				 for(int next:child[now]) {
					 if(!visit[next]) {
						 visit[next]=true;
						 depth[next]=depth[now]+1;
						 qu.offer(next);
						 parent[0][next]=now;
					 }
				 }
				 
			 }
			 
			 
			 for(int i=1;i<=log;i++) {
				 for(int k=1;k<=N;k++) {
					 parent[i][k]=parent[i-1][parent[i-1][k]];
				 }
			 }
			 StringBuilder sb=new StringBuilder();
			 int M=Integer.parseInt(br.readLine());
			 for(int i=0;i<M;i++) {
				 st=new StringTokenizer(br.readLine());  	
				 int a=Integer.parseInt(st.nextToken());
				 int b=Integer.parseInt(st.nextToken());
				 
				 int lon=a;int sho=b;
				 if(depth[b]>depth[a]) {
					 lon=b; sho=a;
				 }
				 
				 for (int k=log; k>=0; k--) {
					    if ((depth[lon] - depth[sho]) >= (1 << k)) {
					        lon = parent[k][lon];
					    }
					}
				 if (lon != sho) {
					    for (int k = log; k >= 0; k--) {
					        if (parent[k][lon] != 0 && parent[k][lon] != parent[k][sho]) {
					            lon = parent[k][lon];
					            sho = parent[k][sho];
					        }
					    }
					    lon = parent[0][lon];  // 공통 부모로 이동
					}
					sb.append(lon).append("\n");
			 }
			 System.out.println(sb);
			 
			 
			 
	 }
	 
 }