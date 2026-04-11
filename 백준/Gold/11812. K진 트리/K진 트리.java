import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static long N;
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
     static long diff;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
  
	       StringTokenizer st=new StringTokenizer(br.readLine());
	       N=Long.parseLong(st.nextToken());
	       K=Integer.parseInt(st.nextToken());
	       M=Integer.parseInt(st.nextToken());
	       diff=K-2;
	   
	       for(int i=0;i<M;i++) {
	    	   st=new StringTokenizer(br.readLine());
	    	   long s=Long.parseLong(st.nextToken());       
	    	   long e=Long.parseLong(st.nextToken());	 
	       	   int dist=0;
	       
	       	   if(e<s) {
	       		   long temp=e;
	       		   e=s;
	       		   s=temp;
	       	   }else if(e==s) {
	       		   sb.append(0+"\n");
	       	   }
	       	   if(K==1) {
	       		   sb.append(e-s).append("\n");
	       		   continue;
	       	   }
	       	   int levelS=LEVEL(s);
	       	   int levelE=LEVEL(e);
	    
	       	   while(levelS<levelE) {
	       		   e=(e+diff)/K;
	       		   levelE--;
	       		   dist++;
	       		
	       	   }
	       	   
	       	   while(s!=e) {
	       		   e=(e+diff)/K;
	       		   levelE--;
	       		   dist++;
	       		   
	       		   s=(s+diff)/K;
	       		   levelS--;
	       		   dist++;
	       	   }
	       	   sb.append(dist+"\n");
	       }
	       System.out.println(sb);
    }
    public static int LEVEL(long n) {
    	int level=0;
    	long L=n;
	   while(L>0) {
		   L=(L+diff)/K;
   		   level++;
	   }
	   return level;
   }
    
 }