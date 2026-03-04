import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int T;
   static int idx;
   static int max;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<Integer> list;
   static TreeSet<Integer> set;  
   static TreeMap<Integer,Integer> map;
   static int[] parent;
   static int find(int x) {
	   if(parent[x]!=x)return parent[x]=find(parent[x]);
	   return x;
   }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
       
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a,int[] b) {
        		return a[2]-b[2];
        	}
        });
        parent=new int[N+1];
        for(int i=1;i<=N;i++) {
        	parent[i]=i;
        }
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            
            pq.offer(new int[] {a,b,c});
        }
        int max=0;
        while(!pq.isEmpty()) {
        	int[] cur=pq.poll();
        	
        	int a=find(cur[0]);
        	int b=find(cur[1]);
        	
        	if(a!=b) {
        		parent[b]=a;
        		ans+=cur[2];
        		max=Math.max(max, cur[2]);

        	}
        	
        }
        System.out.println(ans-max);
	   
   }
}