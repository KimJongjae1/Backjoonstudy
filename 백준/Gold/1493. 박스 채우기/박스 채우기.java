import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int K;
    static int[][] dp;
     static int[] arr;
     static List<int[]> list;
     static boolean[] visit;
     static int idx;
    static int max;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static boolean flag;
     static TreeMap<Integer,Integer> map;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();

         StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         M=Integer.parseInt(st.nextToken());
         K=Integer.parseInt(st.nextToken());

        int n=Integer.parseInt(br.readLine());
 
        arr=new int[21];
        max=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a]=b;
            max=Math.max(max,a);
        }
        ans=place(N,M,K);
        System.out.println(ans);
    }
    public static int place(int y,int x,int z){
  
               if (y == 0 || x == 0 || z == 0) return 0;
        
            int min = Math.min(y, Math.min(x, z));
            int t = (int)(Math.log(min) / Math.log(2));
            if(flag)return -1;
            for (int i = t; i >= 0; i--) {
                if (arr[i] == 0) continue;
        
                int dist = 1 << i;
        
                arr[i]--;
                int a = place(y - dist, x, z);
                if (a < 0){
                    flag=true;
                   return -1;
                } 
        
                int b = place(dist, x - dist, z);
                if (b < 0) {
                   flag=true;
                   return -1;
                } 
                
        
                 int c = place(dist, dist, z - dist);
                if (c < 0) {
                    flag=true;
                   return -1;
                } 
                if(flag)return -1;
                return a + b + c + 1;
            }
        
            return -1;
        }
 
}