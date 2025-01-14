import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
	
    public static void main(String[] args) throws IOException {
    	 Deque<Integer> q =new LinkedList<Integer>();
    	 BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	 StringBuilder sb = new StringBuilder();
    
    int N=Integer.parseInt(br.readLine());
    
    //2 1 
    int count=0;
    for(int i=0;i<N;i++) {
    	String str = br.readLine();
 	   if(str.charAt(0)=='p'&&str.charAt(1)=='u') {//push
 		   String[] temp =str.split(" ");
 		   q.offerFirst(Integer.parseInt(temp[1]));
 		   count++;
 	
 	   }
 	   
 	   else if(str.charAt(0)=='p'&&str.charAt(1)=='o') {//pop
 		      if(q.peekFirst()!=null) {
 		    	 sb.append(q.pollFirst()).append("\n");
	              count--; 
 	              }else {sb.append(-1).append("\n");}
       }
 	   
 	   else if(str.charAt(0)=='s') {
 		  sb.append(count).append("\n");
	   }
 	   
 	   else if(str.charAt(0)=='e') {
		   if(count>0) {
			   sb.append(0).append("\n"); }
		   else {sb.append(1).append("\n"); }
	   }
 	   
 	   else if(str.charAt(0)=='t') {
 		  if( q.peekFirst()!=null) {
 			  sb.append(q.peekFirst()).append("\n");
	        }else {  sb.append(-1).append("\n"); }
        }
	 }
    System.out.print(sb);	
  }
}