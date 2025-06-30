import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static Integer N;
    public static long[] tree;
    public static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        arr=new long[N+1];
        tree=new long[4*N];
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        init(1,N,1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
        	
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	
        	
        	sb.append(minimum(1,N,a,b,1)).append("\n");
        	
        }
        System.out.println(sb);
    	
    }
    public static long init(int start,int end,int idx) {
    	if(start==end) return tree[idx]=arr[start];
    	
    	int mid=(start+end)/2;
    	return tree[idx]=Math.min(init(start,mid,idx*2), init(mid+1,end,idx*2+1));
    	
    }
    
    
    public static long minimum(int start,int end,int targets,int targete,int idx) {
    	if(start>targete||end<targets) {
    		return Integer.MAX_VALUE;
    	}
    	
    	if(start>=targets&&targete>=end) {
    		return tree[idx];
    	}
    	
    	
    		int mid=(start+end)/2;
    		
    		return Math.min(minimum(start,mid,targets,targete,idx*2),minimum(mid+1,end,targets,targete,idx*2+1));
    	
    	
    	
    }
}
