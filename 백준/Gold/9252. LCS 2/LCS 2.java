import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
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
   static long[] dp;
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
     	//StringTokenizer st=new StringTokenizer(br.readLine());
        //N=Integer.parseInt(st.nextToken());
       
        String str1=br.readLine();
        String str2=br.readLine();
         N=str1.length();
        M=str2.length();
        int[][] dp=new int[N+1][M+1];
        for(int i=1;i<=M;i++){
            char B=str2.charAt(i-1);
            for(int k=1;k<=N;k++){
                char A=str1.charAt(k-1);
                 dp[k][i]=Math.max(dp[k][i-1],dp[k-1][i]);
                if(A==B){
                    dp[k][i]=Math.max(dp[k][i],1+dp[k-1][i-1]);
                }
            }
        }
     System.out.println(dp[N][M]);
       if(dp[N][M]==0)return;
       while(N>0&&M>0) {
    	  
    	   
    	   if(str1.charAt(N-1)==str2.charAt(M-1)) {
    		   sb.append(str1.charAt(N-1));
    		   N--;
    		   M--;
    	   }
    	   else if(dp[N][M]==dp[N-1][M])N--;
    	   else M--;

       }
       

        System.out.println(sb.reverse());
    	
    	
    }
}