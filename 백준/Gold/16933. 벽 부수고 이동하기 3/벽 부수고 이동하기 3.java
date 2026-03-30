import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int K;
    static int[][][] dp;
     static int[][] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();

         StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         M=Integer.parseInt(st.nextToken());
         K=Integer.parseInt(st.nextToken());
         dp=new int[N][M][K+1];
        arr=new int[N][M];
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
        int max=Integer.MAX_VALUE;
        for(int i=0;i<=K;i++){
            max=Math.min(max,dp[N-1][M-1][i]);
        }
        if(max==Integer.MAX_VALUE)System.out.println(-1);
        else System.out.println(max);
    }
    public static void BFS(){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{0,0,K,1});
        dp[0][0][K]=1;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
            int breakWall=cur[2];

           if(cur[3]>dp[cur[0]][cur[1]][breakWall])continue;
  
            for(int i=0;i<4;i++){
                int y=cur[0]+diy[i];
                int x=cur[1]+dix[i];
                if(y<0||x<0||y>=N||x>=M)continue;
 
                if(cur[3]%2==1){//낮
                    if(arr[y][x]==1){
                        if(breakWall==0)continue;
                        
                        if(dp[y][x][breakWall-1]<=cur[3]+1)continue;
                        dp[y][x][breakWall-1]=cur[3]+1;
                        qu.offer(new int[]{y,x,breakWall-1,cur[3]+1});
                    }
                    else{
                        if(dp[y][x][breakWall]<=cur[3]+1)continue;
                        dp[y][x][breakWall]=cur[3]+1;
                        qu.offer(new int[]{y,x,breakWall,cur[3]+1});
                    }
                }
                else{
                     if(arr[y][x]==1){
                        if(breakWall==0)continue;

                        if(dp[y][x][breakWall-1]<=cur[3]+2)continue;
                        dp[y][x][breakWall-1]=cur[3]+2;
                        qu.offer(new int[]{y,x,breakWall-1,cur[3]+2});
                    }
                    else{
                        if(dp[y][x][breakWall]<=cur[3]+1)continue;
                        dp[y][x][breakWall]=cur[3]+1;
                        qu.offer(new int[]{y,x,breakWall,cur[3]+1});
                    }
                } 
            }
        }
 
    }
}