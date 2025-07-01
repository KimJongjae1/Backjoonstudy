import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static Integer N;
    public static long[] tree;
    public static long[] arr;
    public static final long log=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
       
        arr=new long[N+1];

        for(int i=1;i<=N;i++) {
        	arr[i]=Long.parseLong(br.readLine());
        }
     
        tree=new long[4*N];
        init(1,N,1);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<(M+K);i++) {
        	st=new StringTokenizer(br.readLine());
        	int order=Integer.parseInt(st.nextToken());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	
        	if(order==1) {
        		change(1,N,1,a,b);
        		arr[a]=b;
        	}else {
        		sb.append(multy(1,N,1,a,b)+"\n");
        	}
        	
        }
        System.out.println(sb);
        
    }
    public static long init(int start,int end,int idx) {
    	if(start==end) return tree[idx]=arr[start];
    	
    	int mid=(start+end)/2;
    	return tree[idx]=(init(start,mid,idx*2)%log*init(mid+1,end,idx*2+1)%log)%log;
    	
    }
    
    public static void change(int start,int end,int idx,int diffidx,long diff) {
    	if(diffidx<start||end<diffidx) return;
    	
    	if(start==end) {
    		tree[idx]=diff;
    		return;
    	}
    	
    	int mid=(start+end)/2;
    	change(start,mid,idx*2,diffidx,diff);
    	change(mid+1,end,idx*2+1,diffidx,diff);
    	
    	tree[idx]=(tree[idx*2]%log*tree[idx*2+1]%log)%log;
    	
    }

    	public static long multy(int start,int end,int idx,int ts,int te) {
    		if(te<start||end<ts) return 1;
    		
    		if(ts<=start&&end<=te) {
    			return tree[idx];
    		}
    		int mid=(start+end)/2;
    		return (multy(start,mid,idx*2,ts,te)%log*multy(mid+1,end,idx*2+1,ts,te)%log)%log;
    
    	}
	
}