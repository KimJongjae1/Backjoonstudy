import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int max;
	static int[] diy = {-1,1,0,0};
	static int[] dix = {0,0,1,-1};
	static int N;
	static int M;
	static void bfs(int[][] arr,int y,int x,int count, int sum) {
		
		if(count==4) {
			max=Math.max(sum, max);
			return;
		}
	
		for(int i=0;i<4;i++) {
			int ny=y+diy[i];
			int nx=x+dix[i];
			
			if(0>ny||ny>=N||0>nx||nx>=M) {
				continue;
			}
				
			if(!visited[ny][nx]) {
				visited[y][x]=true;
				bfs(arr,ny,nx,count+1,sum+arr[ny][nx]);
				visited[y][x]=false;
				}
		 }
		
	}
	
	static void checking(int[][] arr,int y,int x) {
		int count=0;
		int sum=arr[y][x];
		for(int i=0;i<4;i++) {
			int ny=y+diy[i];
			int nx=x+dix[i];
			
			if(0>ny||ny>=N||0>nx||nx>=M) {
				continue;
			}
		
		    sum+=arr[ny][nx];
		    count++;
		
		}
		
		if(count==3) {
			max=Math.max(max, sum);
		}else if(count==4) {
			for(int i=0;i<4;i++) {
				int ny=y+diy[i];
				int nx=x+dix[i];
				
				int temp=sum;
				temp=temp-arr[ny][nx];
				max=Math.max(max, temp);
			}
			
			
		}
		
	}
    
	

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
		int[][] arr =new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
				arr[i][k]=Integer.parseInt(st.nextToken());
			}
		}
	    
		visited=new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				bfs(arr,i,k,1,arr[i][k]);
				checking(arr,i,k);
			}
		}
		System.out.println(max);
	    
	}
  }