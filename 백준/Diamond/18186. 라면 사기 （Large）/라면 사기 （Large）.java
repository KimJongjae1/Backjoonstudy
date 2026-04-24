
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int K; 
    static long[] dp;
     static long[] arr;
     static List<int[]>[] list;
     static boolean[][][] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static long ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        long B=Integer.parseInt(st.nextToken());
        long C=Integer.parseInt(st.nextToken());
        arr=new long[N+3];
         ans=0;
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<N;i++){
            
            if(B<=C){
                ans+=arr[i]*B;
            }else{
                long n;
                if(arr[i+1]>arr[i+2]){
                    n=Math.min(arr[i],arr[i+1]-arr[i+2]);
                    ans+=n*(B+C);
                    arr[i]-=n;
                    arr[i+1]-=n;
                }
                n=Math.min(arr[i],Math.min(arr[i+1],arr[i+2]));
                ans+=n*(B+2*C);
                arr[i]-=n;
                arr[i+1]-=n;
                arr[i+2]-=n;

                

                ans+=arr[i]*B;
                arr[i]=0;
                
                
            }
        }
      
         System.out.println(ans);
    }  
    
}