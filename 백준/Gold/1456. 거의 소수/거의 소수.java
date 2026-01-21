import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static long N;
   static long M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static long max;
   static  StringBuilder sb;
   static int[] arr;
   static int[] dp;
   static long[]sum;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<Integer> list;
   static Set<Integer>[] set;  
   static Map<Integer,Integer>[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Long.parseLong(st.nextToken());
		 M=Long.parseLong(st.nextToken());
		 
		 max=(long)Math.sqrt(M);
		 
		 visit=new boolean[(int)max+1];
		 for(int i=2;i+i<=max;i++) {
			 if(visit[i])continue;
			 for(int k=i+i;k<=max;k+=i) {
				 visit[k]=true;
			 }
		 }
		 
		 for(long i=2;i<=max;i++) {
			 if(visit[(int)i])continue;
			
				ans+=cal(i);
			 
		 }
		 System.out.println(ans);
    }

    public static int cal(long x) {
    	long X=x*x;
    	int cnt=0;
    	while(X<=M) {
    		if(X>=N)cnt++;
    		if(X>M/x)break;
    		X*=x;
    		
    	}
    	
    	return cnt;
    }
  
}