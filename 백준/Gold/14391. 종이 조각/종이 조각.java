import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<Integer> list;
   static int ret=0;
   static int diff=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        
        arr=new int[N][M];
      
        for(int i=0;i<N;i++) {
        	String str=br.readLine();
        	for(int k=0;k<M;k++) {
        		arr[i][k]=str.charAt(k)-'0';
        	
        	}
        }
     
        
    	visit=new boolean[N][M];
    	BACK(0,0);
    	System.out.println(ret);
    }
    
    public static void BACK(int cur,int sum) {

    	
    	if(cur==N*M) {
    		ret=Math.max(ret, sum);
    		return;
    	}
    	int y=cur/M;
    	int x=cur%M;
    
    	if(visit[y][x]) {
    		BACK(cur+1,sum);
    		return;
    	}
    	visit[y][x]=true;
    	BACK(cur+1,sum+arr[y][x]);
    	int s=arr[y][x];
    	int n=x;
    	for(int i=x+1;i<M;i++) {
    		
    		if(visit[y][i]) {
    			for(int k=x+1;k<i;k++)
    				visit[y][k]=false;
    			break;
    		}
    		n=i;
    		visit[y][i]=true;
    		s=s*10+arr[y][i];
    		BACK(y*M+i+1,sum+s);
    	}

    	for(int i=x+1;i<=n;i++) 
    		visit[y][i]=false;
    	
    	s=arr[y][x]; 
    	n=y;
    	for(int i=y+1;i<N;i++) {
    		
    		if(visit[i][x]) {
    			for(int k=y+1;k<i;k++)
    				visit[k][x]=false;
    			break;
    		}
    		n=i;
    		visit[i][x]=true;
    		s=s*10+arr[i][x];
    		BACK(cur+1,sum+s); 
    	}

    	for(int i=y;i<=n;i++) 
    		visit[i][x]=false;

    	
    }
    
    
    
}