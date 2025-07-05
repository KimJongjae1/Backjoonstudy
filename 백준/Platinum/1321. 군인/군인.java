import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static Integer N;
    public static long[] tree;
    public static long[] arr;
    public static  StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        
        arr=new long[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine()); 
        tree=new long[4*N];
        init(1,N,1);
        sb=new StringBuilder();
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	int order=Integer.parseInt(st.nextToken());
        	
        	if(order==1) {
        		int team=Integer.parseInt(st.nextToken());
        		int num=Integer.parseInt(st.nextToken());
        		change(1,N,1,team,num);
        		arr[team]+=num;
        	}else {
        		int soldier=Integer.parseInt(st.nextToken());
        		sb.append(lowerbound(soldier)).append("\n");
        	}
        	
        }
        System.out.println(sb);
    }
     public static long init(int start,int end,int idx) {
    	 if(start==end) {
    		 return tree[idx]=arr[start];
    	 }
    	 
    	 int mid=(start+end)/2;
    	 return tree[idx]=init(start,mid,idx*2)+init(mid+1,end,idx*2+1);
    	 
     }
     
     public static void change(int start,int end,int idx,int team,int diff) {
    	 if(team<start||end<team) return;
    	 
    	
    		tree[idx]+=diff;
    		if(start==end) return; 
    	 
    	 int mid=(start+end)/2;
    	change(start,mid,idx*2,team,diff);
    	change(mid+1,end,idx*2+1,team,diff);	 
     }
     public static int lowerbound(int soldier) {
    	 int max=N;
    	 int min=1;
    	 while(min<max) {
    		 int mid=(max+min)/2;
    		 
    		 if(print(1,N,1,1,mid)<soldier) {
    			 min=mid+1;
    		 }else {
    			 max=mid;
    		 }
    		 
    	 }
    	 return min;
     }
     public static long print(int start,int end,int idx,int ts,int team) {
    	 if(team<start||end<ts) {
    		 return 0;
    	 }
    	 
    	 if(ts<=start&&end<=team) {
    		 return tree[idx];
    	 }
    	 
    	 int mid=(start+end)/2;
    	 return print(start,mid,2*idx,ts,team)+print(mid+1,end,2*idx+1,ts,team);
    	 
     }
     
}

