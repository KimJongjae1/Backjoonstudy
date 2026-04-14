
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[][] arr;
     static List<Integer>[] list;
     static boolean[] visit;
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
        arr=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                arr[i][k]=Integer.parseInt(st.nextToken());
            }
        }

        BACK(0);
        System.out.println(ans);
    }
    public static void BACK(int level){
        if(level==5){
            for(int i=0;i<N;i++){
                for(int k=0;k<N;k++){
                    ans=Math.max(ans,arr[i][k]);
                }
            }
            return;
        }
        
        int[][] copy=new int[N][N];
        COPYARR(copy);

        Left();
        BACK(level+1);
        BACKARR(copy);
        
        Right();
        BACK(level+1);
        BACKARR(copy);
        
        UP();
        BACK(level+1);
        BACKARR(copy);
        
        DOWN();
        BACK(level+1);
        BACKARR(copy);
        
    }
    public static void COPYARR(int[][] copy){
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                copy[i][k]=arr[i][k];
            }
        }
    }
    public static void BACKARR(int[][] copy){
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                arr[i][k]=copy[i][k];
            }
        }
    }
    public static void Left(){
        
        for(int i=0;i<N;i++){
            idx=0;    
            boolean PLUS=false;
            for(int k=1;k<N;k++){
                if(arr[i][k]>0){
                    if(arr[i][idx]==arr[i][k]&&!PLUS){
                        arr[i][idx]*=2;
                        arr[i][k]=0;
                        PLUS=true;
                    }else{
                        if(arr[i][idx]!=0) idx++;
                        arr[i][idx]=arr[i][k];
                        if(idx!=k) arr[i][k]=0;
                        PLUS=false;
                    }
                }
            }
        }
        
    }
   public static void Right(){
        
        for(int i=0;i<N;i++){
            idx=N-1;    
            boolean PLUS=false;
            for(int k=N-2;k>=0;k--){
                if(arr[i][k]>0){
                    if(arr[i][idx]==arr[i][k]&&!PLUS){
                        arr[i][idx]*=2;
                        arr[i][k]=0;
                        PLUS=true;
                    }else{
                        PLUS=false;
                         if(arr[i][idx]!=0) idx--;
                        arr[i][idx]=arr[i][k];
                        if(idx!=k) arr[i][k]=0;
                    }
                }
            }
        }
        
    }

    public static void UP(){
        
         for(int i=0;i<N;i++){
            idx=0;    
            boolean PLUS=false;
            for(int k=1;k<N;k++){
                if(arr[k][i]>0){
                    if(arr[idx][i]==arr[k][i]&&!PLUS){
                        arr[idx][i]*=2;
                        arr[k][i]=0;
                        PLUS=true;
                    }
                    else{
                        PLUS=false;
                        if(arr[idx][i]!=0)idx++;
                        arr[idx][i]=arr[k][i];
                        if(idx!=k) arr[k][i]=0;
                    }
                }
            }
        }
    }

     public static void DOWN(){
        
         for(int i=0;i<N;i++){
            idx=N-1;    
            boolean PLUS=false;
            for(int k=N-2;k>=0;k--){
                if(arr[k][i]>0){
                    if(arr[idx][i]==arr[k][i]&&!PLUS){
                        arr[idx][i]*=2;
                        arr[k][i]=0;
                        PLUS=true;
                    }
                    else{
                        PLUS=false;
                         if(arr[idx][i]!=0)idx--;
                        arr[idx][i]=arr[k][i];
                        if(idx!=k) arr[k][i]=0;
                    }
                }
            }
        }
    }
}