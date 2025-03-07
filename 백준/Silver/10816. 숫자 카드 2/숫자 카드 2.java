
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

     public static void main(String[] args)throws Exception {
	     BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb= new StringBuilder();
	     int N=Integer.parseInt(br.readLine());
	     StringTokenizer st =new StringTokenizer(br.readLine());
	 
	     Map<Integer,Integer> arr=new HashMap<>(); 
	     for(int i=0;i<N;i++) {
	    	 int temp=Integer.parseInt(st.nextToken());
            if(arr.containsKey(temp)) {
            	int cnt=arr.get(temp);
            	arr.put(temp, cnt+1);
            }else {
            	arr.put(temp, 1);
            }

	     }
	     
	     
	     int M=Integer.parseInt(br.readLine());
	     st =new StringTokenizer(br.readLine());
	     for(int i=0;i<M;i++) {
	    	 int a=Integer.parseInt(st.nextToken());
	    	 if(!arr.containsKey(a)) {
	    		 sb.append(0).append(" ");
	    	 }else {
	    		 sb.append(arr.get(a)).append(" ");
	    	 }
	    	 
	     }
	     
	     System.out.println(sb);
     }
 
 }