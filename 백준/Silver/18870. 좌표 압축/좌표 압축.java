import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int N=Integer.parseInt(br.readLine());
    
    StringTokenizer st =new StringTokenizer(br.readLine());
    int[] arr=new int[N];
   
    
    for(int i=0;i<N;i++) {
    	int temp =Integer.parseInt(st.nextToken());
    	arr[i]=temp;
    	pq.offer(temp);
    	
    }

    HashMap<Integer,Integer> hm = new HashMap<>();
    int count=0;
    int temp=-2000000000;
    for(int i=0;i<N;i++) {  //0 1   2  3 4 5 6  N-1=4
    	if(temp!=pq.peek()) {//2 2 -10 4 -9    -10 -9 2 2 4  
    		temp=pq.poll();
    		hm.put(temp,i-count);
    	}else {
    		pq.poll();
    		count++;
    	}
    }
    
    for(int i=0;i<N;i++) {
    	sb.append(hm.get(arr[i])).append(" ");
    }
    System.out.println(sb);
   
   } 
}