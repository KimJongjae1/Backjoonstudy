import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int C;
    static int[][] dp;
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
         dp=new int[N+1][C+101];
   
          for(int i=1;i<=N;i++){
              st=new StringTokenizer(br.readLine());
              int cost=Integer.parseInt(st.nextToken());
              int customer=Integer.parseInt(st.nextToken());
              
              arr[i][0]=cost;
              arr[i][1]=customer;
    
          }
        Arrays.fill(dp[0],Integer.MAX_VALUE/2);
          for(int k=1;k<C+101;k++){
              for(int i=1;i<=N;i++){
                  if(dp[i][k]==0)dp[i][k]=Integer.MAX_VALUE/2;
                  
                  dp[i][k]=Math.min(dp[i-1][k],dp[i][k]);
                  if(k>=arr[i][1]){
                      dp[i][k]=Math.min(dp[i][k],dp[i][k-arr[i][1]]+arr[i][0]);
                  }
                  if(k>=C)ans=Math.min(ans,dp[i][k]);
              }
          }
    
        System.out.println(ans);
       
    }
    
}