import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int K;
    static int[][][][] dp;
     static int[][] arr;
     static List<int[]>[] list;
     static boolean[][] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static Map<Integer,Integer> map;
     static int ans;
     static int[] diy= {-1,1,0,0};
     static int[] dix= {0,0,-1,1};
     static boolean flag;
     static int mac;
     static int starbuck;
     static List<Integer> MacList;
     static List<Integer> StarList;
     static int[] Kdiy= {-2,-2,2,2,-1,1,-1,1};
     static int[] Kdix= {-1,1,-1,1,2,2,-2,-2};
     static int[] Bdiy= {-1,1,-1,1};
     static int[] Bdix= {1,1,-1,-1};
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
  
	       StringTokenizer st=new StringTokenizer(br.readLine());
	       N=Integer.parseInt(st.nextToken());
	       
	       arr=new int[N][N];
	       dp=new int[N][N][3][N*N+1];
	       int y=0;
	       int x=0;
	       for(int i=0;i<N;i++) {
	    	   st=new StringTokenizer(br.readLine());
	    	   for(int k=0;k<N;k++) {
	    		   arr[i][k]=Integer.parseInt(st.nextToken());
	    		   for(int q=0;q<3;q++) {
	    			   for(int w=1;w<=N*N;w++) {
	    				   dp[i][k][q][w]=Integer.MAX_VALUE;
	    			   }
	    		   }
	    		   if(arr[i][k]==1) {
	    			   y=i;x=k;
	    			   dp[i][k][0][1]=0;
	    			   dp[i][k][1][1]=0;
	    			   dp[i][k][2][1]=0;
	    		   }
	    	   }
	       }
	       BFS(y,x);
    }
    public static void BFS(int a,int b) {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {a,b,0,1,0});
    	qu.offer(new int[] {a,b,1,1,0});
    	qu.offer(new int[] {a,b,2,1,0});
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    	
    		int y=cur[0];
    		int x=cur[1];
    		int status=cur[2];
    		int num=cur[3];//현재 level
    		int cost=cur[4];
    		//System.out.println(y+" "+x+" "+status+" "+num+" "+cost);
    		if(dp[y][x][status][num]<cost)continue; 
    		if(num==N*N) {
    			System.out.println(cost);
    			return;
    		}
    		if(status==0) {
    			knight(y,x,qu,cost,num,status);
    		}else if(status==1) {
    			beshop(y,x,qu,cost,num,status);
    		}else if(status==2){
    			look(y,x,qu,cost,num,status);
    		}
    			for(int i=0;i<3;i++) {
    				if(status==i)continue;
    				if(cost+1>=dp[y][x][i][num])continue;
    	    		dp[y][x][i][num]=cost+1;
    	    		qu.offer(new int[] {y,x,i,num,cost+1});
    			}
    		
    	}
    	
    	
    }
    public static void knight(int y,int x,Queue<int[]> qu,int cost,int num,int status) {
    	
    	for(int i=0;i<8;i++) {
    		int Y=y+Kdiy[i];
    		int X=x+Kdix[i];
    		if(Y<0||X<0||X>=N||Y>=N)continue;
    		int n=num;
    		if(arr[Y][X]==num+1) n++;
    		if(cost+1>=dp[Y][X][status][n])continue;
    		dp[Y][X][status][n]=cost+1;
    		qu.offer(new int[] {Y,X,status,n,cost+1});
    				
    	}
    	
    }
    public static void beshop(int y,int x,Queue<int[]> qu,int cost,int num,int status) {
    	
    	for(int i=0;i<4;i++) {
    		int Y=y;
    		int X=x;
    		while(true) {
    			Y+=Bdiy[i];
    			X+=Bdix[i];
    			if(Y<0||X<0||X>=N||Y>=N)break;
    			int n=num;
        		if(arr[Y][X]==num+1) n++;
        		if(cost+1>=dp[Y][X][status][n])continue;
        		dp[Y][X][status][n]=cost+1;
        		qu.offer(new int[] {Y,X,status,n,cost+1});
    		}
    	}
    	
    }
    public static void look(int y,int x,Queue<int[]> qu,int cost,int num,int status) {
    	
     	for(int i=0;i<4;i++) {
    		int Y=y;
    		int X=x;
    		while(true) {
    			Y+=diy[i];
    			X+=dix[i];
    			if(Y<0||X<0||X>=N||Y>=N)break;
    			int n=num;
        		if(arr[Y][X]==num+1) n++;
        		if(cost+1>=dp[Y][X][status][n])continue;
        		dp[Y][X][status][n]=cost+1;
        		qu.offer(new int[] {Y,X,status,n,cost+1});
    		}
    	}
    }
 }