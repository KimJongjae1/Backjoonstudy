import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int N;
	static int[] sumAB;
	static int[] sumCD;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());  
			StringBuilder sb=new StringBuilder();
		 

			  N=Integer.parseInt(st.nextToken());
			  int K=Integer.parseInt(st.nextToken());
			  int M=0;
			  int V=0;
			  PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
				  @Override
				  public int compare(int[] a,int[] b) {
					  return b[1] != a[1] ? b[1] - a[1] : a[0] - b[0];
				  }
			  });
			  for(int i=0;i<N;i++) {
				  st=new StringTokenizer(br.readLine());  
				  M=Integer.parseInt(st.nextToken());
				  V=Integer.parseInt(st.nextToken());
				  pq.offer(new int[] {M,V});
			  }
			  
			  TreeMap<Integer,Integer> C=new TreeMap<>();
			 
			  for(int i=0;i<K;i++) {
				  int a=Integer.parseInt(br.readLine());
				  C.putIfAbsent(a, 0);
				  C.put(a, C.get(a)+1);
			  }                                             
			  
			 long result=0;
			  while(!pq.isEmpty()) {
				  int[] temp=pq.poll();
				 Integer a= C.ceilingKey(temp[0]);
				 if(a==null) continue;
				result+=temp[1];
			     int num=C.get(a);
			     if(num==1) C.remove(a);
			     else C.put(a, num-1);
			  }
			  System.out.println(result);
		 }
	 }
