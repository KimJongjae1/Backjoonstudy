import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int K;
    static int[][][][] dp;
     static int[] arr;
     static List<int[]>[] list;
     static boolean[][] visit;
     static int idx;
     static StringBuilder sb;
     static TreeSet<Integer> set;
     static Map<Integer,Integer> map;
     static int ans;
     static int[] diy= {-1,1,0,0};
     static int[] dix= {0,0,-1,1};
     static boolean flag;
     static long diff;
     static Stack<Integer>[] stack;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
  
	       StringTokenizer st=new StringTokenizer(br.readLine());
	       N=Integer.parseInt(st.nextToken());
	       arr=new int[26];
	       for(int i=0;i<N;i++) {
	    	   String str=br.readLine();
	    	   idx=1;
	    	   for(int k=str.length()-1;k>=0;k--) {
	    		   int n=str.charAt(k)-'A';
	    		   arr[n]+=idx;
	    		   idx*=10;
	    	   }
	    	   
	       }

	      int id=9;
	      while(true) {
	    	  int max=0;
	    	  idx=0;
	    	  for(int i=0;i<26;i++) {
	    		  if(max<arr[i]) {
	    			  max=arr[i];
	    			  idx=i;
	    		  }
	    	  }
	    	  if(max==0)break;
	    	  arr[idx]=0;
	    	  ans+=id*max;
	    	  id--;
	      }
	      System.out.println(ans);
	      
 	}
}