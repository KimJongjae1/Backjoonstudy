import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static char[][] arr;
   static int[][][] dp;
   static int ans;
   static int[] diy= {1,-1,0,0};
   static int[] dix= {0,0,1,-1};
   static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        ans=Integer.MAX_VALUE;
        arr=new char[N][M];
        dp=new int[N][M][4];
        int y=0;int x=0;
        for(int i=0;i<N;i++) {
        	String str=br.readLine();
        	for(int k=0;k<M;k++) {
        		arr[i][k]=str.charAt(k);
        		if(arr[i][k]=='C') {
        			y=i;x=k;
        		}
        	}
        }
        
        BFS(y,x);
    
        System.out.println(ans);
    	
   }
    public static void BFS(int sy,int sx) {
    	PriorityQueue<int[]> qu=new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a,int[] b) {
    			return a[2]-b[2];
    		}
    	});
     	
    	for(int i=0;i<N;i++)
    		for(int k=0;k<M;k++)
    			for(int q=0;q<4;q++)
    				dp[i][k][q]=Integer.MAX_VALUE;
    	
 
    	for(int i=0;i<4;i++) {
    		dp[sy][sx][i]=0;
    		int y=sy+diy[i];
    		int x=sx+dix[i];
    		if(y<0||y>=N||x<0||x>=M)continue;
    		if(arr[y][x]=='*')continue;
        	qu.offer(new int[] {y,x,i,0});
        	if(arr[y][x]=='C') {
        		ans=0;
        		return;
        	}
        	dp[y][x][i]=0;
    	}
   
   
    	while(!qu.isEmpty()) {
    		int[] now=qu.poll();
    		
    		for(int i=0;i<4;i++) {
        		int y=now[0]+diy[i];
        		int x=now[1]+dix[i];
        		if(y<0||y>=N||x<0||x>=M)continue;
        		if(arr[y][x]=='*')continue;
        		int direct=now[3];
        		if(i!=now[2])direct++;
        		
        		if(dp[y][x][i]<=direct)continue;
        		dp[y][x][i]=direct;
        		
        		if(arr[y][x]=='C') {
        			ans=Math.min(ans, dp[y][x][i]);
        			continue;
        		}
        		qu.offer(new int[] {y,x,i,dp[y][x][i]});
        	}
    		
    	}
    	
    }
    
}