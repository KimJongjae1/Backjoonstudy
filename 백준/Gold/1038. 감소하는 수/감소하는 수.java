import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int K;
    static int[][][] dp;
     static int[] arr;
     static List<Long> list;
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
	       if(N>=1023) {
	    	   System.out.println(-1);
	    	   return;
	       }
	       list=new ArrayList<>();
	       
	       for(int i=0;i<=9;i++) {
	    	   BACK(1,i);
	       }
	       Collections.sort(list);
	       System.out.println(list.get(N));
	       
    }
    public static void BACK(int level,long n) {
    	if(level==11)return;
    	
    	int m=(int)n%10-1;
    	list.add(n);
    	for(int i=m;i>=0;i--) {
    		long NEW=n*10+i;
    		BACK(level+1,NEW);
    	}
    	
    }
 }