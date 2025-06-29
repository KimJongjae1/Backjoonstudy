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
    public static long sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
       
        
      
        tree=new long[4*N];
        arr=new long[N+1];
        for(int i=1;i<=N;i++) {
        	arr[i]=Long.parseLong(br.readLine());
        }
        
        init(1,N,1);
       
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<(M+K);i++) {
        	st=new StringTokenizer(br.readLine());
        	int order=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	long c=Long.parseLong(st.nextToken());
        	
        	if(order==1) {
        		long diff=c-arr[b];
        		arr[b]=c;
        		change(1,N,1,b,diff);
        	}else {
        		sum=0;	
        		allsum(1,N,1,b,(int)c);
       
        		sb.append(sum).append("\n");
        	}	
        }
        
        System.out.println(sb);
    }
    public static long init(int start,int end,int idx) {
    	if(start==end) {
    		return tree[idx]=arr[start];
    	}
    	
    	return tree[idx]=init(start,(end+start)/2,idx*2)+init((end+start)/2+1,end,idx*2+1);
    	
    }
    
    public static void change(int start,int end,int idx,int b,long diff) {
    	if(b<start||b>end) return;
    	
    	tree[idx]+=diff;
    	if(start==end) return;
    	
    	change(start,(start+end)/2,idx*2,b,diff);
    	change((start+end)/2+1,end,idx*2+1,b,diff);
    	
    }
    
    public static void allsum(int start,int end,int idx,int ts,int te) {
    	if(ts>end||te<start) {
    		return;
    	}
    	
    	if(ts<=start&&end<=te) {
    		sum+=tree[idx];
    	}else {
    		allsum(start,(start+end)/2,idx*2,ts,te);
    		allsum((start+end)/2+1,end,idx*2+1,ts,te);
    	}
    	
    	
    }
    
}
