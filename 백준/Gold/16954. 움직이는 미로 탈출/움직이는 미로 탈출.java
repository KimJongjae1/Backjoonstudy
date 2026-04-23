
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static char[][] arr;
     static List<int[]>[] list;
     static boolean[][] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] diy={-1,1,0,0,-1,1,-1,1};
    static int[] dix={0,0,-1,1,1,1,-1,-1};
    static Queue<int[]> wall;
    static Queue<int[]> qu;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        //StringTokenizer st=new StringTokenizer(br.readLine());
        //N=Integer.parseInt(st.nextToken());
        arr=new char[8][8];
        wall=new LinkedList<>();
        idx=8;
       for(int i=0;i<8;i++){
           String str=br.readLine();
           for(int k=0;k<8;k++){
               arr[i][k]=str.charAt(k);
               if(arr[i][k]=='#'){
                   wall.offer(new int[]{i,k});
                   idx=Math.min(idx,i);
               }
           }
       }
        qu=new LinkedList<>();
        qu.offer(new int[]{7,0});
        ans=0;
        while(true){
            int Y=MOVE();
            movewall();
            idx++;
            
            if(qu.size()==0)
                break;
            
            if(idx>Y||wall.size()==0){
                ans=1;
                break;
            }

            
        }
        System.out.println(ans);
    }
    
    public static void movewall(){
        int s=wall.size();
        for(int i=0;i<s;i++){
            int[] w=wall.poll();

            arr[w[0]][w[1]]='.';
            w[0]++;
            if(w[0]==8)continue;
            wall.offer(w);
        }
        for(int[] w:wall)
            arr[w[0]][w[1]]='#';
    }
    
    public static int MOVE(){
        visit=new boolean[8][8];
        for(int[] h:qu) 
            visit[h[0]][h[1]]=true;
        int s=qu.size();
        int Y=7;
        
        for(int k=0;k<s;k++){
            int[] cur=qu.poll();
        
            if(arr[cur[0]][cur[1]]=='#')
                continue;
            
            for(int i=0;i<8;i++){
                int y=cur[0]+diy[i];
                int x=cur[1]+dix[i];
                if(y<0||y>=8||x<0||x>=8)continue;
                if(visit[y][x])continue;
                visit[y][x]=true;
                if(arr[y][x]=='#')continue;
                qu.offer(new int[]{y,x});
                Y=Math.min(Y,y);
                
            } 
            qu.offer(cur);
            Y=Math.min(Y,cur[0]);
        }

        return Y;
    }
}