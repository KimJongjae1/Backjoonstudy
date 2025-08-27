import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
   static int N;
   static int M;
   static long[] tree;
   static int[] arr;
   static int[] mintree;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
     	  N=Integer.parseInt(st.nextToken());
     	   arr=new int[N+1];
     	  tree=new long[4*N+5];
     	  mintree=new int[4*N+5];
     	  Arrays.fill(mintree, Integer.MAX_VALUE);
     	 st=new StringTokenizer(br.readLine());
     	  for(int i=1;i<=N;i++) {
     		  arr[i]=Integer.parseInt(st.nextToken());
     	  }
     	  arr[0]=Integer.MAX_VALUE;
     	  sum(1,N,1);
     	  minimum(1,N,1);
     	  System.out.println(ans(1,N));
     	
    }
    public static long ans(int start,int end) {
    	if(start>end) return 0;
    	
    	int minIdx=querymin(1,N,1,start,end);
    	long sums=querysum(1,N,1,start,end);
    	long area=sums*arr[minIdx];
    	
    	if(start<minIdx) {
    		area=Math.max(area, ans(start,minIdx-1));
    	}
    	
    	if(minIdx<end) {
    		area=Math.max(area, ans(minIdx+1,end));
    	}
    	return area;
    }
    
    
    public static void sum(int start,int end,int idx) {
    	if(start==end) {
    		tree[idx]=arr[start];
    		return;
    	}
    	
    	int mid=(start+end)/2;
    	sum(start,mid,idx*2);
    	sum(mid+1,end,idx*2+1);
    	tree[idx]=tree[idx*2]+tree[idx*2+1];
    }
    public static void minimum(int start,int end,int idx) {
    	if(start==end) {
    		mintree[idx]=start;
    		return;
    	}

    	int mid=(start+end)/2;
    	minimum(start,mid,idx*2);
    	minimum(mid+1,end,idx*2+1);
    	if(arr[mintree[idx*2]]<arr[mintree[idx*2+1]]) {
    		mintree[idx]=mintree[idx*2];
    	}else {
    		mintree[idx]=mintree[idx*2+1];
    	}
    
    	
    }
    public static long querysum(int start,int end,int idx,int ts,int te) {
    	if(te<start||end<ts) return 0;
    	
    	if(ts<=start&&end<=te) return tree[idx];
    	
    	int mid=(start+end)/2;
    	return querysum(start,mid,idx*2,ts,te)+querysum(mid+1,end,idx*2+1,ts,te);
    	
    }
    public static int querymin(int start,int end,int idx,int ts,int te) {
    	if(te<start||end<ts) return 0;
    	
    	if(ts<=start&&end<=te) return mintree[idx];
    	
    	int mid=(start+end)/2;
    	
    	int t1=querymin(start,mid,idx*2,ts,te);
    	int t2=querymin(mid+1,end,idx*2+1,ts,te);
    	if(arr[t1]<arr[t2]) {
    		return t1;
    	}else {
    		return t2;
    	}
    	
    }

}