
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[][] arr;
     static List<int[]>[] list;
    static List<int[]>[] reverse;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static int ham;
    static int roma;
    static int max;
    static int cnt;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(br.readLine());
        list=new ArrayList[N+1];
        reverse=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
            reverse[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,p});
            reverse[b].add(new int[]{a,p,i});
        }   
        st=new StringTokenizer(br.readLine());
        ham=Integer.parseInt(st.nextToken());
        roma=Integer.parseInt(st.nextToken());
        BFS();
        BACK();
        System.out.println(max);
        System.out.println(cnt);
    }
    public static void BFS(){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{ham,0});
        dp=new int[N+1];
        dp[roma]=0;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
            int cost=cur[1];


            if(cur[0]==roma){
                if(max<cost) max=cost; 
                continue;
            }

             for(int[] next:list[cur[0]]){
                 if(dp[next[0]]<next[1]+cost){
                     dp[next[0]]=next[1]+cost;
                     qu.offer(new int[]{next[0],next[1]+cost});
                 }
             }
        }
    }
    public static void BACK(){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{roma,max});     
        visit=new boolean[M];
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            if(cur[0]==ham){
                continue;
            }

            for(int[] next:reverse[cur[0]]){
                if(visit[next[2]])continue;
                if(dp[next[0]]==cur[1]-next[1]){
                    visit[next[2]]=true;
                    cnt++;                  
                    qu.offer(new int[]{next[0],dp[next[0]]});
                }
            }
            
        }
        
    }
}