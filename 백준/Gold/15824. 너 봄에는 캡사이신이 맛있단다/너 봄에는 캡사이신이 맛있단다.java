import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[] arr;
     static List<Integer> list;
     static boolean[][] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static long ans;
    static long[] pow;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        ans=0;
        Arrays.sort(arr);
        pow=new long[N];
        long mod=1000000007; 
        PW(mod,pow);
        for(int i=0;i<N;i++){
            ans=(ans+arr[i]*(pow[i]%mod-pow[N-1-i]%mod)%mod)%mod;
        }
        
        System.out.println((ans+mod)%mod);
    }
    public static void PW(long mod,long[] pow){
        pow[0]=1;
      for(int level=1;level<N;level++){
        pow[level]=(pow[level-1]*2)%mod;
      }
    }
}