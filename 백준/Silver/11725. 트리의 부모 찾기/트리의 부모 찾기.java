import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static List<List<Integer>> list;
	static boolean[] visit;
	static int[] parent;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	   StringBuilder sb= new StringBuilder();
		 StringTokenizer st=new StringTokenizer(br.readLine());
	        N=Integer.parseInt(st.nextToken());
              list=new ArrayList<>();
	        for(int i=0;i<=N;i++) {
	        	list.add(new ArrayList<>());
	        }
	         
	        for(int i=0;i<N-1;i++) {
	         st=new StringTokenizer(br.readLine());
	         int a=Integer.parseInt(st.nextToken());
	         int b=Integer.parseInt(st.nextToken());
	         list.get(a).add(b);    
	         list.get(b).add(a);    
	           
	        }
	        
	        parent=new int[N+1];
	        bfs();
	        for(int i=2;i<=N;i++) {
	        	sb.append(parent[i]).append("\n");
	        }
	        System.out.println(sb);
   }
   public static void bfs() {
	   Queue<Integer> qu =new LinkedList<>();
	   qu.offer(1);
	   parent[1]=1;
	   while(!qu.isEmpty()) {
		   int now=qu.poll();
		   
		  for(int next:list.get(now)) {
			  if(parent[next]==0) {
				  parent[next]=now;
				  qu.offer(next);
			  }
		  }
		   
	   }
	   
   }
   
}