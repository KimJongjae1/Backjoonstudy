import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int K;
    static int[][] dp;
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
         dp=new int[N][M];
        arr=new int[N][M];
        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int k=0;k<M;k++){
                arr[i][k]=str.charAt(k)-'0';
             
                dp[i][k]=11;
                
            }
        }
        ans=Integer.MAX_VALUE;
        BFS();
        if(ans==Integer.MAX_VALUE)System.out.println(-1);
        else System.out.println(ans);
        
    }
    public static void BFS(){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{0,0,0,1});
        dp[0][0]=0;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
            int breakWall=cur[2];

            if(cur[0]==N-1&&cur[1]==M-1){
                ans=Math.min(ans,cur[3]);
                continue;
            }
            
            for(int i=0;i<4;i++){
                int y=cur[0]+diy[i];
                int x=cur[1]+dix[i];
                if(y<0||x<0||y>=N||x>=M)continue;
 
                if(cur[3]%2==1){//낮
                    if(arr[y][x]==1){
                        if(breakWall==K)continue;
                        
                        if(dp[y][x]<=breakWall+1)continue;
                        dp[y][x]=breakWall+1;
                        qu.offer(new int[]{y,x,breakWall+1,cur[3]+1});
                    }
                    else{
                        if(dp[y][x]<=breakWall)continue;
                        dp[y][x]=breakWall;
                        qu.offer(new int[]{y,x,breakWall,cur[3]+1});
                    }
                }
                else{
                     if(arr[y][x]==1){
                        if(breakWall==K)continue;

                        qu.offer(new int[]{cur[0],cur[1],breakWall,cur[3]+1});
                    }
                    else{
                        if(dp[y][x]<=breakWall)continue;
                        dp[y][x]=breakWall;
                        qu.offer(new int[]{y,x,breakWall,cur[3]+1});
                    }
                } 
            }
        }

    }
}