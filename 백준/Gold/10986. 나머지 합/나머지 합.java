import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
   static int idxB;
   static  StringBuilder sb;
   static int[] arr;
   static int[] dp;
   static long[]sum;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[][] visit;
   static List<Integer> list;
   static Set<Integer>[] set;  
   static Map<Integer,Integer>[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer.parseInt(st.nextToken());
		 M=Integer.parseInt(st.nextToken());
		
		 sum=new long[N];
		 long[] left=new long[M];
		 st=new StringTokenizer(br.readLine());
		 sum[0]=Integer.parseInt(st.nextToken());
		 left[(int)(sum[0]%M)]++;
		 for(int i=1;i<N;i++) {
			 int n=Integer.parseInt(st.nextToken());
			 
			 sum[i]=sum[i-1]+n;
			 left[(int)(sum[i]%M)]++;
		 }
		 ans=left[0];
		 for(int i=0;i<M;i++) {
			 ans+=left[i]*(left[i]-1)/2;
		 }
		 System.out.println(ans);
		 
    }
}