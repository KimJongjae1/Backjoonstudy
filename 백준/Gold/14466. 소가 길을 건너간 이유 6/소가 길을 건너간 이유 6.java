import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int K;
    static int R;
    static List<Set<Integer>>[] set;
    static int[][] arr;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static int ans=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        set=new ArrayList[N];
        for(int i=0;i<N;i++){
            set[i]=new ArrayList<>();
            for(int k=0;k<N;k++){
                set[i].add(new HashSet<>());
            }
        }
        
        for(int i=0;i<R;i++){
             st=new StringTokenizer(br.readLine());
              int r=Integer.parseInt(st.nextToken());  
              int c=Integer.parseInt(st.nextToken());  
              int R=Integer.parseInt(st.nextToken());  
              int C=Integer.parseInt(st.nextToken());
                r--;
                c--;
                R--;
                C--;
              set[r].get(c).add(R*N+C);  
              set[R].get(C).add(r*N+c);
            
        }
        arr=new int[N][N];
        
        for(int i=0;i<K;i++){
             st=new StringTokenizer(br.readLine());
             int r=Integer.parseInt(st.nextToken());  
             int c=Integer.parseInt(st.nextToken()); 
            r--;c--;
             arr[r][c]=1;

        }
       Loop:for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                if(arr[i][k]==1){
                    BFS(i,k);
                     if(K<=1){
                         break Loop;
                     }
                }
               
            }
        }
        System.out.println(ans);

    }
    public static void BFS(int y,int x){
        arr[y][x]=0;
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{y,x});
        boolean[][] visit=new boolean[N][N];
        visit[y][x]=true;
        int cnt=1;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            for(int i=0;i<4;i++){
                int Y=cur[0]+diy[i];
                int X=cur[1]+dix[i];
                if(Y<0||Y>=N||X<0||X>=N)continue;
                if(visit[Y][X])continue;
                if(set[cur[0]].get(cur[1]).contains(Y*N+X)) continue;
                visit[Y][X]=true;
                if(arr[Y][X]==1){
                    cnt++;
                    arr[Y][X]=0;
                }
                qu.offer(new int[]{Y,X});
            }
            
        }
        K-=cnt;
        ans+=cnt*K;
    }
}