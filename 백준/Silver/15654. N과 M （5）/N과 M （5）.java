import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int M;
	static Stack<Integer> stack = new Stack<>();
	static Deque<Integer> list = new LinkedList<>();
	
	public static void dfs(int[] arr,int a){
	stack.push(a);
	list.offer(a);
	if(stack.size()==M) {
		for(int i=0;i<M;i++) {
			int temp=list.peekFirst();
			System.out.print(temp+" ");
			list.offerLast(list.pollFirst());
		}System.out.println();
	}
	  if(stack.size()<M) {
		for(int i=0;i<N;i++) {
		    if(!stack.contains(arr[i])) {
		    	dfs(arr,arr[i]);
		        
		    	list.pollLast();
		    	stack.pop();
		   
		    	  if(stack.size()==1&&arr[i]==arr[arr.length-1]) {
		    		  list.pollLast();
				    stack.pop();
					  break;
				  }
		    }
		
		}
	  }		
	}
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
   
    
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i=0;i<N;i++) {
    	arr[i]=Integer.parseInt(st.nextToken());
    }
   
    Arrays.sort(arr);
   if(M==1) {
	   for(int i=0;i<N;i++) {
	    	System.out.println(arr[i]);
	      }
   }else {
      for(int i=0;i<N;i++) {
    	dfs(arr,arr[i]);
      }
   }
    
    
   } 
}