import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
   static int[] dp;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<Integer> list;
   static TreeSet<Integer> set;  
   static TreeMap<Integer,Integer> map;
   static int first;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	
	   StringTokenizer st=new StringTokenizer(br.readLine());
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    K=Integer.parseInt(st.nextToken());
	    st=new StringTokenizer(br.readLine());

	    set=new TreeSet<>();
		for(int i=0;i<M;i++) {
			int n=Integer.parseInt(st.nextToken());
			set.add(n);
		}
	 set.add(0);

	    int min=upperbound();
	    check(min);
	    System.out.println(max+" "+first);
    	
    }
    public static int upperbound() {
    	int min=1;
    	int max=N;
    	while(min<max) {
    		int mid=(max+min)/2;
    		
    		if(!check(mid)) {
    			min=mid+1;
    		}else {
    			max=mid;
    		}
    		
    	}
    	return min;
    }
    public static boolean check(int min) {
    	int cur=N;
    	int cnt=K;
    	max=0;
    	first=N;
    	while(cnt>0) {
    		Integer next=set.ceiling(cur-min);
    		if(next==null)return false;
    		if(next==cur)return false;
    		
    		max=Math.max(max, Math.abs(cur-next));
    		
    		if(next==0) 
    			break;
    		
    		cnt--;
    		first=next;
    		cur=next;
    		
    	}
    	
    
    	
    	max=Math.max(cur, max);
    	if(max>min) return false;
    	
    	if(cnt>0) {
    		int temp=set.higher(0);
    		first=temp;
    	}
    	
    	
    	return true;
    	
    	
    	
    }
}