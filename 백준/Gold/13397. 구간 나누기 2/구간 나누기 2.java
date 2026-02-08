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
   static int[] arr;
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
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
       
        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        System.out.println(upperbound());
	   
   }
    public static int upperbound() {
    	int max=10000;
    	int min=0;
    	while(min<max) {
    		int mid=(max+min)/2;
    	
    		if(check(mid)) {
    			max=mid;
    		}else {
    			min=mid+1;
    		}
    		
    	}
    	return min;
    }
    public static boolean check(int n) {
    	int min=arr[0];
    	int max=arr[0];
    	int cnt=1;
    	for(int i=0;i<N;i++) {
    		max=Math.max(max, arr[i]);
    		min=Math.min(min, arr[i]);
    		if(max-min>n) {
    			min=arr[i];
    			max=arr[i];
    			cnt++;
    		}
    		
    	}
    	if(cnt<=M)return true;
    	else return false;
    }
}