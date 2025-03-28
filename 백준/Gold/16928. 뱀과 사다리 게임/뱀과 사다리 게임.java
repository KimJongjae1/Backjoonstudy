
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
static Map<Integer,Integer> map;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		 map= new HashMap<>();
		for(int i=0;i<N+M;i++) {
			 st =new StringTokenizer(br.readLine());
			 int a=Integer.parseInt(st.nextToken());
			 int b=Integer.parseInt(st.nextToken());
			 map.put(a,b);
		}
		
	    bfs();
	  
		 
		 
   }
   public static void bfs() {
	   Queue<int[]> qu =new LinkedList<>();
	   qu.offer(new int[] {1,0});
	   boolean[] visit=new boolean[101];
	   visit[1]=true;
	   while(!qu.isEmpty()) {
		   int[] now=qu.poll();
		   
		    if(now[0]==100) {
			   System.out.println(now[1]);
			   return;
		   }
		   
		   
		   for(int i=1;i<=6;i++) {//현재에서 다음으로 가기
			   int next=now[0]+i;
			   int nextturn=now[1]+1;
			   
			   if(next>100) break;
			   
			   if(!map.containsKey(next)&&!visit[next]) {
				   qu.offer(new int[] {next,nextturn});//그냥 가기
				   visit[next]=true;
			   }
			   else if(map.containsKey(next)&&!visit[map.get(next)]){
				   visit[map.get(next)]=true;
				   qu.offer(new int[] {map.get(next),nextturn});
			   }
			   
		   }
		   
	   }
   }
}