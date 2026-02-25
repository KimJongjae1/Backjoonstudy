import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,1,-1};
   static boolean[][][] visit;
   static List<Integer>[] list;
   static TreeSet<Integer> set;  
   static TreeMap<Long,Long> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        dp=new int[N][3];
        arr=new int[N][3];
       for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<3;k++){
               arr[i][k]=Integer.parseInt(st.nextToken());
        
            }
       }
    
       int ans=10000000;
       
       for(int i=0;i<3;i++){
    	   Clean();
    	   for(int k=0;k<3;k++) {
    		   for(int q=0;q<3;q++) {
    			   if(k==q||q==i)continue;
    			   dp[1][k]=Math.min(dp[0][q], dp[1][k]);
    		   }
    		   dp[1][k]+=arr[1][k];
    		   
    	   }
    	   
    	   for(int k=2;k<N;k++) {
    	        dp[k][0]=Math.min(dp[k][0],Math.min(dp[k-1][1],dp[k-1][2]))+arr[k][0];
    	        dp[k][1]=Math.min(dp[k][1],Math.min(dp[k-1][0],dp[k-1][2]))+arr[k][1];
    	        dp[k][2]=Math.min(dp[k][2],Math.min(dp[k-1][0],dp[k-1][1]))+arr[k][2];
    	        
    	   }
    	   
    	   
           ans=Math.min(dp[N-1][i],ans);
         
       }

       System.out.println(ans);
   }

   public static void Clean(){
        for(int i=0;i<N;i++){
            for(int k=0;k<3;k++){
               dp[i][k]=Integer.MAX_VALUE/2;
            }
       }
        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];
   }
}