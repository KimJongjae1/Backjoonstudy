import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int T;
   static int idx;
   static int max;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<Integer> list;
   static TreeSet<Integer> set;  
   static TreeMap<Integer,Integer> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
       
        arr=new int[N][N];
        for(int i=0;i<N;i++) {
        	 st=new StringTokenizer(br.readLine());
        	for(int k=0;k<N;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        	}
        }
	   max=0;
	   for(int i=0;i<N;i++) {
		   max+=(1<<i);
	   }
	 
	   dp=new int[N][max+1];
	   for(int i=0;i<N;i++) {
		   Arrays.fill(dp[i], -1);
	   }
       

       System.out.println( DFS(0,1));
    }
    
   public static int DFS(int cur,int cnt) {
	   
	   if(cnt==max) {
		   if(arr[cur][0]==0)return 100000000;
		   return arr[cur][0];
	   }
	   
	   if(dp[cur][cnt]!=-1) return dp[cur][cnt];
	   dp[cur][cnt]=100000000;
	   
	
	   
	   for(int i=0;i<N;i++) {
		   if(arr[cur][i]==0)continue;
		   if((cnt&(1<<i))>0)continue;
		   dp[cur][cnt]=Math.min(dp[cur][cnt], DFS(i,cnt+(1<<i))+arr[cur][i]);
		   
	   }
	   return dp[cur][cnt];
	   
   }
}