import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static int T;
    static int K;
    static List<int[]> list;
   public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

       list=new ArrayList<>();
       for(int i=0;i<T;i++){
           st=new StringTokenizer(br.readLine());
           int x=Integer.parseInt(st.nextToken());
           int y=Integer.parseInt(st.nextToken());
           list.add(new int[]{x,y});
       }
        int max=0;
        int[] ans=new int[] {0,0};
       
       for(int i=0;i<T;i++){
           int[] p1=list.get(i);
           int x=p1[0];
           if(x+K>N)x=N-K;
           for(int k=0;k<T;k++){
        
               int[] p2=list.get(k);
                
               int y=p2[1];
                if(y-K<0)y=K;
               int cnt=check(p1[0],p2[1]);
            
               if(max<cnt){
                   max=cnt;
                   ans[0]=x;
                   ans[1]=y;
             
               }
           }
       }
       System.out.println(ans[0]+" "+ans[1]);
       System.out.println(max);
    }
    public static int check(int x,int y){
        int cnt=0;
  
        for(int i=0;i<T;i++){
            int[] p1=list.get(i);
            if(x<=p1[0]&&p1[0]<=x+K){
                if(y-K<=p1[1]&&p1[1]<=y){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}