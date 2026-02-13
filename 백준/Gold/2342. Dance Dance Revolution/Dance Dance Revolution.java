import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
   static int[][][] dp;
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
       list=new ArrayList<>();
     	while(true) {
     		int n=Integer.parseInt(st.nextToken());
     		
     		if(n==0)break;
     		list.add(n);
     	}
     	
     	N=list.size();
     	dp=new int[N+3][5][5];
     	for(int w=0;w<5;w++)Arrays.fill(dp[0][w], Integer.MAX_VALUE);
     	dp[0][0][0]=0;
     	for(int i=1;i<=N;i++) {
     		
     		for(int w=0;w<5;w++)
     			Arrays.fill(dp[i][w], Integer.MAX_VALUE);
     		
     		for(int k=0;k<=4;k++) {
     			for(int q=0;q<=4;q++) {
     				
     					int next=list.get(i-1);
     					if(dp[i-1][k][q]==Integer.MAX_VALUE)continue;
     					dp[i][next][q]=Math.min(dp[i][next][q],send(k,next)+dp[i-1][k][q]);
     					dp[i][k][next]=Math.min(dp[i][k][next],send(q,next)+dp[i-1][k][q]);
     
     			}
     		}
     	}
     	
       ans=Integer.MAX_VALUE;
        for(int i=0;i<=4;i++) {
        	for(int k=0;k<=4;k++) {
  
        		if(dp[N][i][k]==0)continue;
        		ans=Math.min(ans, dp[N][i][k]);
        	}
        }
    	System.out.println(ans);
    	
    }
    public static int send(int feet,int next) {
    	
    	if(feet==next) return 1;
    	else if(feet==0) return 2;
    	else if(Math.abs(next-feet)==2)return 4;
    	else return 3;
    	
    }
}