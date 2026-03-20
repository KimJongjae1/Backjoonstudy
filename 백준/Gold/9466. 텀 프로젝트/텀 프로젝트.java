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
    static int[] indegree;
    static int[] status;
    static int[] cycle;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();

        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
         idx=1;
             StringTokenizer st=new StringTokenizer(br.readLine());
             N=Integer.parseInt(st.nextToken());
             arr=new int[N+1];
             cycle=new int[N+1];
             status=new int[N+1];
            st=new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                int n=Integer.parseInt(st.nextToken());
                arr[i]=n;
            }
            for(int i=1;i<=N;i++){
                if(cycle[i]==0){
                    DFS(i);
                    idx++;
                }
            }
            ans=N;
            for(int i=1;i<=N;i++){
                if(status[i]==2) ans--;
            }
            sb.append(ans+"\n");
       }
        System.out.println(sb);
    }
   public static void DFS(int cur){
       if(status[cur]>=2)return;
       if(cycle[cur]>0&&idx!=cycle[cur])return;
       cycle[cur]=idx;
        if(status[cur]==0){
            status[cur]=1;
            DFS(arr[cur]);
        }else{
            status[cur]=2;
            DFS(arr[cur]);
        }
       
   }
}