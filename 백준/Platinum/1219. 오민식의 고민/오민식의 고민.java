import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static long[] dp;
     static int[] arr;
     static List<int[]>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] parent;
    static boolean reach=false;
    static boolean cy=false;
    static int max;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        list=new ArrayList[N];
        
        for(int i=0;i<N;i++)
            list[i]=new ArrayList<>();
       
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            list[s].add(new int[]{e,c});
        }
        st=new StringTokenizer(br.readLine());
        arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        cycle(S,E);
        if(!reach){
            System.out.println("gg");
        }else if(cy){
            System.out.println("Gee");
        }else{
            System.out.println(dp[E]);
        }
    }
    public static void cycle(int s,int e){
        dp=new long[N];
        Arrays.fill(dp,Long.MIN_VALUE);
        dp[s]=arr[s];
        for(int q=0;q<N-1;q++){
             for(int i=0;i<N;i++){
                 if(dp[i]==Long.MIN_VALUE)continue;
                 for(int[] next:list[i]){
                     if(dp[next[0]]<dp[i]-next[1]+arr[next[0]]){
                         dp[next[0]]=dp[i]-next[1]+arr[next[0]];
                     }
                 }
             }
        }
        
        if(dp[e]!=Long.MIN_VALUE)
            reach=true;
        
        
        List<Integer> CycleList=new ArrayList<>();
         for(int i=0;i<N;i++){
                if(dp[i]==Long.MIN_VALUE)continue;
             
                 for(int[] next:list[i]){
                     if(dp[next[0]]<dp[i]-next[1]+arr[next[0]]){
                         CycleList.add(next[0]);
                         CycleList.add(i);
                     }
                 }
             
             }
        visit=new boolean[N];
        for(int n:CycleList){
            if(!visit[n]){
                cy=BFS(n,e);
            }
            if(cy)return;
        }

        for(int i=0;i<N;i++){
                 if(dp[i]==Long.MIN_VALUE)continue;
                 for(int[] next:list[i]){
                     if(dp[next[0]]<dp[i]-next[1]+arr[next[0]]){
                         dp[next[0]]=dp[i]-next[1]+arr[next[0]];
                     }
                 }
         }

    }
    public static boolean BFS(int s,int e){
        if(s==e)return true;
        Queue<Integer> pq=new LinkedList<>();
        pq.offer(s);
        
        visit[s]=true;
        while(!pq.isEmpty()){
            int cur= pq.poll();

            if(cur==e)return true;
            
            for(int[] next:list[cur]){
                if(visit[next[0]])continue;
                visit[next[0]]=true;
                pq.offer(next[0]);
            }
        }
         return false;
    }
}