import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] parent;
    public static int find(int x){
        if(parent[x]==x) return x;
        else return parent[x]=find(parent[x]);
    }
    public static void union(int a,int b){
        int A=find(a);
        int B=find(b);

        parent[B]=A;
    }
    public static void main(String[] args) throws IOException{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

      int N=Integer.parseInt(br.readLine());
      int[][] arr=new int[N][N];
      parent=new int[N];
      
        int sum=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
            
        });
        
      for(int i=0;i<N;i++){
          String str=br.readLine();
          for(int k=0;k<N;k++){
              char a=str.charAt(k);
              if(a=='0'){
                  arr[i][k]=0;
                  continue;
              }
              else if(a<='Z'){
                  arr[i][k]=a-'A'+27;
              }else{
                   arr[i][k]=a-'a'+1;
              }
             pq.offer(new int[]{i*N+k,arr[i][k]});
              sum+=arr[i][k];
          }
      }
        for(int i=0;i<N;i++){
            parent[i]=i;
        }
       int ans=0;
        int cnt=0;
    while(!pq.isEmpty()){
        int[] line=pq.poll();
        int a=find(line[0]/N);
        int b=find(line[0]%N);
        
         if(a!=b){
             parent[b]=a;
             ans+=line[1];
             cnt++;
         }
     }

        if(cnt<N-1)System.out.println(-1);
        else System.out.println(sum-ans);
    }
   
}