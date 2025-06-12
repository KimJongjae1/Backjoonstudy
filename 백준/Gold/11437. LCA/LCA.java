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
	
	static List<Integer>[] child;
	static int[] depth;
	static int[] parent;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
			StringTokenizer st=new StringTokenizer(br.readLine());  		 
			 
			 N=Integer.parseInt(st.nextToken());
			 child=new ArrayList[N+1];
			 for(int i=1;i<=N;i++) {
				 child[i]=new ArrayList<>();
			 }
			
			 for(int i=0;i<N-1;i++) {
				 st=new StringTokenizer(br.readLine());  	
				 int pa=Integer.parseInt(st.nextToken());
				 int ch=Integer.parseInt(st.nextToken());
				 child[pa].add(ch);
				 child[ch].add(pa);
			 }
			 
			 depth=new int[N+1];
			 depth[1]=1;
			 parent=new int[N+1];
			 Queue<Integer> qu=new LinkedList<>();
			 boolean[] visit=new boolean[N+1];
			 visit[1]=true;
			 qu.offer(1);
			 while(!qu.isEmpty()){
				 int now=qu.poll();
				 
				 for(int ch:child[now]) {
					 if(!visit[ch]) {
						 visit[ch]=true;
						 parent[ch]=now;
						 depth[ch]=depth[now]+1;	
						 qu.offer(ch);
					 }
				 }
			 }
			 
			 
			StringBuilder sb=new StringBuilder();
			 int M=Integer.parseInt(br.readLine());
			 for(int i=0;i<M;i++) {
				 st=new StringTokenizer(br.readLine());  	
				 int a=Integer.parseInt(st.nextToken());
				 int b=Integer.parseInt(st.nextToken());
				 
				 int deep=a;
				 int ndeep=b;
				 if(depth[a]<depth[b]) {
					 deep=b; ndeep=a;
				 }
				
				 while(depth[deep]!=depth[ndeep]) {
					 deep=parent[deep];
				 }
				 
				 while(deep!=ndeep) {
					 deep=parent[deep];
					 ndeep=parent[ndeep];
				 }
				 sb.append(deep).append("\n");
				 
			 }
			 System.out.println(sb);
			 
	 }
	 
 }
