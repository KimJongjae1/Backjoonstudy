import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] tree;
    static int[] lazy;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        tree=new int[4*N+1];
        lazy=new int[4*N+1];
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine()) ;
        	int order=Integer.parseInt(st.nextToken());
        	int ts=Integer.parseInt(st.nextToken());
        	int te=Integer.parseInt(st.nextToken());
        	if(order==0) {
        		insert(1,N,1,ts,te);
        	}else {
        		sb.append(query(1,N,1,ts,te)).append("\n");
        	}
        }
    System.out.println(sb);
    }
    public static void change(int[] a,int idx) {
    	if(a[idx]==1) a[idx]=0;
    	else a[idx]=1;
    }
    
    public static void insert(int start,int end,int idx,int ts,int te) {
    	lazyinsert(start,end,idx);
    	if(te<start||end<ts) return;
    	
    	if(ts<=start&&end<=te) {
    		tree[idx]=end-start+1-tree[idx];
    		if(start!=end) {
	    		change(lazy,2*idx);
	    		change(lazy,2*idx+1);
    		}
    		return;
    	}
    	int mid=(start+end)/2;
    	insert(start,mid,idx*2,ts,te);
    	insert(mid+1,end,idx*2+1,ts,te);
    	tree[idx]=tree[idx*2]+tree[idx*2+1];
    }
    
    public static void lazyinsert(int start,int end,int idx) {
    	if(lazy[idx]!=0) {
    		tree[idx]=end-start+1-tree[idx];
    		if(start!=end) {
    			change(lazy,2*idx);
    			change(lazy,2*idx+1);
    		}
    		lazy[idx]=0;
    	}
    }
    
  public static int query(int start,int end,int idx,int ts,int te) {
	  lazyinsert(start,end,idx);
	  if(te<start||end<ts) return 0;
	  
	  if(ts<=start&&end<=te) {
		return tree[idx];
		
	  }
		int mid=(start+end)/2;
    	return query(start,mid,idx*2,ts,te)+query(mid+1,end,idx*2+1,ts,te);
	  
  }
    
}