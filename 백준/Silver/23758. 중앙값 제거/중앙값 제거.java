import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();;
     	N=Integer.parseInt(st.nextToken());//나무 수
    	PriorityQueue<Integer> min=new PriorityQueue<>(Collections.reverseOrder());
     	PriorityQueue<Integer> max=new PriorityQueue<>();

     	st=new StringTokenizer(br.readLine());
     	for(int i=0;i<N;i++) 
     		max.offer(Integer.parseInt(st.nextToken()));
     	

   		
   		int n=N/2;
   		while(max.size()>n) {
   			min.offer(max.poll());
   		}

   		int cnt=0;
   		while(!min.isEmpty()) {
   			M=min.poll();
   			
   			for(int i=30;i>=0;i--) {
   				if((M&(1<<i))>0) {

   					cnt+=i;
   					break;
   				}
   			}
   			
   		}
     	cnt++;
     	System.out.println(cnt);
     	
    }
}