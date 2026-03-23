import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int K;
    static int s;
    static int R1;
    static int R2;
    static int C1;
    static int C2;
    static int[] dp;
     static int[] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int[] rangeY=new int[2];
    static int[] rangeX=new int[2];
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        s=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        R1=Integer.parseInt(st.nextToken());
        R2=Integer.parseInt(st.nextToken());
        C1=Integer.parseInt(st.nextToken());
        C2=Integer.parseInt(st.nextToken());
        rangeY[0]=rangeX[0]=(N-K)/2;
        rangeY[1]=rangeX[1]=(N-K)/2+K-1;
 
        if(s==0){
            System.out.println(0);
            return;
        }
        
        for(int i=R1;i<=R2;i++){
            for(int k=C1;k<=C2;k++){
                sb.append(divide(s,i,k));
            }
            sb.append("\n");
        }
   
        System.out.println(sb);
    }
    public static int divide(int S,int y,int x){
        if(S==0) return 0;

        int Y=y/N*N;
        int X=x/N*N;
        if(y<Y+rangeY[0]||y>Y+rangeY[1]||x<rangeX[0]+X||x>rangeX[1]+X) 
            return divide(S-1,y/N,x/N);
        else  return 1;

        
    }

}