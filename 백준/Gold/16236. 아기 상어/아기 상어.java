import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] diy = {-1,0,0,1};
	static int[] dix = {0,-1,1,0};
	static int[][] pool;
	static int sharkY;
	static int sharkX;
	static int sharksize=2;
	static int sharkeat=0;
	static int ans=0;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		 StringTokenizer st =new StringTokenizer(br.readLine());

		 N=Integer.parseInt(st.nextToken());
	    pool=new int[N][N];
	  
		for(int i=0;i<N;i++) {
			st =new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				pool[i][k]=Integer.parseInt(st.nextToken());
				if(pool[i][k]==9) {
					sharkY=i; sharkX=k;
					pool[i][k]=0;
				}
			}
		}	
      boolean stop=true;
	   while(stop) {
		   stop=bfs(ans);
		   
	   }
	   
	   System.out.println(ans);
	   
   }
   public static boolean bfs(int move) {
	   Queue<int[]> qu=new LinkedList<>();
	   PriorityQueue<int[]> pq =new PriorityQueue<>(new Comparator<int[]>() {
		   @Override
		   public int compare(int[] a, int[] b) {
			   if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
			   else {return Integer.compare(a[1], b[1]);}
		   }
	   });
	   boolean[][] visit =new boolean[N][N];
	   qu.offer(new int[] {sharkY,sharkX,move});
	   visit[sharkY][sharkX]=true;
	   int maxmove=Integer.MAX_VALUE;
	   while(!qu.isEmpty()) {
		   int[] now=qu.poll();
		   
		   if(now[2]>=maxmove) continue;
		   
		   for(int i=0;i<4;i++) {
			   int Y=now[0]+diy[i];
			   int X=now[1]+dix[i];
			  if(0<=Y&&Y<N&&0<=X&&X<N) {
				  if(visit[Y][X]) continue;
				  else {
					  visit[Y][X]=true;
					  if(pool[Y][X]==0) {
						  qu.offer(new int[] {Y,X,now[2]+1});
					  }else {
						  if(pool[Y][X]<sharksize) {
							  pq.offer(new int[] {Y,X,now[2]+1});
							  maxmove=now[2]+1;
						  }else if(pool[Y][X]==sharksize) {
							  qu.offer(new int[] {Y,X,now[2]+1});
						  }else {
							  visit[Y][X]=false;
						  }
					  }
				  }
			  }  
		   }
	   }
	   
	   if(pq.isEmpty()) {
		   return false;
	   }else {
		   int[] target=pq.poll();
		   ans=target[2];
		   sharkeat++;
		   sharkY=target[0]; sharkX=target[1];
		   pool[sharkY][sharkX]=0;
		   grow();
		   return true;
		   
	   }
	   
	   
   }
   public static void grow() {
	   
	   if(sharkeat==sharksize) {
		   sharksize++;
		   sharkeat=0;
	   }
	   
   }
   
   
}