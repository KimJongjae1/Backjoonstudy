import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
   static  StringBuilder sb;
   static char[][] arr;
   static int[] dp;
   static long[] sum;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[] visit;
   static List<Integer> list;
   static Set<int[]> set;  
   static Queue<int[]> qu;
   static int[] prv;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

	        StringTokenizer st=new StringTokenizer(br.readLine());
	        N=Integer.parseInt(st.nextToken());
	        M=Integer.parseInt(st.nextToken());
	        ans=Integer.MAX_VALUE;
	        arr=new char[N][M];
	        int y1=0;int x1=0;
	        int y2=0;int x2=0;       
	        for(int i=0;i<N;i++) {
	        	String str=br.readLine();
	        	for(int k=0;k<M;k++) {
	        		arr[i][k]=str.charAt(k);
	        		if(arr[i][k]=='o') {
	        			arr[i][k]='.';
	        			if(!flag) {
	        				y1=i;
	        				x1=k;
	        				flag=true;
	        			}else {
	        				y2=i;
	        				x2=k;
	        			}
	        				
	        			
	        		}
	        	}
	        }
	        DFS(y1,x1,y2,x2,0);
	        if(ans==Integer.MAX_VALUE)System.out.println(-1);
	        else System.out.println(ans);
    	
    }
    
    public static void DFS(int y1,int x1,int y2,int x2,int T) {
    	if(T>=10)return;

    	for(int i=0;i<4;i++) {
    		int Y1=y1+diy[i];
    		int X1=x1+dix[i];
    		int Y2=y2+diy[i];
    		int X2=x2+dix[i];
    		boolean range1=range(Y1,X1);
    		boolean range2=range(Y2,X2);

    		if(!range1&&!range2)continue;
    		if(range1!=range2) {
    			ans=Math.min(ans, T+1);
        		continue;
    		}
    		if(arr[Y1][X1]=='#'&&arr[Y2][X2]=='#')continue;
    		
    		if(arr[Y1][X1]=='#') {
    			Y1=y1;
    			X1=x1;
    		}
    		if(arr[Y2][X2]=='#') {
    			Y2=y2;
    			X2=x2;
    		}
    		
    		DFS(Y1,X1,Y2,X2,T+1);
    		
    	}
    	
    	
    }
    public static boolean range(int y,int x) {
    	
    	if(y<0||y>=N||x<0||x>=M)return false;
    	return true;
    }
}