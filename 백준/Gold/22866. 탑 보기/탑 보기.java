import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
   static int N;
    static boolean[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
    	  N=Integer.parseInt(st.nextToken());
    	  Stack<Integer> stack=new Stack();

    	  st=new StringTokenizer(br.readLine());
    	  int[] building=new int[N+1];
    	  int[] idx=new int[N+1];
    	  int[] cnt=new int[N+1];
    	  for(int i=1;i<=N;i++) {
    		  building[i]=Integer.parseInt(st.nextToken());
    		  idx[i]=-1000000;
    	  }
    	 
    
    	  for(int i=1;i<=N;i++) {
    		  while(!stack.isEmpty()&&building[stack.peek()]<=building[i]) {
    			  stack.pop();
    		  }
    		  
    		  cnt[i]+=stack.size();
    		  if(cnt[i]>0) idx[i]=stack.peek();
    		  stack.push(i);

    	  }
  
    	  stack.clear();
    	  for(int i=N;i>=1;i-- ) {
    		  while(!stack.isEmpty()&&building[stack.peek()]<=building[i]) {
    			  stack.pop();
    		  }
    		  
    		  if(!stack.isEmpty()&&stack.peek()-i<i-idx[i]) {
    			  idx[i]=stack.peek();
    		  }
    		  cnt[i]+=stack.size();
    	
    		  stack.push(i);
  			 
    		  
    	  }
    	  
    	 for(int i=1;i<=N;i++) {
    		 if(cnt[i]>0) sb.append(cnt[i]+" "+idx[i]).append("\n");
    		 else  sb.append(0).append("\n");
    	 }
    	 System.out.println(sb);
    	  
    }
}