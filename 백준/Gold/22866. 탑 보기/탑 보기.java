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
    	  Stack<int[]> stack=new Stack();

    	  st=new StringTokenizer(br.readLine());
    	  int[] building=new int[N+1];
    	  int[][] ret=new int[N+1][2];
    	  int[] cnt=new int[N+1];
    	  for(int i=1;i<=N;i++) {
    		  building[i]=Integer.parseInt(st.nextToken());
    	  }
    	  for(int i=1;i<=N;i++) {
      		 ret[i][1]=Integer.MAX_VALUE;
      	 }
    	  stack.push(new int[] {building[N],N});
    
    	  for(int i=N-1;i>=1;i--) {
    		  int[] max=stack.peek();
       		  if(max[0]<=building[i]) {
    			  stack.pop();
    			  while(!stack.isEmpty()&&stack.peek()[0]<=building[i] ) {
    				  stack.pop();
    			  }
    			  if(!stack.isEmpty()) max=stack.peek();
    			  else{
    				  stack.push(new int[] {building[i],i});
    				  continue;
    			  }
    		  }

    			ret[i][0]=max[0];
    			ret[i][1]=max[1];
    			cnt[i]+=stack.size();
   
    	    	stack.push(new int[] {building[i],i});
    			 
    			
    	  }
  
    	
    	  stack.clear();
     	  stack.push(new int[] {building[1],1});
    	  for(int i=2;i<=N;i++) {
    		  int[] max=stack.peek();
    		  if(max[0]<=building[i]) {
    			  stack.pop();
    			  while(!stack.isEmpty()&&stack.peek()[0]<=building[i] ) {
    				  stack.pop();
    			  }
    			  if(!stack.isEmpty()) max=stack.peek();
    			  else{
    				  stack.push(new int[] {building[i],i});
    				  continue;
    			  }
    		  }
    		
    		if(ret[i][1]-i>=i-max[1]) {  
    			ret[i][0]=max[0];
    			ret[i][1]=max[1];
    		}
    		cnt[i]+=stack.size();
  		
  	    	stack.push(new int[] {building[i],i});
  			 
    		  
    	  }
    	  
    	 for(int i=1;i<=N;i++) {
    		 if(ret[i][1]!=Integer.MAX_VALUE)
    		 sb.append(cnt[i]+" "+ret[i][1]).append("\n");
    		 else  sb.append(0).append("\n");
    	 }
    	 System.out.println(sb);
    	  
    }
}