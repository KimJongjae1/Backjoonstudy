import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static Integer N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
 
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>() {
        	@Override
        	public int compare(long[] a,long[] b) {
        	if(a[0]!=b[0]) return Long.compare(a[0],b[0]);
        	else return Long.compare(b[1],a[1]);
        	}});
        
        PriorityQueue<Long> sepq=new PriorityQueue<>();
    
        for(int i=0;i<N;i++) {
        	 st=new StringTokenizer(br.readLine());
        	long dead=Long.parseLong(st.nextToken());
        	long cup=Long.parseLong(st.nextToken());
        	pq.offer(new long[] {dead,cup});
        }
        
 
        long ret=0;
        while(!pq.isEmpty()) {
        	long[] pro=pq.poll();
        	
        	if(sepq.size()<pro[0]) {
        		ret+=pro[1];	
        		sepq.offer(pro[1]);
        	}else {
        		Long low=sepq.peek();
        		if(low<pro[1]) {
        			sepq.poll();
        			sepq.offer(pro[1]);
        			ret-=low;
        			ret+=pro[1];
        			
        		}
        	}
        	
        }
      System.out.println(ret);
  
    }
}
