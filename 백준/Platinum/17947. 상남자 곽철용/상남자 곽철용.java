import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int K;
    static int[][][] dp;
     static int[] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
     static int[] diy= {-1,1,0,0};
     static int[] dix= {0,0,-1,1};
     static boolean flag;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
  

	       StringTokenizer st=new StringTokenizer(br.readLine());
	       N=Integer.parseInt(st.nextToken());
	       M=Integer.parseInt(st.nextToken());
	       K=Integer.parseInt(st.nextToken());
	       set=new HashSet<>();
	       int a=0;
	       int b=0;
	       for(int i=1;i<=M+1;i++) {
	    	   st=new StringTokenizer(br.readLine());
	    	   a=Integer.parseInt(st.nextToken());
	    	   b=Integer.parseInt(st.nextToken());
	    	   set.add(a);
	    	   set.add(b);
	       }
	       
	       arr=new int[K];

	      for(int i=1;i<=4*N;i++) {
	    	  if(set.contains(i))continue;
	    	  arr[i%K]++;
	      }
	      a%=K; b%=K;
	      int diff=Math.abs(a-b)+1;
	      int left=0;
	      
	      for(int i=diff;i<K;i++) {
	    	  if(arr[i-diff]>0) left+=arr[i-diff];
	    	  int n=Math.min(arr[i], left);
	    	  if(n<=0)continue;
	    	   left-=n;
	    	   ans+=n;

	      }
	      if(ans>=M)ans=M-1;
	      System.out.println(ans);
	      
    }
 }