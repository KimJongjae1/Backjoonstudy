import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static int idxB;
   static  StringBuilder sb;
   static char[][] arr;
   static int[][][][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,0,-1,1,0,0};
   static int[] dix= {-1,1,0,0,0,0};
   static int[] diz= {0,0,0,0,-1,1};
   static boolean[][] visit;
   static boolean[] Islandvisit;
   static List<int[]>[][] list;
   static Set<Integer> set;  
   static Map<Integer,Integer> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer.parseInt(st.nextToken());
		 M=Integer.parseInt(st.nextToken());
		 arr=new char[N][M];
		 int RED=0;
		 int BLUE=0;
		 int HOLE=0;
		 dp=new int[N][M][N][M];
		 for(int i=0;i<N;i++) {
			 String str=br.readLine();
			 for(int k=0;k<M;k++) {
				 arr[i][k]=str.charAt(k);
				 if(arr[i][k]=='R') RED=i*M+k;
				 else if(arr[i][k]=='B') BLUE=i*M+k;
				 else if(arr[i][k]=='O') HOLE=i*M+k;
				 for(int q=0;q<N;q++) {
					 for(int w=0;w<M;w++) {
						 dp[i][k][q][w]=Integer.MAX_VALUE;
					 }
				 }
			 }
		 }

		 ans=Integer.MAX_VALUE;
		 DFS(RED,BLUE,HOLE,0);
		 if(ans==Integer.MAX_VALUE)System.out.println(-1);
		 else System.out.println(ans);
    }
    
    public static void DFS(int red,int blue,int hole,int cnt) {
    	if(red==hole&&blue!=hole) {
        	
    		ans=Math.min(cnt, ans);
    		return;
    	}
    
    		for(int i=0;i<4;i++) {
 
    			int y=red/M;
    			int x=red%M;
    			while(true) {
    				y+=diy[i];
    				x+=dix[i];
    				if(arr[y][x]=='#') {
    					y-=diy[i];
    					x-=dix[i];
    					break;
    				}else if(arr[y][x]=='O')break;
    		
    			}
    			

    			int Y=blue/M;
    			int X=blue%M;
    			while(true) {
    				Y+=diy[i];
    				X+=dix[i];
    				if(arr[Y][X]=='#') {
    					Y-=diy[i];
    					X-=dix[i];
    					break;
    				}else if(arr[Y][X]=='O')break;
    			
    			}
    			
    		
    			
    			if(Y*M+X==hole) {
    	    		continue;
    	    	}
    			
    			
    			if(y*M+x==Y*M+X) {
    				if(i==0) {
    					if(red%M<blue%M) X-=dix[i];
    					else x-=dix[i];
    				}else if(i==1) {
    					if(red%M>blue%M)X-=dix[i];
    					else x-=dix[i];
    				}else if(i==2) {
    					if(red/M<blue/M)Y-=diy[i];
    					else y-=diy[i];
    				}else {
    					if(red/M>blue/M) Y-=diy[i];
    					else y-=diy[i];
    				}
    			}
    		
    			
    			if(dp[y][x][Y][X]<=cnt+1)continue;
    			dp[y][x][Y][X]=cnt+1;
    			DFS(y*M+x,Y*M+X,hole,cnt+1);
    			
    		}
    		
    		
    	}
    
}