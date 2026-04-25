import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main {
    static int N;
    static int M;
    static int[][][] dp;
     static char[][] arr;
     static List<int[]> list;
     static boolean[][] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static long ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static boolean flag;
    static Queue<int[]> qu;
    static int start1;
    static int start2;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        int T=Integer.parseInt(br.readLine());
       for(int t=0;t<T;t++) { 
	        StringTokenizer st=new StringTokenizer(br.readLine());

	        N=Integer.parseInt(st.nextToken());
	        M=Integer.parseInt(st.nextToken());
	        N+=2;
	        M+=2;
	        arr=new char[N][M];
	        dp=new int[N][M][3];

	        int start1=-1;
	        int start2=-1;
	        for(int i=0;i<N;i++) {
	        	for(int k=0;k<M;k++) {
	        		for(int q=0;q<3;q++)
	        			dp[i][k][q]=100000;
	        	}
	        }
	        for(int i=1;i<=N-2;i++) {
	        	String str=br.readLine();
	        	for(int k=1;k<=M-2;k++) {
	        		arr[i][k]=str.charAt(k-1);

	        		
	        		
	        		if(arr[i][k]=='$') {
	        			if(start1==-1)start1=i*M+k;
	        			else start2=i*M+k;
	        		}
	        	}
	        	
	        }
	        BFS(start1,0);
	        BFS(start2,1);
	        BFS(0,2);
	        ans=1000000;

	        for(int i=1;i<=N-2;i++) {
	        	for(int k=1;k<=M-2;k++) {
	        		if(arr[i][k]=='#')
	        		ans=Math.min(ans, dp[i][k][0]+dp[i][k][1]+dp[i][k][2]-2);
	        	}
	        }
	     
	        ans=Math.min(ans, dp[0][0][0]+dp[0][0][1]);
	        
	        System.out.println(ans);
       }   
    }
    public static void BFS(int s,int id) {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {s/M,s%M,0});
    	dp[s/M][s%M][id]=0;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    	
    		
    		for(int i=0;i<4;i++) {
    			int y=cur[0]+diy[i];
    			int x=cur[1]+dix[i];
    			if(y<0||y>=N||x<0||x>=M) 
    				continue;

    			if(arr[y][x]=='*')continue;
    			int breakWall=cur[2];
    			if(arr[y][x]=='#')breakWall++;
    			if(dp[y][x][id]<=breakWall)continue;
    			dp[y][x][id]=breakWall;
    			qu.offer(new int[] {y,x,breakWall});
    		}
    	}
  
    }
   
}