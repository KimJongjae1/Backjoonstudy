import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
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
   static long max;
   static  StringBuilder sb;
   static long[] arr;
   static int[] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static int[] visit;
   static List<int[]>[] list;
   static TreeSet<Integer> set;  
   static Map<Integer,Integer>[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		T=Integer.parseInt(st.nextToken());
		dp=new int[10001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		dp[1]=1;
		dp[10]=1;
		dp[25]=1;
		for(int i=2;i<100;i++) {
			for(int k=1;k<i;k++) {
				dp[i]=Math.min(dp[i], dp[k]+dp[i-k]);
			}
		}
		
		
		
		for(int t=0;t<T;t++) {
			
			Long n=Long.parseLong(br.readLine());
			int ret=0;
			while(n>0) {
				ret+=dp[(int)(n%100)];
				n/=100;
			}
			System.out.println(ret);
		}
		
		
    }
    
}