import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {-1,0,1,0};
   static int[] dix= {0,1,0,-1};
   static boolean[][] visit;
   static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];

        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());       
        	for(int k=0;k<M;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        	}
        }
        visit=new boolean[N][M];
        DFS(0,0);
        System.out.println(ans);
    
    }
    public static void DFS(int cur,int sum) {
    		ans=Math.max(sum, ans);
    		
    		if(cur>=N*M)return;
    		int y=cur/M;
    		int x=cur%M;
    		DFS(cur+1,sum);
    		if(visit[y][x]) return;
    		
    		
    		for(int dir1=0;dir1<4;dir1++) {
    			int dir2=(dir1+1)%4;
    			int s=check(y,x,dir1,dir2);
    
    			if(s!=0)  {
    				DFS(cur+1,sum+s);
    				BackVisit(y,x,dir1,dir2);
    			}
    				
    			
 
    		}
    		
    	
    	
    }
    public static int check(int y,int x,int dir1,int dir2) {
    	  
    	int Y1=y+diy[dir1];
    	int X1=x+dix[dir1];
    	int Y2=y+diy[dir2];
    	int X2=x+dix[dir2];
    	if(!InRange(Y1,X1)||!InRange(Y2,X2)) return 0;
    	if(!visit[Y1][X1]&&!visit[Y2][X2]) {
    		visit[y][x]=true;
    		visit[Y1][X1]=true;
    		visit[Y2][X2]=true;
    		return 2*arr[y][x]+arr[Y1][X1]+arr[Y2][X2];
    	}
    	return 0;
    	
    }
    
    public static void BackVisit(int y,int x,int dir1,int dir2) {
       	int Y1=y+diy[dir1];
    	int X1=x+dix[dir1];
    	int Y2=y+diy[dir2];
    	int X2=x+dix[dir2];
    	visit[y][x]=false;
    	visit[Y1][X1]=false;
    	visit[Y2][X2]=false;
    }
    
    public static boolean InRange(int y,int x) {
    	
    	if(y<0||y>=N||x<0||x>=M) return false;
    	return true;
    }
}