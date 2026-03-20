import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[][] arr;
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
        M=Integer.parseInt(st.nextToken());
        arr=new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a][b]=1;
        }

        for(int i=1;i<=N;i++){
            for(int k=1;k<=N;k++){
                for(int q=1;q<=N;q++){
                    if(arr[k][i]==1&&arr[k][i]==arr[i][q]){
                        arr[k][q]=1;
                    }
                }
            }
        }

        dp=new int[N+1];
        for(int i=1;i<=N;i++){
            for(int k=1;k<=N;k++){
                if(arr[i][k]==1){
                    dp[k]++;
                    dp[i]++;
                }
            }
        }
        int cnt=0;
        for(int i=1;i<=N;i++){
            if(dp[i]==N-1)cnt++;
        }
        System.out.println(cnt);
    }
}