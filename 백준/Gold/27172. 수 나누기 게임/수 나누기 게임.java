import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[][] dp;
     static int[] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    static int max;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
         StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        int[] a=new int[N];
        Map<Integer,Integer> index=new HashMap<>();
        max=0;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            max=Math.max(arr[i],max);
             index.put(arr[i],i);
        }
        int[] score=new int[N];
        
       for(int i=0;i<N;i++){
          
           for(int k=arr[i]+arr[i];k<=max;k+=arr[i]){
               if(index.containsKey(k)){
                   score[i]++;
                   score[index.get(k)]--;
               }
           }
           
           
       }
           for(int r=0;r<N;r++){
                sb.append(score[r]+" ");
            }
        System.out.println(sb);
    }
    
}