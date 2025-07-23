import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] tree;
	
	static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int t=0;t<T;t++) {
	        StringTokenizer st=new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        arr=new int[N+1];
	        int[] origin=new int[N+1];
	        tree=new int[4*N][2];
	    
	        int[] prefixsum=new int[N+1];
	        for(int i=1;i<N;i++) {
	        	prefixsum[i]=prefixsum[i-1]+i;
	        	arr[i]=origin[i]=i;
	        	insert(0,N-1,1,i);
	        }
	       

	   
	        for(int i=0;i<M;i++) {
	        	st=new StringTokenizer(br.readLine());
	        	int order=Integer.parseInt(st.nextToken());
	    		int a=Integer.parseInt(st.nextToken());
        		int b=Integer.parseInt(st.nextToken());
	        	if(order==0) {
	        		change(0,N-1,1,a,arr[b]);
	        		change(0,N-1,1,b,arr[a]);
	        		int temp=arr[a];
	        		arr[a]=arr[b];
	        		arr[b]=temp;
	        	}else {
	        		int left=minprint(0,N-1,1,a,b);
	        		int right=maxprint(0,N-1,1,a,b);
	       
	        		
	        		if(left==a&&right==b)
	        		sb.append("YES").append("\n");
	        		else sb.append("NO").append("\n");
	        	}
	        }
	      
        }
       System.out.println(sb); 
    }
    public static void insert(int start,int end,int idx,int i) {
    	if(i<start||end<i) {
    		return;
    	}
    	
    	if(start==end) {
    		tree[idx][0]=arr[i];
    		tree[idx][1]=arr[i];
    		return;
    	}
    	
    	
    	int mid=(start+end)/2;
    	insert(start,mid,idx*2,i);
    	insert(mid+1,end,idx*2+1,i);
    	
    	tree[idx][0]=Math.min(tree[idx*2][0], tree[idx*2+1][0]);
    	tree[idx][1]=Math.max(tree[idx*2][1], tree[idx*2+1][1]);
    }
    
    public static void change(int start,int end,int idx,int i,int diff) {
    	if(i<start||end<i) {
    		return;
    	}
    
    	if(start==end) {
    		tree[idx][0]=diff;
    		tree[idx][1]=diff;
    		return;
    	}
    	
    	
    	int mid=(start+end)/2;
    	change(start,mid,idx*2,i,diff);
    	change(mid+1,end,idx*2+1,i,diff);
    	tree[idx][0]=Math.min(tree[idx*2][0], tree[idx*2+1][0]);
    	tree[idx][1]=Math.max(tree[idx*2][1], tree[idx*2+1][1]);
    }
   
    public static int minprint(int start,int end,int idx,int ts,int te) {
    	if(te<start||end<ts) return Integer.MAX_VALUE;
    	
    	if(ts<=start&&end<=te) {
    		return tree[idx][0];
    	}
    	int mid=(start+end)/2;
    	int left=minprint(start,mid,idx*2,ts,te);
    	int right=minprint(mid+1,end,idx*2+1,ts,te);
    	
    	return Math.min(left, right);
    	
    }
    
    public static int maxprint(int start,int end,int idx,int ts,int te) {
    	if(te<start||end<ts) return 0;
    	
    	if(ts<=start&&end<=te) {
    		return tree[idx][1];
    	}
    	int mid=(start+end)/2;
    	int left=maxprint(start,mid,idx*2,ts,te);
    	int right=maxprint(mid+1,end,idx*2+1,ts,te);
    	
    	return Math.max(left, right);
    	
    }
}
