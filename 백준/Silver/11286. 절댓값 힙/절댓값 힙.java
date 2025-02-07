import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pluspq = new PriorityQueue<>();
    PriorityQueue<Integer> minuspq = new PriorityQueue<>(Collections.reverseOrder());
    
    for(int i=0;i<N;i++) {
    	int temp = Integer.parseInt(br.readLine());
    	if(temp>0) {
    		pluspq.offer(temp);
    	}else if(temp<0) {
    		minuspq.offer(temp);
    	}else {
    		if(pluspq.isEmpty()&&minuspq.isEmpty()) {
    			System.out.println(0);
    			continue;
    		}else if(!pluspq.isEmpty()&&minuspq.isEmpty()) {
    			System.out.println(pluspq.poll());
    			continue;
    		}else if(pluspq.isEmpty()&&!minuspq.isEmpty()) {
    			System.out.println(minuspq.poll());
    			continue;
    		}
    		
    		
    		 int plus=pluspq.peek();
    		
    		
    		 int  minus=-(minuspq.peek());
    		
    		if(minus>plus) {
    			System.out.println(plus);
    			if(plus!=0)
    				pluspq.poll();
    		}else {
    			System.out.println(-minus);
    			if(minus!=0)
    				minuspq.poll();
    		}
    		
    		
    	}
    }
   
    
    
   } 
}