import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[] arr;
     static List<int[]> list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
     static int[] parent;
     public static int find(int x){
         if(parent[x]==x)return x;
         return parent[x]=find(parent[x]);
     }
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
         int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
             StringTokenizer st=new StringTokenizer(br.readLine());
             N=Integer.parseInt(st.nextToken());
             list=new ArrayList<>();
            parent=new int[N];
             for(int i=0;i<N;i++){
                  st=new StringTokenizer(br.readLine());
                 int x=Integer.parseInt(st.nextToken());
                 int y=Integer.parseInt(st.nextToken());
                 int R=Integer.parseInt(st.nextToken());
                 list.add(new int[]{y,x,R});
                 parent[i]=i;
             }

             for(int i=0;i<list.size();i++){
                 int[] cur=list.get(i);
                 for(int k=i+1;k<list.size();k++){
                     int[] next=list.get(k);
                     int a=cur[0]-next[0];
                     int b=cur[1]-next[1];
                      int range=a*a+b*b;
                       int dist=next[2]+cur[2];
                     if(range>dist*dist)continue;
                     
                      parent[find(i)]=find(k);
                 }
             }
            set=new HashSet<>();
            for(int i=0;i<N;i++){
                set.add(find(parent[i]));
              
            }
            sb.append(set.size()+"\n");
        }
        System.out.println(sb);
    }
}