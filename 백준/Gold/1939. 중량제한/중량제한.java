
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[][] arr;
     static List<int[]>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static int Fac1;
    static int Fac2;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        list=new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            list[i]=new ArrayList<>();
        
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        st=new StringTokenizer(br.readLine());
        Fac1=Integer.parseInt(st.nextToken());
        Fac2=Integer.parseInt(st.nextToken());
        BFS();
        System.out.println(dp[Fac2]);
    }
    public static void BFS(){
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return b[1]-a[1];
            }
        });
        pq.offer(new int[]{Fac1,Integer.MAX_VALUE});
        dp=new int[N+1];
        dp[Fac1]=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();

            if(dp[cur[0]]>cur[1])continue;
            if(cur[0]==Fac2)continue;

            for(int[] next:list[cur[0]]){
                int max=Math.min(next[1],cur[1]);
                if(dp[next[0]]>=max)continue;
                   dp[next[0]]=max;
                   pq.offer(new int[]{next[0],max});
            }
        }
        
    }
}