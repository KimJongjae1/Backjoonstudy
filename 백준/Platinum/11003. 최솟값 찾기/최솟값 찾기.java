import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
			StringTokenizer st=new StringTokenizer(br.readLine());  		 
				
			int N=Integer.parseInt(st.nextToken());
			int L=Integer.parseInt(st.nextToken());
				 
			 st=new StringTokenizer(br.readLine());  
		
			 Deque<int[]> dq=new LinkedList<>();
			 StringBuilder sb=new StringBuilder();
		
			 for(int i=1;i<=N;i++) {
				 int a=Integer.parseInt(st.nextToken());
			
				 int range=i-L+1;
				 
				 while(!dq.isEmpty()&&dq.peekLast()[0]>a) {
					 dq.pollLast();
				 }
				 
					dq.offer(new int[] {a,i});
					
				while(dq.peekFirst()[1]<range) {
					dq.pollFirst();
				}
				 sb.append(dq.peekFirst()[0]).append(" ");
			 }
			 
			System.out.println(sb);
		 
	 }
	 
 }
