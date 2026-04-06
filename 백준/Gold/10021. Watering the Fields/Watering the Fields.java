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
    
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        parent=new int[N];
        List<int[]> temp=new ArrayList<>();
        
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            temp.add(new int[]{a,b,i});
            parent[i]=i;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        for(int i=0;i<temp.size();i++){
            int[] p1=temp.get(i);
            for(int k=i+1;k<temp.size();k++){
                int[] p2=temp.get(k);
                int dist=(p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
                if(dist<M)continue;
                pq.add(new int[]{dist,p1[2],p2[2]});
            }
        }
     
        int ans=0;
        int cnt=1;
        while(!pq.isEmpty()){
            int[] L=pq.poll();
            int dist=L[0];
            int p1=find(L[1]);
            int p2=find(L[2]);

            if(p1!=p2){
                parent[p2]=p1;
                ans+=dist;
                cnt++;
            }
        }
        
        if(cnt!=N)System.out.println(-1);
        else System.out.println(ans);
        
    }
}