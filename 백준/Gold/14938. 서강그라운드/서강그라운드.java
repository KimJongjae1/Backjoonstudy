import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int Max=0;
	static int[][] road;
	static int[] dist;
	static int[] item;
	static int stand=Integer.MAX_VALUE;
     public static void main(String args[]) throws IOException{
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st =new StringTokenizer(br.readLine());
      N =Integer.parseInt(st.nextToken());
      M =Integer.parseInt(st.nextToken());
      int r=Integer.parseInt(st.nextToken());
      
      item=new int[N+1];
      st =new StringTokenizer(br.readLine());
      for(int i=1;i<=N;i++) {
    	  item[i]=Integer.parseInt(st.nextToken());
      }
      road=new int[N+1][N+1];
      
      for(int i=0;i<r;i++) {
    	  st =new StringTokenizer(br.readLine());
    	  int a=Integer.parseInt(st.nextToken());
    	  int b=Integer.parseInt(st.nextToken());
    	  int dist=Integer.parseInt(st.nextToken());
    	  
    	  if(road[a][b]==0) {
    		  road[a][b]=dist;
    		  road[b][a]=dist;
    	  }else if(road[a][b]>dist) {
    		  road[a][b]=dist;
    		  road[b][a]=dist;
    	  }
      }
      for(int i=1;i<=N;i++) {
    	  dij(i);
      }
     System.out.println(Max);
     }
     public static void dij(int start) {
    	dist=new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
    	 PriorityQueue<int []> pq=new PriorityQueue<>(new Comparator<int[]>(){
    		 @Override
    		 public int compare(int[] a,int [] b) {
    			 return Integer.compare(a[1], b[1]);
    		 }
    	 }) ;
    	pq.offer(new int[] {start,0});
    	dist[start]=0;
    	 while(!pq.isEmpty()) {
    		 int[] temp =pq.poll();
              
    		 if(dist[temp[0]]<temp[1])continue;
    		 
    		 for(int i=1;i<=N;i++) {
    			 if(road[temp[0]][i]>0&&temp[1]+road[temp[0]][i]<=M) {
    				 pq.offer(new int[] {i,temp[1]+road[temp[0]][i]});    				 
    				dist[i]=Math.min(dist[i],temp[1]+road[temp[0]][i]);
    			 }
    		 }
    		 
    	 }
    	 int sum=0;
    	for(int i=1;i<=N;i++) {
    			if(dist[i]<=M&&dist[i]>0) {
    				sum+=item[i];
    			}
    	}
    	Max=Math.max(Max, sum+item[start]); 
     }
     
   
     
}
 