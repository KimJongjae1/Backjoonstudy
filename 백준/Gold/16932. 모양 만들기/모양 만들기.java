import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[][] arr;
     static List<Integer> list;
     static boolean[][] visit;
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
        arr=new int[N][M];
        list=new ArrayList<>();
        list.add(0);
        idx=1;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<M;k++){
                arr[i][k]=Integer.parseInt(st.nextToken());
            }
        }
        
        visit=new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                if(arr[i][k]==0)continue;
                if(visit[i][k])continue;
                BFS(i,k);
                
            }
        }
        Set<Integer> temp=new HashSet<>();
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                if(arr[i][k]==1)continue;
                int t=1;
            
                temp.clear();
                for(int q=0;q<4;q++){
                    int y=i+diy[q];
                    int x=k+dix[q];
                    if(y<0||x<0||y>=N||x>=M)continue;
                    if(temp.contains(arr[y][x])) continue;
                    temp.add(arr[y][x]);
                    //System.out.println(s/M+" "+s%M+" "+arr[y][x]+" "+list.get(arr[y][x]));
                    t+=list.get(arr[y][x]);
                }
                ans=Math.max(t,ans);
            }
        }
        System.out.println(ans);
    }
    
    public static int BFS(int a,int b){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{a,b});
        visit[a][b]=true;
        int cnt=1;
        arr[a][b]=idx;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
            
              for(int q=0;q<4;q++){
                    int y=cur[0]+diy[q];
                    int x=cur[1]+dix[q];
                    if(y<0||x<0||y>=N||x>=M)continue;
                  if(arr[y][x]==0)continue;
                    if(visit[y][x])continue;
                    visit[y][x]=true;
                  arr[y][x]=idx;
                  cnt++;
                  qu.offer(new int[]{y,x});

            }
            
        }
        idx++;
        list.add(cnt);
        return cnt;
    }
}