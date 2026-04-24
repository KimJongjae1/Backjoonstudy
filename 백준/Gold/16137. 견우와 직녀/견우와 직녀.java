
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[][] arr;
     static List<int[]>[] list;
     static boolean[][][] visit;
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
        arr=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                arr[i][k]=Integer.parseInt(st.nextToken());
                if(arr[i][k]==0)
                    arr[i][k]=21;
                
            }
        }
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                if(arr[i][k]==21)
                  checkD(i,k);
            }
        }
        ans=10000000;
        BFS();
        System.out.println(ans);
    }
    public static void checkD(int y,int x){
        boolean row=false;
        boolean col=false;
        for(int i=0;i<2;i++){
            int Y=y+diy[i];
            int X=x+dix[i];
            if(Y<0||X<0||X>=N||Y>=N)continue;
            if(arr[Y][X]==21||arr[Y][X]==-1)
                row=true;
        }
         for(int i=2;i<4;i++){
            int Y=y+diy[i];
            int X=x+dix[i];
            if(Y<0||X<0||X>=N||Y>=N)continue;
            if(arr[Y][X]==21||arr[Y][X]==-1)
                col=true;
        }
        if(row&&col)arr[y][x]=-1;
    }
    public static void BFS(){
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[3]-b[3];
            }
        });
        pq.offer(new int[]{0,0,1,0});//y x m T
        visit=new boolean[N][N][2];
        visit[0][0][1]=true;
        
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            
            if(cur[0]==N-1&&cur[1]==N-1){
                ans=Math.min(ans,cur[3]);
                continue;
            }
           if(ans<=cur[3])continue;
            
            for(int i=0;i<4;i++){
                int Y=cur[0]+diy[i];
                int X=cur[1]+dix[i];
                if(Y<0||X<0||X>=N||Y>=N)continue; 
                if(arr[Y][X]==-1)continue; 
                if(visit[Y][X][cur[2]])continue;
                
                int left=cur[2];
                if(arr[Y][X]>=2){
                    if(arr[cur[0]][cur[1]]>=2)continue;
                    int T;
                    if(arr[Y][X]==21) {
                        if(left==0)continue;
                        T=BRIDGE(cur[3]+1,M);
                        left--;
                    }
                    else T=BRIDGE(cur[3]+1,arr[Y][X]);

                    pq.offer(new int[]{Y,X,left,T});
                }
                else pq.offer(new int[]{Y,X,left,cur[3]+1});
                
                visit[Y][X][left]=true;
            }
        }
        
    }
    public static int BRIDGE(int t,int n){
        if(t<=n)return n;
        int ret=t/n;
        if(t%n>0)ret++;
        return ret*n;
        
    }
}