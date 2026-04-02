import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[][][] dp;
     static int[][] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] diy={-1,0,1,0};
    static int[] dix={0,-1,0,1};
    static int All;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        int cnt=1;
        int start=0;
        int end=0;
        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int k=0;k<M;k++){
                char a=str.charAt(k);
                if(a=='#'){
                    arr[i][k]=-1;
                }else if(a=='S'){
                    start=i*M+k;
                }else if(a=='E'){
                    end=i*M+k;
                }else if(a=='X'){
                    arr[i][k]=cnt++;
                }
            }
        }

        All=((1<<(cnt))-1);
 
        dp=new int[N][M][64];
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                for(int q=0;q<=63;q++){
                    dp[i][k][q]=Integer.MAX_VALUE;
                }
            }
        }
        BFS(start,end);
    }
    public static void BFS(int start,int end){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{start/M,start%M,1,0});
        dp[start/M][start%M][1]=0;
        int Y=end/M;int X=end%M;
        
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            if(dp[cur[0]][cur[1]][cur[2]]<cur[3])continue;
            if(cur[0]==Y&&cur[1]==X&&cur[2]==All){
                System.out.println(cur[3]);
                return;
            }
         
            for(int i=0;i<4;i++){
                int y=cur[0]+diy[i];
                int x=cur[1]+dix[i];
                if(y<0||y>=N||x<0||x>=M)continue;
                if(arr[y][x]==-1)continue;
                
                int cnt=cur[2]|(1<<arr[y][x]);
             
                if(dp[y][x][cnt]<=cur[3]+1) continue;
                dp[y][x][cnt]=cur[3]+1;
                
                qu.offer(new int[]{y,x,cnt,cur[3]+1});
            }
        }
    }
}