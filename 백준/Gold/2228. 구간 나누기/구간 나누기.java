
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[][] dp;
     static int[] arr;
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
        arr=new int[N+1];
        dp=new int[N+1][M+1];
        int[] sum=new int[N+1];
 
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(br.readLine());
            sum[i]=sum[i-1]+arr[i];

        }
        for(int i=0;i<=N;i++){
            for(int k=1;k<=M;k++){
                dp[i][k]=Integer.MIN_VALUE/2;
            }
        }
        dp[1][1]=arr[1];
        for(int i=2;i<=N;i++){
            
            for(int k=1;k<=M;k++){
                dp[i][k]=dp[i-1][k];
                 if(k==1) dp[i][1] = Math.max(dp[i][1], sum[i]);
                
                for(int q=0;q<=i-2;q++){
                    dp[i][k]=Math.max(dp[i][k],sum[i]-sum[q+1]+dp[q][k-1]); 
                }
            }
        }

  
        System.out.println(dp[N][M]);
    }
}