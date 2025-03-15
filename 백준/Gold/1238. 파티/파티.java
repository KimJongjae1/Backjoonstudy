import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visit;
	static int[] realdist;
	static int[][] vilage;
	static int N;
	static int X;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st =new StringTokenizer(br.readLine());
	   N=Integer.parseInt(st.nextToken());
	   int M=Integer.parseInt(st.nextToken());
	  X=Integer.parseInt(st.nextToken());
	   
	   vilage =new int[N+1][N+1];
	   
	   for(int i=0;i<M;i++) {
		  st =new StringTokenizer(br.readLine());
		   int start=Integer.parseInt(st.nextToken());
		   int to=Integer.parseInt(st.nextToken());
		   int cost=Integer.parseInt(st.nextToken());
		   vilage[start][to]=cost;
		   
	   }
	   realdist=new int[N+1];
	   for(int i=1;i<=N;i++) {
		   gotox(i);
	   }
	   gotohome();
	   Arrays.sort(realdist);
	   System.out.println(realdist[N]);
   }
  public static void gotox(int start) {
	  if(start==X) return;
	  
	  PriorityQueue<int[]> pq =new PriorityQueue<>(new Comparator<int[]>() {
		  @Override
		  public int compare(int[] a, int[] b) {
			  return Integer.compare(a[1], b[1]);
		  }
	  });
	  pq.offer(new int[] {start,0});
	  int[] dist=new int[N+1];
	  Arrays.fill(dist, Integer.MAX_VALUE);
	  dist[start]=0;
	  while(!pq.isEmpty()) {
		  int[] now =pq.poll();
		  
		  if(dist[now[0]]<now[1]) continue;
		  
		  for(int i=1;i<=N;i++) {
			  if(vilage[now[0]][i]>0) {
				  if(vilage[now[0]][i]+now[1]<dist[i]) {
					 dist[i]=vilage[now[0]][i]+now[1];
					 pq.offer(new int[] {i,dist[i]});
				  }
			  }
		  }
				  
	  }
	  realdist[start]=dist[X];
	  
  }
  public static void gotohome() {
	  PriorityQueue<int[]> pq =new PriorityQueue<>(new Comparator<int[]>() {
		  @Override
		  public int compare(int[] a, int[] b) {
			  return Integer.compare(a[1], b[1]);
		  }
	  });
	  pq.offer(new int[] {X,0});
	  int[] dist=new int[N+1];
	  Arrays.fill(dist, Integer.MAX_VALUE);
	  dist[X]=0;
	  while(!pq.isEmpty()) {
		  int[] now =pq.poll();
		  
		  if(dist[now[0]]<now[1]) continue;
		  
		  for(int i=1;i<=N;i++) {
			  if(vilage[now[0]][i]>0) {
				  if(vilage[now[0]][i]+now[1]<dist[i]) {
					 dist[i]=vilage[now[0]][i]+now[1];
					 pq.offer(new int[] {i,dist[i]});
				  }
			  }
		  }
				  
	  }
	  for(int i=1;i<=N;i++) {
		  realdist[i]+=dist[i];
	  }
	  realdist[X]=0;
  }
}