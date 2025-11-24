import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] room;
	static List<Integer> roomN;
	static int ans;
	static int idx;
	static boolean[][] visit;
	static int[] diy= {-1,1,0,0};
	static int[] dix= {0,0,-1,1};
	static StringBuilder sb;
	static BufferedReader br;
	static Queue<int[]> qu;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
	     M= Integer.parseInt(st.nextToken());
	     N=Integer.parseInt(st.nextToken());
	     arr=new int[N][M];
	     room=new int[N][M];
	     roomN=new ArrayList<>();
		 visit=new boolean[N][M];
		    int max=0;
	     for(int i=0;i<N;i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 for(int k=0;k<M;k++) {
	    		 arr[i][k]=Integer.parseInt(st.nextToken());
	    	 }
	     }
	
	     for(int i=0;i<N;i++) {
	    	 for(int k=0;k<M;k++) {
	    		 if(visit[i][k])continue;
	    		 max=Math.max(max, bfs(i,k));
	    	 }
	     }
	     int removeWallMax=0;
	     for(int i=0;i<N;i++) {
	    	 for(int k=0;k<M;k++) {
	    		 
	    		 for(int q=0;q<4;q++) {
	    			 int Y=i+diy[q];
	    			 int X=k+dix[q];
	    			 if(Y<0||Y>=N||X<0||X>=M)continue;
	    			 if(room[Y][X]==room[i][k])continue;
	    			 removeWallMax=Math.max(removeWallMax, roomN.get(room[Y][X])+roomN.get(room[i][k]));
	    		 }
	    		 

	    	 }
	     }
	
	     sb.append(idx+"\n").append(max+"\n").append(removeWallMax);
	     System.out.println(sb);
	     
    }
    public static int bfs(int r,int c) {
    	Queue<int[]> q=new LinkedList<>();
    	q.offer(new int[] {r,c});
    	visit[r][c]=true;
    	room[r][c]=idx;
    	int sum=1;
    	while(!q.isEmpty()) {
    		int[] cur=q.poll();
    		
    		List<int[]> direct=bitmasking(cur[0],cur[1]);
    		for(int[] next:direct) {
    			int Y=cur[0]+next[0];
    			int X=cur[1]+next[1];
    			
    			if(Y<0||Y>=N||X<0||X>=M)continue;
    			if(visit[Y][X])continue;
    			visit[Y][X]=true;
    			sum++;
    			q.offer(new int[] {Y,X});
    			room[Y][X]=idx;
    			
    		}
    		
    		
    		
    	}
    	roomN.add(sum);
    	idx++;
    	
    	return sum;
    	
    }
    public static List<int[]> bitmasking(int r,int c){
    	List<int[]> list=new ArrayList<>();
    
    	if((arr[r][c]&(1<<0))==0) list.add(new int[] {0,-1});
    	if((arr[r][c]&(1<<1))==0) list.add(new int[] {-1,0});
    	if((arr[r][c]&(1<<2))==0) list.add(new int[] {0,1});
    	if((arr[r][c]&(1<<3))==0) list.add(new int[] {1,0});
    	
    	return list;
    }
}