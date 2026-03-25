import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int K;
    static int[][] dp;
     static int[] arr;
     static List<int[]> list;
     static boolean[] visit;
     static int idx;
    static int max;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static boolean flag;
     static TreeMap<Integer,Integer> map;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();

         StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         M=Integer.parseInt(st.nextToken());
         K=Integer.parseInt(st.nextToken());

        int n=Integer.parseInt(br.readLine());
 
        arr=new int[21];
        max=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a]=b;
        }
        long use=0;
        
        for(int i=n-1;i>=0;i--){
            use*=8;

            long CUBE=(long)(N>>i)*(M>>i)*(K>>i)-use;
            long NEWCUBE=Math.min(CUBE,(long)arr[i]);

            use+=NEWCUBE;
            ans+=NEWCUBE;
        }
        if(use==(long)N*M*K)System.out.println(ans);
        else System.out.println(-1);
    }
 
 
}