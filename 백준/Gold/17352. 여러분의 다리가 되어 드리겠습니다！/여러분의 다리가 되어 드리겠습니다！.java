import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int[][] dp;
     static int[] arr;
     static int ans;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int[] parent;
     public static int find(int x) {
    	 if(parent[x]!=x)return parent[x]=find(parent[x]);
    	 return x;
     }
     public static void  union(int a,int b) {
    	 int A=find(a);
    	 int B=find(b);
    	 
    	 if(A!=B){
    		 parent[B]=A;
    	 }
     }
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
         StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         parent=new int[N+1];
         for(int i=1;i<=N;i++)parent[i]=i;
         for(int i=1;i<=N-2;i++) {
        	 st=new StringTokenizer(br.readLine());
        	 int a=Integer.parseInt(st.nextToken());
        	 int b=Integer.parseInt(st.nextToken());
        	 
        	 union(a,b);
         }
       
         int start=1;
         for(int i=1;i<=N;i++) {
        	 if(find(start)!=find(i)) {
        		 sb.append(start+" "+i);
        		 break;
        	 }
         }
         System.out.println(sb);
    }
}