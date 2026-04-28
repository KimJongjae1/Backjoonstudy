import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[][] dp;
     static int[][] arr;
     static List<int[]>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        dp=new int[N+1][M+1];
      
        System.out.println(Divide(N,M));
      
    }
    public static int Divide(int n,int k){
        if(k==1||n<=2) return n;
        if(dp[n][k]>0)return dp[n][k];
        dp[n][k]=Integer.MAX_VALUE;
        
        for(int i=1;i<=n;i++){
            dp[n][k]=Math.min(dp[n][k],Math.max(Divide(i-1,k-1),Divide(n-i,k))+1);
        }

        
        return dp[n][k];
    }
}