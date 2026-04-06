import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int K;
    static int[][][] dp;
     static int[][] arr;
     static List<int[]> list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] parent;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public static int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
    
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        dp=new int[N][M][K+1];
        
        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int k=0;k<M;k++){
                arr[i][k]=str.charAt(k)-'0';
                for(int q=0;q<=K;q++){
                    dp[i][k][q]=Integer.MAX_VALUE;
                }
            }
        }
           BFS();
    }
    public static void BFS(){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{0,0,0,1});
        dp[0][0][0]=1;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            if(cur[0]==N-1&&cur[1]==M-1){
                System.out.println(cur[3]);
                return;
            }
            
            for(int i=0;i<4;i++){
                int y=cur[0]+diy[i];
                int x=cur[1]+dix[i];
                if(y<0||x<0||y>=N||x>=M)continue;
                
                int BREAK=cur[2];
                if(arr[y][x]==1)BREAK++;
                if(BREAK>K)continue;
                
                if(dp[y][x][BREAK]<=cur[3]+1)continue;
                dp[y][x][BREAK]=cur[3]+1;
                qu.offer(new int[]{y,x,BREAK,cur[3]+1});
            }
            
        }
        System.out.println(-1);
    }
}