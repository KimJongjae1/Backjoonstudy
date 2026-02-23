import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] arr;
    static class node{
        int id;
        int L;
        int R;

        node(int id,int L,int R){
            this.id=id;
            this.L=L;
            this.R=R;
        }
        
    }
    static node[] n;
    static int[][] dp;
    static int cnt;
    static int l;
    static int max;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
         sb=new StringBuilder();
         N=Integer.parseInt(st.nextToken());
        n=new node[N+1];
        dp=new int[N+1][2];
     
        Set<Integer> set=new HashSet<>();
        for(int i=1;i<=N;i++){
            set.add(i);
        }
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int L=Integer.parseInt(st.nextToken());
            int R=Integer.parseInt(st.nextToken());
            set.remove(L);
            set.remove(R);
            n[s]=new node(s,L,R);
        }
        
        l=Integer.MAX_VALUE;
        cnt=0;
        for(int i=1;i<=N;i++){
            dp[i][0]=10000000;
        }
         for(int root:set){
            middle(root,1);
         }
        
        
           for (int i = 1; i <= N; i++)
            {
                if (dp[i][0] == 10000000) break;
                int diff = dp[i][1] - dp[i][0] + 1;
                if (max < diff)
                {
                    max = diff;
                    l = i;
                }
            }

        System.out.println(l+" "+max);
       
        
        
    }
    public static void middle(int cur,int level){
        if(cur==-1)return;
        
        middle(n[cur].L,level+1);
        
        cnt++;
        dp[level][0]=Math.min(dp[level][0],cnt);
        dp[level][1]=Math.max(dp[level][1],cnt);
       
        
        middle(n[cur].R,level+1);
       
    }
}