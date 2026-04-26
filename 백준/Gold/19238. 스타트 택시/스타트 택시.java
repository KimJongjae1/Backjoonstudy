import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main {
    static int N;
    static int M;
    static int K;
    static int[][][] dp;
     static int[][] arr;
     static List<int[]> list;
     static boolean[][] visit;
     static int idx;
     static Map<Integer,Integer> map;
     static StringBuilder sb;
     static Set<Integer> set;
     static long ans;
    static int[] diy={-1,0,0,1};
    static int[] dix={0,-1,1,0};
    static boolean flag;
    static Queue<int[]> qu;
    static int start1;
    static int start2;
    static int y;
    static int x;

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();


	    StringTokenizer st=new StringTokenizer(br.readLine());

	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    K=Integer.parseInt(st.nextToken());
	    arr=new int[N][N];   
	    for(int i=0;i<N;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int k=0;k<N;k++) {
	    		arr[i][k]=Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    st=new StringTokenizer(br.readLine());
	    y=Integer.parseInt(st.nextToken())-1;
	    x=Integer.parseInt(st.nextToken())-1;
	    map=new HashMap<>();
	    for(int i=2;i<M+2;i++) {
	    	st=new StringTokenizer(br.readLine());
		    int sy=Integer.parseInt(st.nextToken())-1;
		    int sx=Integer.parseInt(st.nextToken())-1;
		    int a=Integer.parseInt(st.nextToken())-1;
		    int b=Integer.parseInt(st.nextToken())-1;
		    arr[sy][sx]=i;
		    map.put(i,a*N+b);
	    }

	    move();
	    System.out.println(K);
    }
    public static void print() {
    	for(int i=0;i<N;i++) {
	
	    	for(int k=0;k<N;k++) {
	    		System.out.print(arr[i][k]+" ");
	    	}System.out.println();
	    }System.out.println();
    }
   public static boolean move() {


	   for(int i=0;i<M;i++) {
		   
		   if(!people())return false;

		   if(!destination())return false;
	
	   }
	   
	   return true;
	   
   }
   public static boolean people() {
	   Queue<int[]> qu=new LinkedList<>();
	   visit=new boolean[N][N];
	   qu.offer(new int[] {y,x,0});
	   visit[y][x]=true;
	   idx=-1;
	   if(arr[y][x]>=2) {
		   idx=arr[y][x];
		   arr[y][x]=0;
		   return true;
	   }
	   int fuel=100000;
	   while(!qu.isEmpty()) {
		   int[] cur=qu.poll();
		
		   if(arr[cur[0]][cur[1]]>=2) {
			   if(fuel==100000) {
				   fuel=cur[2];
				   y=cur[0];x=cur[1];
			   }else {
				   if(cur[2]>fuel)continue;
				   else if(cur[2]==fuel) {
					   if(cur[0]>y) continue;
					   else if(cur[0]==y) {
						   if(cur[1]>x)continue;
					   }
				   }
				   fuel=cur[2];
				   y=cur[0];x=cur[1]; 
			   }
			   continue;
		   }
		   
		   if(cur[2]>=K)continue;
		   if(cur[2]>=fuel)continue;
		   for(int i=0;i<4;i++) {
			   int Y=cur[0]+diy[i];
			   int X=cur[1]+dix[i];
			   if(Y<0||X<0||X>=N||Y>=N)continue;
			   if(arr[Y][X]==1)continue;
			   if(visit[Y][X])continue;
			   visit[Y][X]=true;

			   qu.offer(new int[] {Y,X,cur[2]+1});
		   }
	   }

	   if(fuel==100000) {
		   K=-1;
		   return false;
	   }
	   else {
		   idx=arr[y][x];
		   arr[y][x]=0;
		   K-=fuel;
		   return true;
	   }
   }
   public static boolean destination() {
	   Queue<int[]> qu=new LinkedList<>();
	   qu.offer(new int[] {y,x,0});
	   visit=new boolean[N][N];
	   visit[y][x]=true;
	   int ey=map.get(idx)/N;
	   int ex=map.get(idx)%N;
	   
	   while(!qu.isEmpty()) {
		   int[] cur=qu.poll();
		   
		   if(ey==cur[0]&&ex==cur[1]) {
			   K+=cur[2];
			   y=cur[0];x=cur[1];
			   return true; 
		   }
		   if(cur[2]>=K)continue;
		   
		   for(int i=0;i<4;i++) {
			   int Y=cur[0]+diy[i];
			   int X=cur[1]+dix[i];
			   if(Y<0||X<0||X>=N||Y>=N)continue;
			   if(arr[Y][X]==1)continue;
			   if(visit[Y][X])continue;
			   visit[Y][X]=true;
			   
			   qu.offer(new int[] {Y,X,cur[2]+1});
		   }
	   }
	   K=-1;
	  return false;
   }
}