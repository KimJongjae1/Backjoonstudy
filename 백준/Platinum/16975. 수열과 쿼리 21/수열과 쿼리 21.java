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
    public static long[] lazy;
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
        tree=new long[4*N];
        lazy=new long[4*N];
       sb=new StringBuilder();
        int M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
        	   st=new StringTokenizer(br.readLine());
        	   int order=Integer.parseInt(st.nextToken());
        	   if(order==1) {
        		   int s=Integer.parseInt(st.nextToken());
        		   int e=Integer.parseInt(st.nextToken());
        		   int k=Integer.parseInt(st.nextToken());
        		   insert(1,N,1,s,e,k);
        	   }else {
        		   int s=Integer.parseInt(st.nextToken());
        		   pop(1,N,1,s);
   
        	   }    
        }
        
        System.out.println(sb);
        
    }
    public static void lazy_insert(int start,int end,int idx) {
    	if(lazy[idx]!=0) {
    		tree[idx]+=lazy[idx];
    		if(start!=end) {
    			lazy[2*idx]+=lazy[idx];
    			lazy[2*idx+1]+=lazy[idx];
    		}
    		lazy[idx]=0;
    	}
    	
    }
    
    public static void insert(int start,int end,int idx,int ts,int te,int k) {
    	lazy_insert(start,end,idx);
    	if(end<ts||te<start) return;
    	
    	if(ts<=start&&end<=te) {
    		tree[idx]+=k;
    		if(start!=end) {
    			lazy[idx*2]+=k;
    			lazy[idx*2+1]+=k;
    		}
    		return;
    	}
    	
    	int mid=(start+end)/2;
    	insert(start,mid,idx*2,ts,te,k);
    	insert(mid+1,end,idx*2+1,ts,te,k);
    }
    
    public static void pop(int start,int end,int idx,int s) {
    	lazy_insert(start,end,idx);
    	if(s<start||end<s) return;
    	
    	 if(start==end) {
    		 sb.append(tree[idx]+arr[s]).append("\n");
    		 return;
    	 }
    	 
    	 int mid=(start+end)/2;
 
    	pop(start,mid,idx*2,s);
    	pop(mid+1,end,idx*2+1,s);
    }
    
}
