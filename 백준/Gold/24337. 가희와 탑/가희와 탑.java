import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static int N;
    static boolean[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
    	  N=Integer.parseInt(st.nextToken());
    	  int a=Integer.parseInt(st.nextToken());
    	  int b=Integer.parseInt(st.nextToken());
     	  
    	  
    	  int len=a+b-1;  	  

    	  if(N<len) {//최솟값
    		  System.out.println(-1);
    		  return;
    	  }
    	  
    	  StringBuilder sb=new StringBuilder();
    	  if(a>=b) {
    		  
    			for(int i=0;i<N-len;i++) {
    				sb.append(1).append(" ");
    			}

    		  for(int i=1;i<=a;i++) {
    			  sb.append(i).append(" ");
    		  }

    		  
    		  for(int i=b-1;i>0;i--) {
    			  sb.append(i).append(" ");
    		  }
    		  
    	  }else {
    	
    		  if(a!=1) {
    			  for(int i=0;i<N-len;i++)
    			  sb.append(1).append(" ");
    		  }
    		  
    		  for(int i=1;i<a;i++) {
    			  sb.append(i).append(" ");
    		  }
    		  
    		  sb.append(b).append(" "); 	
    		  
    		 
    		  if(a==1) {
    			for(int i=0;i<N-len;i++) {
    			  sb.append(1).append(" ");
    		  	}
    		  }
    		  
    		  for(int i=b-1;i>0;i--) {
    			  sb.append(i).append(" "); 	
    		  }
    		  
  

    	  }
    
    	System.out.println(sb);

    }
}