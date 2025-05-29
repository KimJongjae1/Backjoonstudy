import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			  
		   N=Integer.parseInt(br.readLine());
		   PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
			   @Override
			   public int compare(int[] a,int[] b) {
				   if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
				   else return Integer.compare(a[1],b[1]);
			   }
		   });
		   
		   for(int i=0;i<N;i++) {
			   StringTokenizer st=new StringTokenizer(br.readLine());
			   int a=Integer.parseInt(st.nextToken());
			   int b=Integer.parseInt(st.nextToken());
			   pq.offer(new int[] {a,b});
		   }
		   
		   PriorityQueue<Integer> pq2=new PriorityQueue<>();

		   while(!pq.isEmpty()) {
			   int[] now=pq.poll();
			   
			   if(!pq2.isEmpty()&&pq2.peek()<=now[0]) {
				   pq2.poll();   
			   }
			   pq2.add(now[1]);
		   }
		   System.out.println(pq2.size());
		   
	 }
	 
}