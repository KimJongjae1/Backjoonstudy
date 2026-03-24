import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[][] dp;
     static int[] arr;
     static List<int[]> list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
     static int[] parent;
     public static int find(int x){
         if(parent[x]==x)return x;
         return parent[x]=find(parent[x]);
     }
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();

         StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         M=Integer.parseInt(st.nextToken());
        dp=new int[N+1][M+1];
        dp[0][0]=1;
        for(int i=1;i<=N;i++){
            dp[i][0]=1;
            for(int k=1;k<=M;k++){
                dp[i][k]=(dp[i-1][k]%10007+dp[i-1][k-1]%10007)%10007;
            }
        }
        System.out.println(dp[N][M]);
         
    }
  
}