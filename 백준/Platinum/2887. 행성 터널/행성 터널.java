import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        static int N;
         static List<int[]> list;
         static  StringBuilder sb;
     static int[] parent;
      static int find(int x){
         if(parent[x]==x)return x;
         return parent[x]=find(parent[x]);
     }
      public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 

        list=new ArrayList<>();
          parent=new int[N];
         for(int i=0;i<N;i++){
             parent[i]=i;
             st=new StringTokenizer(br.readLine());
             int a=Integer.parseInt(st.nextToken());
             int b=Integer.parseInt(st.nextToken());
             int c=Integer.parseInt(st.nextToken());
             list.add(new int[]{a,b,c,i});
         }
     

         PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
             @Override
             public int compare(int[] a,int[] b){
                 return a[0]-b[0];
             }
         });
          sorting(pq,0);
          sorting(pq,1);
          sorting(pq,2);

          int cnt=1;
         int min=0;
          while(cnt<N){
              int[] dist=pq.poll();
                int p1=find(dist[1]);
                int p2=find(dist[2]);

              if(p1!=p2){
                  parent[p2]=p1;
                  cnt++;
                  min+=dist[0];
              }
          }   
         System.out.println(min);
    }
    public static void sorting(PriorityQueue<int[]> pq,int n){
          Collections.sort(list,new Comparator<int[]>(){
            @Override
             public int compare(int[] a,int [] b){
                 return a[n]-b[n];
             }
         });
             
          for(int i=0;i<N-1;i++){
             int[] p1=list.get(i);
             int[] p2=list.get(i+1);
             int len=Math.min(Math.min(Math.abs(p1[0]-p2[0]),Math.abs(p1[1]-p2[1])),Math.abs(p1[2]-p2[2]));
             pq.offer(new int[]{len,p1[3],p2[3]});
         }    
        
    }
}