
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
        Arrays.fill(dp[0],-32768 * 101);
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(br.readLine());
            sum[i]=sum[i-1]+arr[i];
         
        }
        dp[0][0]=0;
        for(int i=1;i<=N;i++){
            for(int k=1;k<=M;k++){
                dp[i][k]=dp[i-1][k];
                for(int q=i;q>0;q--){
                    if(q-2>=0)
                    dp[i][k]=Math.max(dp[i][k],sum[i]-sum[q-1]+dp[q-2][k-1]);
                    else if (k == 1 && q == 1) {
                        dp[i][k] = Math.max(dp[i][k], sum[i]);
                    }
                }
            }
        }

  
        System.out.println(dp[N][M]);
    }
}