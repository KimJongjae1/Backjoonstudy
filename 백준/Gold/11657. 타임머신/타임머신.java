import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
   static long[] arr;
   static String[] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static int[] visit;
   static List<int[]>[] list;
   static TreeSet<Integer> set;  
   static Map<Integer,Integer>[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer .parseInt(st.nextToken());
		M=Integer .parseInt(st.nextToken());
		
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
	
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			int Cost=Integer.parseInt(st.nextToken());
			list[A].add(new int[] {B,Cost});
		}
		if(BellMan_Ford()) {
			sb.append(-1);
		}else {
			for(int i=2;i<=N;i++) {
				if(arr[i]==Long.MAX_VALUE)sb.append(-1+"\n");
				else sb.append(arr[i]+"\n");
			}
		}
		System.out.println(sb);
		
    }
    public static boolean BellMan_Ford() {
    	arr=new long[N+1];
    	Arrays.fill(arr, Long.MAX_VALUE);
    	arr[1]=0;
    	boolean update=false;
    	for(int i=1;i<N;i++) {
    		update=false;
    		for(int k=1;k<=N;k++) {
    			for(int[] next:list[k]){
	    			if(arr[k]==Long.MAX_VALUE)break;
	    			if(arr[next[0]]>arr[k]+next[1]) {
		    			arr[next[0]]=arr[k]+next[1];
		    			update=true;
	    			}
    			}
    		}
    		if(!update)break;
    	}
    	
    	if(!update) return false;
    	else {
    		
    		for(int i=1;i<=N;i++) {
    			for(int[] next:list[i]) {
    				if(arr[i]==Long.MAX_VALUE)break;
    				if(arr[next[0]]>arr[i]+next[1])return true; 
    				
    			}
    		}
    		return false;
    	}
    	
    }
    
}