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
        TreeMap<Long,Long> map=new TreeMap<>();
        for(int i=0;i<N;i++) {
        	 st=new StringTokenizer(br.readLine());
        	long dead=Long.parseLong(st.nextToken());
        	long cup=Long.parseLong(st.nextToken());
        	pq.offer(new long[] {dead,cup});
        }
        
        long ret=pq.poll()[1];
        map.put(ret, 1L);
        int size=1;
        while(!pq.isEmpty()) {
        	long[] pro=pq.poll();
        	
        	if(size<pro[0]) {
        		size++;
        		ret+=pro[1];
        	
        		map.putIfAbsent(pro[1], 0L);
        		map.put(pro[1], map.get(pro[1])+1);
        	}else {
        		Long low=map.lowerKey(pro[1]);
        		if(low==null) continue;
        		else {
        			low=map.firstKey();
        			ret-=low;
        			long num=map.get(low);
        			if(num==1) map.remove(low);
        			else map.put(low, num-1);
        			
        			ret+=pro[1];
        			map.putIfAbsent(pro[1], 0L);
            		map.put(pro[1], map.get(pro[1])+1);
        		}
        	}
        	
        }
      System.out.println(ret);
  
    }
}