import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static char[][] arr;
    static int N;
    static int M;
    static int[] diy={0,-1,0,1};
    static int[] dix={-1,0,1,0};
    static StringBuilder sb;
    static Queue<List<Integer>> q=new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
         sb=new StringBuilder();
         N=Integer.parseInt(st.nextToken());
         M=Integer.parseInt(st.nextToken());
         arr=new char[N][M];
         
           for(int i=0;i<N;i++){
               String str=br.readLine();
               for(int k=0;k<M;k++){
                   arr[i][k]=str.charAt(k);
               }
           }
         
            int k=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
           int[] order=new int[k];
            for(int i=0;i<k;i++){
                order[i]=Integer.parseInt(st.nextToken());
            }
            move(order,k);
           
        for(int i=0;i<N;i++){
            for(int q=0;q<M;q++){
                sb.append(arr[i][q]);
            }sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void move(int[] order,int k){

        for(int i=0;i<k;i++){
            int s=throwing(N-order[i],i%2==0?true:false);
            if(s==-1)continue;
     
             boolean[][] visit=new boolean[N][M];
            Queue<int[]> qu=new LinkedList<>();
            floor(visit,qu);

            for(int q=0;q<4;q++){
                 int Y=s/M+diy[q];
                 int X=s%M+dix[q];
                if(Y<0||Y>=N||X<0||X>=M)continue;
                if(visit[Y][X])continue;
                group(visit,Y,X);
            }

            down();
        }
        
    }
    public static int throwing(int n,boolean left){
     int s=-1;
        if(left){
            for(int i=0;i<M;i++){
                if(arr[n][i]=='x'){
                    arr[n][i]='.';
                      s=n*M+i;
                        break;
                }
            }
        }else{
            for(int i=M-1;i>=0;i--){
                if(arr[n][i]=='x'){
                    arr[n][i]='.';
                        s=n*M+i;
                        break;
                }
            }
        }
  
        return s;
    }
    public static void floor(boolean[][] visit,Queue<int[]> qu){
        for(int i=0;i<M;i++){
                if(arr[N-1][i]=='x'){
                    qu.offer(new int[]{N-1,i});
                    visit[N-1][i]=true;
                }
          }
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            for(int i=0;i<4;i++){
                int Y=cur[0]+diy[i];
                int X=cur[1]+dix[i];
                if(Y<0||Y>=N||X<0||X>=M)continue;
                if(visit[Y][X])continue;
                if(arr[Y][X]=='.')continue;
                visit[Y][X]=true;
                qu.offer(new int[]{Y,X});
            }
        }
         
    }
    public static void group(boolean[][] visit,int y,int x){
        if(arr[y][x]=='.')return;
        List<Integer> list=new ArrayList<>();
        
        arr[y][x]='.';
        list.add(y*M+x);
        
        visit[y][x]=true;
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{y,x});
        
          while(!qu.isEmpty()){
            int[] cur=qu.poll();

            for(int i=0;i<4;i++){
                int Y=cur[0]+diy[i];
                int X=cur[1]+dix[i];
                if(Y<0||Y>=N||X<0||X>=M)continue;
                if(visit[Y][X])continue;
                if(arr[Y][X]=='.')continue;
                visit[Y][X]=true;
                arr[Y][X]='.';
                list.add(Y*M+X);
                qu.offer(new int[]{Y,X});
            
            }
        }
        q.offer(list);
        
    }
    public static void down(){
       
        while(!q.isEmpty()){
            List<Integer> list=q.poll();
            List<Integer> next=new ArrayList<>();
            boolean goNext=true;
            for(int d:list){
                int y=d/M;
                int x=d%M;
                y++;
                if(y>=N||arr[y][x]=='x'){
                    goNext=false;
                    break;
                }
                next.add(y*M+x);
            }
            if(!goNext){
                for(int d:list){
                    arr[d/M][d%M]='x';
                }
            }else{
                q.offer(next);
            }
            
        }

        
    }
}