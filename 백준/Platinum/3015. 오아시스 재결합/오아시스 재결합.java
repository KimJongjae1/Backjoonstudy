import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        Stack<int[]> stack=new Stack();
       long result=0;
        for(int i=0;i<N;i++) {
        	int people=Integer.parseInt(br.readLine());
        	int cnt=1;
        	
        	while(!stack.isEmpty()&&stack.peek()[0]<=people) {
        		int[] top=stack.pop();
        		result+=top[1];
        		if(top[0]==people) {
        			cnt+=top[1];
        		}
        	
        		
        	}
        	if(!stack.isEmpty()) {
        		result++;
        	}
        	stack.push(new int[] {people,cnt});
        	
        }
        
      
 
        System.out.println(result);
    }
}