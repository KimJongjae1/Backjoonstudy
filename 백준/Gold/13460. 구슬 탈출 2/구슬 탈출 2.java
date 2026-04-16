
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static char[][] arr;
     static List<int[]>[] list;
     static boolean[] visit;
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
                if(arr[i][k]=='R')RED=i*M+k;
                else if(arr[i][k]=='B')BLUE=i*M+k;
            }
        }
        BACK(0);
        if(ans==11)System.out.println(-1);
        else System.out.println(ans+1);
    }
    public static void Print(){
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                System.out.print(arr[i][k]);
            }System.out.println();
        }System.out.println();
    }
    
    public static void BACK(int level){
 
        if(level==10) {return;}
        if(level>=ans)return;
        
        char[][] a=new char[N][M];
        int r=RED;int b=BLUE;
        COPYARR(a);
        Boolean B=false;
        Boolean R=false;
        if(RED%M<BLUE%M){//right
           R=RightOrLeft(RED,'R',-1); B=RightOrLeft(BLUE,'B',-1); 
        }else {
           B=RightOrLeft(BLUE,'B',-1); R=RightOrLeft(RED,'R',-1);
        }
        if(R&&!B) {ans=Math.min(ans,level); return; }
        if(!R&&!B)BACK(level+1);
        RETURNARR(a);
        RED=r;BLUE=b;
    /////////////////////////////    
        if(RED%M<BLUE%M){
          B=RightOrLeft(BLUE,'B',1); R=RightOrLeft(RED,'R',1); 
        }else {
            R=RightOrLeft(RED,'R',1); B=RightOrLeft(BLUE,'B',1);
        }
        if(R&&!B) {ans=Math.min(ans,level); return;}
        if(!R&&!B)BACK(level+1);
        RETURNARR(a);
        RED=r;BLUE=b;
/////////////////////////////////
        if(RED/M<BLUE/M){
           R=UpOrDown(RED,'R',-1); B=UpOrDown(BLUE,'B',-1);  
        }else {
            B=UpOrDown(BLUE,'B',-1);  R=UpOrDown(RED,'R',-1);
        }
        if(R&&!B) { ans=Math.min(ans,level);return; }
        if(!R&&!B)BACK(level+1);
        RETURNARR(a);
        RED=r;BLUE=b;
////////////////////////////
        if(RED/M<BLUE/M){
            B=UpOrDown(BLUE,'B',1);R=UpOrDown(RED,'R',1); 
        }else {
            R=UpOrDown(RED,'R',1); B=UpOrDown(BLUE,'B',1);  
        }
        if(R&&!B) {ans=Math.min(ans,level); return;}
        if(!R&&!B)BACK(level+1);
        RETURNARR(a);
        RED=r;BLUE=b;
    }
    public static void RETURNARR(char[][] a){
       
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                arr[i][k]=a[i][k];
            }
        }
        
    }
     public static void COPYARR(char[][] a){
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                a[i][k]=arr[i][k];
            }
        }
    }
    public static boolean RightOrLeft(int n,char type,int dir){
   
        int y=n/M;
        int x=n%M;
        arr[y][x]='.';
        while(true){
            if(arr[y][x+dir]=='O') return true;
            if(arr[y][x+dir]!='.') break;
           
            x+=dir;            
        }
        if(type=='B'){
            arr[y][x]='B';
            BLUE=y*M+x;
        }
        else{ 
            arr[y][x]='R';
            RED=y*M+x;
        }
        return false;
    }
  
    public static boolean UpOrDown(int n,char type,int dir){
       
        int y=n/M;
        int x=n%M;
        arr[y][x]='.';
        while(true){
            if(arr[y+dir][x]=='O') return true;
            if(arr[y+dir][x]!='.') break;
            y+=dir;            
        }
        if(type=='B'){
            arr[y][x]='B';
            BLUE=y*M+x;
        }
        else{ 
            arr[y][x]='R';
            RED=y*M+x;
        }
        return false;
    }
}