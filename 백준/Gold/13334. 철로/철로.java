import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<N;i++) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	int s=Integer.parseInt(st.nextToken());
        	int e=Integer.parseInt(st.nextToken());
        	if(s<e)
        	list.add(new int[] {s,e});
        	else list.add(new int[] {e,s});
        }
        
        Collections.sort(list,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a,int[] b) {
        		if(a[1]!=b[1]) return Integer.compare(a[1], b[1]);
        		else return Integer.compare(a[0], b[0]);
        	}
        });
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int L=Integer.parseInt(br.readLine());
        int ret=0;
        for(int i=0;i<N;i++) {
        	int[] road=list.get(i);
        	if(road[1]-road[0]>L)
        		continue;
        	
        	   pq.offer(road[0]);
        	
        	while(!pq.isEmpty()) {
        		if(road[1]-pq.peek()>L)
        			pq.poll();
        		else break;
        	}
        	ret=Math.max(ret, pq.size());
        }
        System.out.println(ret);
    }
}
