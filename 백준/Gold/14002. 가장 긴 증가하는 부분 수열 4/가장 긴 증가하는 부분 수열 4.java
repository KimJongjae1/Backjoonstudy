import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];
         st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp=new int[N];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<N-1;i++){
            for(int k=i+1;k<N;k++){
                if(arr[i]<arr[k]){
                    dp[k]=Math.max(dp[k],dp[i]+1);
                    max=Math.max(max,dp[k]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int id=max;
        int[] a=new int[max];
        for(int i=N-1;i>=0;i--){
            if(dp[i]==id){
                a[id-1]=arr[i];
                 id--;
                if(id<=0)break;
            }
        }
        for(int i=0;i<max;i++){
            sb.append(a[i]+" ");
        }
        System.out.println(max);
        System.out.println(sb);
    }
    
}