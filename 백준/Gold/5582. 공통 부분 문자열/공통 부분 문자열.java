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
   static char[][] arr;
   static int[][] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,1,-1};
   static boolean[][] visit;
   static List<Integer>[] list;
   static TreeSet<Integer> set;  
   static TreeMap<Long,Long> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     
	        
//	     	StringTokenizer st=new StringTokenizer(br.readLine());
//	        N=Integer.parseInt(st.nextToken());
//	        M=Integer.parseInt(st.nextToken());
	       String str1=br.readLine();
	       String str2=br.readLine();
	       
	       dp=new int[str1.length()+1][str2.length()+1];
	       int N=str1.length();
	       int M=str2.length();
	       int max=0;
	       for(int k=1;k<=M;k++) {
	    	   for(int i=1;i<=N;i++) {
	    		   
	    		   if(str1.charAt(i-1)==str2.charAt(k-1)) {
	    			   dp[i][k]=Math.max(dp[i][k], dp[i-1][k-1]+1);
	    		   }
	    		   max=Math.max(max, dp[i][k]);
	    	   }
	       }
	 
	       System.out.println(max);
   }
    
}