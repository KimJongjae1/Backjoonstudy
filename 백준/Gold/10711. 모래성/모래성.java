import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[][] arr;
    static int[][] copy;
     static List<Integer>[] list;
     static boolean[][] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int sum;
    static Queue<int[]> qu;
    static boolean flag;
    static int[] diy={-1,1,0,0,-1,1,-1,1};
    static int[] dix={0,0,-1,1,1,1,-1,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        arr=new int[N][M];
        copy=new int[N][M];
        qu=new LinkedList<>();
        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int k=0;k<M;k++){
                int a=str.charAt(k)-'0';
                if(a>=0&&a<=9){
                   arr[i][k]=copy[i][k]=a; 
                    if(arr[i][k]<9)
                   qu.offer(new int[]{i,k});
                }
            }
        }

        System.out.println(Wave());

    }
    public static int Wave(){
       
        int ret=0;
       while(true){
            int size=qu.size();
           flag=false;
           for(int k=0;k<size;k++){
               int[] cur=qu.poll();

               for(int i=0;i<8;i++){
                int y=cur[0]+diy[i];
                int x=cur[1]+dix[i];
                if(y<0||y>=N||x<0||x>=M)continue;
                if(arr[y][x]<=0||arr[y][x]==9)continue;
     
                if(IsDestroyed(y,x)){
                    qu.offer(new int[]{y,x});
                    arr[y][x]=-1;
                    flag=true;
                }
                
             }
               
           }
           if(!flag) break;
           ret++;
            for(int[] c:qu){
                arr[c[0]][c[1]]=0;
            }
           
       }
        return ret;
    }
    public static boolean IsDestroyed(int y,int x){
        
        int cnt=0;
        for(int i=0;i<8;i++){
            int Y=y+diy[i];
            int X=x+dix[i];
            if(Y<0||Y>=N||X<0||X>=M)continue;
            if(arr[Y][X]==0)cnt++;
        }
        if(cnt>=arr[y][x])return true;
        else return false;
    }

   
}