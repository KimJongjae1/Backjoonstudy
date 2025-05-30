import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N;
	static List<List<int[]>> list;
	static Set<Integer> set;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());  
		   N=Integer.parseInt(st.nextToken());
		   int M=Integer.parseInt(st.nextToken());
		   int K=Integer.parseInt(st.nextToken());
		   list=new ArrayList<>();
		   for(int i=0;i<=N;i++) {
			   list.add(new ArrayList<>());
		   }
		   
		   
		   for(int i=0;i<M;i++) {
			   st=new StringTokenizer(br.readLine());  
			   int u=Integer.parseInt(st.nextToken());
			   int v=Integer.parseInt(st.nextToken());
			   int c=Integer.parseInt(st.nextToken());
			   
			   list.get(v).add(new int[] {u,c});
		   }
		   set=new TreeSet<>();
		   st=new StringTokenizer(br.readLine());  
		   for(int i=0;i<K;i++) {
			   set.add(Integer.parseInt(st.nextToken()));
		   }
		   
		   long[] ans=dij();
		   System.out.println(ans[0]);
		   System.out.println(ans[1]);
		   
	 }
	 public static long[] dij() {
		 PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>(){
			 @Override
			 public int compare(long[] a,long[] b) {
				 return Long.compare(a[1], b[1]);
			 }
		 }); 
		 	 Long[] dist=new Long[N+1];
		 	 Arrays.fill(dist, Long.MAX_VALUE);
		     for(int a:set) {
		    	 dist[a]=0L;
		    	 pq.offer(new long[] {a,0L});
		     }
		 while(!pq.isEmpty()) {
			 long[] now=pq.poll();
			 
			 if(dist[(int)now[0]]<now[1]) continue;
			 
			 for(int[] next:list.get((int)now[0])) {
				 if(dist[next[0]]>next[1]+now[1]) {
					 dist[next[0]]=(long)next[1]+now[1];
					 pq.offer(new long[] {next[0],dist[next[0]]});
				 }
			 }
			 
			 
		 }
		 Long max=0L;
		 int idx=0;
		 for(int i=1;i<=N;i++) {
			 if(max<dist[i]) {
				 max=dist[i];
				 idx=i;
			 }
		 }
		 return new long[] {idx,max};
	 }
}