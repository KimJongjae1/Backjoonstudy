import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<int[]>[] list;
    static boolean[][] visit;
    static int ans=0;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        list=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }
        int max=0;
        int min=0;
         for(int i=0;i<P;i++){
        	 st=new StringTokenizer(br.readLine()) ;
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            max=Math.max(max,c);
     
            list[s].add(new int[]{e,c});
            list[e].add(new int[]{s,c});
         }
         int m=max;
         while(min<max){
             int mid=(min+max)/2;

             if(dij(mid,M)) {
            	 max=mid;
             }else min=mid+1;
         }
        if(m==max&&dist[N]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }


    public static boolean dij(int mid,int M){
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a,int[] b) {
        		return a[1]-b[1];
        	}
        });
        pq.offer(new int[]{1,0});
         dist=new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            int[] now=pq.poll();

           if(now[1]>dist[now[0]])continue;

            for(int[] next:list[now[0]]){
            	int cnt=now[1];
            	
            	if(next[1]>mid) cnt++;
            	
                if(dist[next[0]]>cnt){
                	dist[next[0]]=cnt;
                    pq.offer(new int[]{next[0],cnt});
                }
            }

        }
        return dist[N]<=M;
    }
}