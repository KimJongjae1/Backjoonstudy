import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
   static int[] arr;
   static long[][][] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<int[]> list;
   static TreeSet<Integer> set;  
   static TreeMap<Integer,Integer> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        
        dp=new long[N+1][11][1<<10];
        
        for(int i=1; i<10; i++) {
			dp[1][i][1<<i] =1;
		}
        long MOD=1000000000;
        for(int i=2;i<=N;i++) {//len
        	for(int k=0;k<10;k++) {//뒤에 넣을 수 
        		for(int q=0;q<1024;q++) {
        			int bit=q|(1<<k);
        			if(k==0) {
        				dp[i][k][bit]+=(dp[i-1][k+1][q])%MOD;
        			}else if(k==9) {
        				dp[i][k][bit]+=(dp[i-1][k-1][q])%MOD;
        			}else {
        				dp[i][k][bit]+=(dp[i-1][k+1][q]+dp[i-1][k-1][q])%MOD;
        			}
        			dp[i][k][bit]%=MOD;
        			
        			
        		}
        	}
        }
        long ans=0;
        for(int i=0;i<10;i++) {
        	ans=(ans+dp[N][i][1023])%MOD;
        }
        System.out.println(ans);
    	
    }
}