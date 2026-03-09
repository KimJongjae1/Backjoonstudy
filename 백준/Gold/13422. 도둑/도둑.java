import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static int K;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int t=0;t<T;t++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            arr=new int[N+M];
            
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
                arr[i]=Integer.parseInt(st.nextToken());
            
            for(int i=N;i<N+M-1;i++)
                arr[i]=arr[i-N];

            int sum=0;
            for(int i=0;i<M;i++){
                sum+=arr[i];
            }
            int ans=0;
            if(sum<K)ans++;
            if(N<=M) {
                sb.append(ans+"\n");
                continue;
            }
            for(int i=M;i<N+M-1;i++){
                sum-=arr[i-M];
                sum+=arr[i];
                if(sum<K)ans++;
            }
            sb.append(ans+"\n");
            
        }
        System.out.println(sb);
            }
}