
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static char[][] arr;
     static List<int[]>[] list;
     static boolean[][][][] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans=11;
    static int RED;
    static int BLUE;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new char[N][M];

        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int k=0;k<M;k++){
                arr[i][k]=str.charAt(k);
                if(arr[i][k]=='R'){
                    RED=i*M+k;
                    arr[i][k]='.';
                }
                else if(arr[i][k]=='B'){
                    BLUE=i*M+k;
                     arr[i][k]='.';
                }
            }
        }
        BFS();
        if(ans==11)System.out.println(-1);
        else System.out.println(ans);
    }
    public static void BFS(){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{RED,BLUE,0});
        visit=new boolean[N][M][N][M];
        visit[RED/M][RED%M][BLUE/M][BLUE%M]=true;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            if(cur[2]>=ans)continue;
            if(arr[cur[1]/M][cur[1]%M]=='O')continue;
            if(arr[cur[0]/M][cur[0]%M]=='O'){
                ans=Math.min(ans,cur[2]);
                continue;
            }
            if(cur[2]>=10)continue;
            
            for(int i=0;i<4;i++){
                int ry=cur[0]/M;
                int rx=cur[0]%M;
                int by=cur[1]/M;
                int bx=cur[1]%M;

                boolean R=false;
                boolean B=false;
                while(true){

                   if(!R) {
                        if(arr[ry+diy[i]][rx+dix[i]]=='O'){
                            R=true;
                            ry+=diy[i];rx+=dix[i];
                        }
                        else if(ry+diy[i]==by&&rx+dix[i]==bx){
                            if(B)R=true;
                        }
                        else if(arr[ry+diy[i]][rx+dix[i]]!='.') R=true;
                        
                        else { ry+=diy[i];rx+=dix[i];}
                   }

                   if(!B) {
                        if(arr[by+diy[i]][bx+dix[i]]=='O'){
                            B=true;
                            by+=diy[i];bx+=dix[i];
                        }
                         else if(by+diy[i]==ry&&bx+dix[i]==rx){
                            if(R)B=true;
                        }    
                        else if(arr[by+diy[i]][bx+dix[i]]!='.') B=true;
                        else { by+=diy[i];bx+=dix[i];}
                   } 

                    if(R&&B)break;
                }
                if(visit[ry][rx][by][bx])continue;
                visit[ry][rx][by][bx]=true;
                
                qu.offer(new int[]{ry*M+rx,by*M+bx,cur[2]+1});
            }
        }
    }  
 
}