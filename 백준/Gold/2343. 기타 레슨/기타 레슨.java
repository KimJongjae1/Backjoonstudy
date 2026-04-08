import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
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
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        int sum=0;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }
        int n=lowerbound(sum);
        System.out.println(n);
    }
    public static int lowerbound(int sum){
        int max=sum;
        int min=1;
        while(min<max){
            int mid=(max+min)/2;

            if(check(mid)>M){
                min=mid+1;
            }else{
                max=mid;
            }
        }
        return min;
    }
    public static int check(int mid){
        int sum=0;
        int cnt=0;
        for(int i=0;i<N;i++){
            if(arr[i]>mid)return Integer.MAX_VALUE;
            sum+=arr[i];
            if(sum>mid){
                sum=arr[i];
                cnt++;
            }else if(mid==sum){
                cnt++;
                sum=0;
                continue;
            }

            if(i==N-1)
                cnt++;
            
        }
        return cnt;
    }
}