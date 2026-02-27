import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static int[][] arr;
    static PriorityQueue<int[]> start;
    static int[][] dp;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static int Max;
    public static void main(String[] args)throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
          
            StringTokenizer st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            arr=new int[N][M];
              dp=new int[N][M];
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    arr[i][k]=Integer.parseInt(st.nextToken());
                    dp[i][k]=100000000;
                }
            }
        start=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[2]-b[2];
            }
        });
             for(int k=0;k<M;k++){
                    if(arr[0][k]==1)dp[0][k]=1;
                    else dp[0][k]=0;
                    if(arr[N-1][k]==1)dp[N-1][k]=1;
                    else dp[N-1][k]=0;
                 
                 start.offer(new int[]{0,k,dp[0][k]});
                 start.offer(new int[]{N-1,k,dp[N-1][k]});
                
             }
              for(int k=0;k<N;k++){
                    if(arr[k][0]==1)dp[k][0]=1;
                    else dp[k][0]=0;
                    if(arr[k][M-1]==1)dp[k][M-1]=1;
                    else dp[k][M-1]=0;
                  
                 start.offer(new int[]{k,0,dp[k][0]});
                 start.offer(new int[]{k,M-1,dp[k][M-1]});
               
             }
              
            Max=0;
            BFS();
            int ans=0;
            boolean[][] visit=new boolean[N][M];

       
            
            for(int i=0;i<N;i++){
                for(int k=0;k<M;k++){
                    if(visit[i][k])continue;
                     if(arr[i][k]==0){
                         
                         if(Max<dp[i][k]){
                             ans=0;
                             Max=dp[i][k];
                             ans=Math.max(ans,CHECKBFS(i,k,visit)); 
                         }else if(Max==dp[i][k]){
                             ans+=CHECKBFS(i,k,visit); 
                         }
                     }
                  
                }
            }
            System.out.println(Max+" "+ans);
    
        }
    }
    public static void BFS(){
        while(!start.isEmpty()){
            int[] cur=start.poll();
             if(cur[2]>dp[cur[0]][cur[1]])continue;
            
            for(int i=0;i<4;i++){
                int Y=cur[0]+diy[i];
                int X=cur[1]+dix[i];
                if(Y<0||Y>=N||X<0||X>=M)continue;
                int cost=cur[2];
                if(arr[Y][X]==1){
                    cost++;
                }

                if(dp[Y][X]<=cost)continue;
                dp[Y][X]=cost;
                 
                start.offer(new int[]{Y,X,cost});
            }
        }
    }
    public static int CHECKBFS(int y,int x,boolean[][] visit){
            Queue<int[]> qu=new LinkedList<>();    
        qu.offer(new int[]{y,x});
           visit[y][x]=true;
            int cnt=1;
           while(!qu.isEmpty()){
            int[] cur=qu.poll();
 
            for(int i=0;i<4;i++){
                int Y=cur[0]+diy[i];
                int X=cur[1]+dix[i];
                if(Y<0||Y>=N||X<0||X>=M)continue;
                if(visit[Y][X])continue;
                if(arr[Y][X]==1)continue;
                visit[Y][X]=true;
                cnt++;
                qu.offer(new int[]{Y,X});
            }
        }
        return cnt;
    }
}