import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static long max;
   static  StringBuilder sb;
   static int[] arr;
   static int[] dp;
   static long[]sum;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[][][] visit;
   static List<int[]> list;
   static Set<Integer> set;  
   static Map<Integer,Integer>[] map;
   static int L;
   static int P;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer .parseInt(st.nextToken());
		 list=new ArrayList<>();
		 for(int i=0;i<N;i++) {
			 st=new StringTokenizer(br.readLine());
			 int a=Integer.parseInt(st.nextToken());
			 int b=Integer.parseInt(st.nextToken());
			 list.add(new int[] {a,b});
		 }
		
		 st=new StringTokenizer(br.readLine());
		  L=Integer.parseInt(st.nextToken());
		  P=Integer.parseInt(st.nextToken());
		  
		 Collections.sort(list,new Comparator<int[]>() {
			 @Override
			 public int compare(int[] a,int[] b) {
				 return a[0]-b[0];
			 }
		 });
		 
		  PriorityQueue<Integer> qu=new PriorityQueue<>(Collections.reverseOrder()); 
		 for(int i=0;i<list.size();i++) {
			 int[] cur=list.get(i);
			 if(P<cur[0]) {
				 while(P<cur[0]) {
					 if(qu.isEmpty()) {
						 System.out.println(-1);
						 return;
					 }
					 P+=qu.poll();
					 ans++;
				 }
			 }
			 qu.offer(cur[1]);
		 }

		 if(L<=P) {
			 System.out.println(ans);
		 }else {
			 while(!qu.isEmpty()&&P<L) {
				 P+=qu.poll();
				 ans++;
			 }
			 if(P<L)System.out.println(-1);
			 else System.out.println(ans);
		 }
    }
    
    
    
}