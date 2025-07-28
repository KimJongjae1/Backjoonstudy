import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long[][] cost;
    static List<int[]>[] list;
    static int[] oil;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt((st.nextToken()));
        st=new StringTokenizer(br.readLine());
        list=new ArrayList[N+1];
        oil=new int[N+1];
        for(int i=1;i<=N;i++){
            oil[i]=Integer.parseInt(st.nextToken());
            list[i]=new ArrayList<>();

        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[s].add(new int[]{e,c});
            list[e].add(new int[]{s,c});
        }
        dij();
        long ret=Long.MAX_VALUE;
    for(int i=1;i<=2500;i++){
        ret=Math.min(ret,cost[N][i]);
    }
        System.out.println(ret);

    }
    public static void dij(){
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>(){
            @Override
            public int compare(long[] a, long[] b){
                 if(a[1]!=b[1]) return Long.compare(a[1],b[1]);
                 else if(a[2]!=b[2]) return Long.compare(a[2],b[2]);
                 else return Long.compare(a[0],b[0]);
            }
        });
        pq.offer(new long[]{1,0,oil[1]});
        cost=new long[N+1][2501];
        for(int i=1;i<=N;i++) {
            Arrays.fill(cost[i],Long.MAX_VALUE);
        }
        cost[1][oil[1]]=0;
        while(!pq.isEmpty()){
            long[] now=pq.poll();
            int cur=(int)now[0];
            long c=now[1];

            if(cost[cur][(int)now[2]]<c) continue;

            for(int[] next:list[cur]){

                if(cost[next[0]][(int)now[2]]>c+now[2]*next[1]){
                    cost[next[0]][(int)now[2]]=c+now[2]*next[1];


                    if(now[2]<oil[next[0]])
                    pq.offer(new long[]{next[0],cost[next[0]][(int)now[2]],now[2]});
                    else  pq.offer(new long[]{next[0],cost[next[0]][(int)now[2]],oil[next[0]]});
                }
            }
        }

    }
}
