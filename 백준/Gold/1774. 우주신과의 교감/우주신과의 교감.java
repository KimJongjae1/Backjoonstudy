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
        parent=new int[N+1];
        List<long[]> temp=new ArrayList<>();
        
        for(int i=1;i<=N;i++){
            parent[i]=i;
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            temp.add(new long[]{y,x,i});
        }
        
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>(){
            @Override
            public int compare(long[] a,long[] b){
                return Long.compare(a[2],b[2]);
            }
        });
        
        for(int i=0;i<N;i++){
            long[] p1=temp.get(i);
            for(int k=i+1;k<N;k++){
                long[] p2=temp.get(k);

                long dist=(p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
                pq.offer(new long[]{p1[2],p2[2],dist});
            }
        }
        int cnt=0;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int A=find(a);
            int B=find(b);
            if(A==B)continue;
            parent[B]=A;
            cnt++;

        }

        double ans=0;
        while(!pq.isEmpty()){
            long[] line=pq.poll();

            int A=find((int)line[0]);
            int B=find((int)line[1]);
            if(A==B)continue;

            parent[B]=A;
            ans+=Math.sqrt(line[2]);
            cnt++;
            if(cnt==N-1)break;
  
        }

       System.out.printf("%.2f",ans);
    }
}