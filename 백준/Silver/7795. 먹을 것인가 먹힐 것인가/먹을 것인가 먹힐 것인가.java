import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
   static  StringBuilder sb;
   static int[] arr;
   static int[] dp;
   static long[] sum;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[] visit;
   static List<Integer>[] list;
   static Set<int[]> set;  
   static Queue<Integer> qu;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
	        StringTokenizer st=new StringTokenizer(br.readLine());
	        N=Integer.parseInt(st.nextToken());
	        M=Integer.parseInt(st.nextToken());
	        ans=0;
	        int[] big=new int[N];
	        int[] small=new int[M];
	        st=new StringTokenizer(br.readLine());
	        for(int i=0;i<N;i++) {
	        	big[i]=Integer.parseInt(st.nextToken());
	        }
	        st=new StringTokenizer(br.readLine());
	        for(int i=0;i<M;i++) {
	        	small[i]=Integer.parseInt(st.nextToken());
	        }
	        Arrays.sort(small);
	        for(int i=0;i<N;i++) {
	        	int n=lowerbound(small,big[i]);
	        	ans+=n;

	        }
	        sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
   public static int lowerbound(int[] small,int T) {
	   int max=small.length;
	   int min=0;
	   while(min<max) {
		   int mid=(max+min)/2;
		   
		   if(small[mid]<T) {
			   min=mid+1;
		   }else {
			   max=mid;
		   }
	   }
	   return min;
   }
}