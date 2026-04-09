import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int L;
    static int R;
    static long[][][] dp;
     static int[] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        dp=new long[N+1][N+1][N+1];
        dp[1][1][1]=1;
        int mod=1000000007;
        for(int i=2;i<=N;i++){
            for(int k=1;k<=i;k++){
                for(int q=1;q<=i;q++){
                    dp[i][k][q]=(dp[i-1][k-1][q]+dp[i-1][k][q-1]+dp[i-1][k][q]*(i-2)%mod)%mod;
                }
            }
        }
        System.out.println(dp[N][L][R]);
    }
}