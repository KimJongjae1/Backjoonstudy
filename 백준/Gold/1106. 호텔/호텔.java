import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int C;
    static int[] dp;
     static int[][] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans=100000000;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
         StringTokenizer st=new StringTokenizer(br.readLine());
         C=Integer.parseInt(st.nextToken());
         N=Integer.parseInt(st.nextToken());
        arr=new int[N+1][2];
         dp=new int[C+101];
           Arrays.fill(dp,Integer.MAX_VALUE/2);
         dp[0]=0;
          for(int i=1;i<=N;i++){
              st=new StringTokenizer(br.readLine());
              int cost=Integer.parseInt(st.nextToken());
              int customer=Integer.parseInt(st.nextToken());
              
              for(int k=customer;k<C+101;k++){
                  dp[k]=Math.min(dp[k],dp[k-customer]+cost);
                  if(k>=C) ans=Math.min(ans,dp[k]);
              }
          }
       
        System.out.println(ans);
       
    }
    
}