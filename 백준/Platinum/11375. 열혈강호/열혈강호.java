
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[][] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static int[] match;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        list=new ArrayList[N+1];
        for(int i=0;i<=N;i++)
            list[i]=new ArrayList<>();
        match=new int[M+1];
        visit=new boolean[M+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());

            for(int k=0;k<n;k++){
                int a=Integer.parseInt(st.nextToken());  
                list[i].add(a);
            }
        }
        for(int i=1;i<=N;i++){
            Arrays.fill(visit,false);

            if(dfs(i)){
                ans++;
            }
        }
        System.out.println(ans);
    }
    public static boolean dfs(int people){
        for(int work:list[people]){
            if(visit[work])continue;
            visit[work]=true;
            if(match[work]==0||dfs(match[work])){
                match[work]=people;
                return true;
            }
        }
        return false;
    }
}