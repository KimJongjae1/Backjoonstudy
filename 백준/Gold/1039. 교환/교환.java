
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[] arr;
     static List<int[]>[] list;
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
        int n=N;
        idx=0;
        while(n>0){
            idx++;
            n/=10;
        }        
        if(idx<=1){
            System.out.println(-1);
            return;
        }
        arr=new int[idx];
        visit=new boolean[M+1][1000001];
        for(int i=idx-1;i>=0;i--){           
            arr[i]=N%10;
            N/=10;
        }

        COMB(0);
        if(ans==0)System.out.println(-1);
        else System.out.println(ans);
        
    }
    public static void COMB(int level){
        if(level==M){
            if(arr[0]!=0)
            ans=Math.max(ans,NUM());
      
            return;
        }

        for(int i=0;i<idx;i++){
            for(int k=i+1;k<idx;k++){
                change(i,k);
                int n=NUM();
                if(!visit[level+1][n]&&arr[0]!=0){
                    visit[level+1][n]=true;
                    COMB(level+1);
                }
                change(i,k);
            }
        }
    }
    public static int NUM(){
        int n=0;
        for(int i=0;i<idx;i++){
            n=n*10+arr[i];
        }
        return n;
    }
    public static void change(int i,int k){
        int temp=arr[k];
        arr[k]=arr[i];
        arr[i]=temp;
    }
    
}