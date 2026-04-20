
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static char[][] arr;
     static List<int[]> list;
     static boolean[][][] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] diy={-1,1,0,0,-1,1,-1,1};
    static int[] dix={0,0,-1,1,1,1,-1,-1};
    static int cnt;
    static int[] se;
    static int[] status;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        arr=new char[N][N];
        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int k=0;k<N;k++){
                arr[i][k]=str.charAt(k);
            }
        }

        se=new int[2];//시작점과 끝
        status=new int[2];
        //세로면 status 값이 0 가로면 1
       for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                if(arr[i][k]=='B'){
                    getBE(i,k,'B');
                }
                else if(arr[i][k]=='E'){
                     getBE(i,k,'E');
                }
            }
        }
        move();
        
        
    }
    public static void getBE(int i,int k,char a){
         cnt=0;
        boolean row=false;
          for(int q=0;q<4;q++){
                int y=i+diy[q];
                int x=k+dix[q];
                if(y<0||y>=N||x<0||x>=N)continue;
                if(arr[y][x]==a){
                   if(q==0)row=true;//세로로 시작
                   cnt++;
                }
          }
        int n=0;
        if(a=='E')n=1;
            if(cnt==2){
                se[n]=i*N+k;
                if(!row)status[n]=1;
            }
    }

    public static void move(){
        Queue<int[]> qu=new LinkedList<>();
        visit=new boolean[N][N][2];  //세로면 3번째 값이 0 가로면 1
        for(int i=0;i<N;i++){
            visit[0][i][0]=true;
            visit[N-1][i][0]=true;
            visit[i][0][1]=true;
            visit[i][N-1][1]=true;
        }
        qu.offer(new int[]{se[0]/N,se[0]%N,status[0],0});
        visit[se[0]/N][se[0]%N][status[0]]=true;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            if(cur[0]==se[1]/N&&cur[1]==se[1]%N&&status[1]==cur[2]){
                System.out.println(cur[3]);
                return;
            }

            for(int i=0;i<4;i++){
                int y=cur[0]+diy[i];
                int x=cur[1]+dix[i];
                if(y<0||y>=N||x<0||x>=N)continue;
                if(arr[y][x]=='1')continue;
                if(visit[y][x][cur[2]])continue;
                if(!INRANGE(y,x,cur[2]))continue;
                visit[y][x][cur[2]]=true;
                qu.offer(new int[]{y,x,cur[2],cur[3]+1});
            }
            int NewStat=0;
            if(cur[2]==0)NewStat=1;
            if(TURN(cur[0],cur[1])){
                if(!visit[cur[0]][cur[1]][NewStat]){
                    visit[cur[0]][cur[1]][NewStat]=true;
                    qu.offer(new int[]{cur[0],cur[1],NewStat,cur[3]+1});
                }
            }
        }
        System.out.println(0);
    }
    public static boolean INRANGE(int y,int x,int stat){

        if(stat==0){
            for(int i=0;i<2;i++){
                int Y=y+diy[i];
                int X=x+dix[i];
                if(arr[Y][X]=='1')return false;
            }
        }else{
              for(int i=2;i<4;i++){
                int Y=y+diy[i];
                int X=x+dix[i];
                if(arr[Y][X]=='1')return false;
            }
        }
        return true;
    }
    public static boolean TURN(int c1,int c2){
        for(int i=0;i<8;i++){
               int y=c1+diy[i];
               int x=c2+dix[i]; 
               if(y<0||y>=N||x<0||x>=N) return false;
               if(arr[y][x]=='1')return false;
            }
        return true;
    }
}