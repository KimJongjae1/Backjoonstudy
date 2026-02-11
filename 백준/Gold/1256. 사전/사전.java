import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        long[][] dp=new long[N+1][M+1];
        for(int i=0;i<=N;i++)dp[i][0]=1;
        for(int k=0;k<=M;k++) dp[0][k]=1;
        for(int i=1;i<=N;i++){
            for(int k=1;k<=M;k++){
                dp[i][k]=Math.min(1000000000,dp[i-1][k]+dp[i][k-1]);
            }
        }
        
        if(K>dp[N][M]){
            System.out.println(-1);
            return;
        }

       StringBuilder sb = new StringBuilder();
        int n = N, m = M;

        while (n > 0 && m > 0) {
            long cntA = dp[n - 1][m]; // 앞에 'a'를 붙였을 때 가능한 문자열 수
            if (K <= cntA) {
                sb.append('a');
                n--;
            } else {
                sb.append('z');
                K -= cntA;
                m--;
            }
        }
    
        while(n>0){
            sb.append('a');
            n--;
        }
         while(m>0){
            sb.append('z');
            m--;
        }
         
        System.out.println(sb);
        
    }
}