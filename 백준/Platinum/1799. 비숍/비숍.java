import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int M;
    static int N;
    static int white;
    static int black;
    static int[] diy={-1,1,-1,1};
    static int[] dix={-1,-1,1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
        arr=new int[N][N];
        for(int i=0;i<N;i++){
             st=new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                int n=Integer.parseInt(st.nextToken());
                if(n==1)arr[i][k]=0;
                else arr[i][k]=-1;
            }
        }
        back(0,0,0,0);
        back(0,1,0,1);
      
        System.out.println(white+black);
    }
    public static void back(int y,int x,int cnt,int color){
        if(x>=N){
            if(color==0){
                if((y+1)%2==0) back(y+1,0,cnt,color);
                else back(y+1,1,cnt,color);
            }else{
                if((y+1)%2==1) back(y+1,0,cnt,color);
                else back(y+1,1,cnt,color);
            }
            return;
        }
       if(y>=N){
            if(color==0) white=Math.max(white,cnt);
            else black=Math.max(black,cnt);
           return;
        }
        
        if(arr[y][x]==0){
            beashop(y,x,1);
            back(y,x+2,cnt+1,color);
            beashop(y,x,-1);
           
        }
         back(y,x+2,cnt,color);
    }
    public static void beashop(int y,int x,int n){
        arr[y][x]+=n;
          for(int i=0;i<4;i++){
              int Y=y+diy[i];
              int X=x+dix[i];
              while(Y<N&&X<N&&X>=0&&Y>=0){
                  if(arr[Y][X]>=0)arr[Y][X]+=n;
                  
                  Y+=diy[i];
                  X+=dix[i];
  
              }
          }
    
    }
}