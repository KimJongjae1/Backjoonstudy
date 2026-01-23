import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


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
   static int[] judge;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[][][] visit;
   static List<int[]> list;
   static TreeSet<Integer> set;  
   static Map<Integer,Integer>[] map;
   static class meat implements Comparable<meat>{
	   int w;
	   int p;
	   meat(int w,int p){
		   this.w=w;
		   this.p=p;
	   }
	   public int compareTo(meat a) {
		   if(a.p!=this.p)return this.p-a.p;
		   else return a.w-this.w;
	   }
   }
   static meat[] m;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer .parseInt(st.nextToken());
		M=Integer .parseInt(st.nextToken());
		
		m=new meat[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int p=Integer.parseInt(st.nextToken());
			m[i]=new meat(w,p);
		}
		Arrays.sort(m);
		int sumW=0;
		int max=0;
		int sumP=0;
		long cost=Long.MAX_VALUE;
		for(int i=0;i<N;i++) {
			if(max<m[i].p) {
				max=m[i].p;
				sumP=m[i].p;
			}else {
				sumP+=m[i].p;
			}
			sumW+=m[i].w;
			if(sumW>=M) {
				cost=Math.min(cost, sumP);
			}
		}
		if(cost==Long.MAX_VALUE)System.out.println(-1);
		else System.out.println(cost);
		
    }
}