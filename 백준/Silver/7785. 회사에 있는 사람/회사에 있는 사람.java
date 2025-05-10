import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static Integer[] dp;
	static List<Integer>[] tree;
	static int[] parent;
	static int N;
	static int R;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		   StringBuilder sb=new StringBuilder();
		   N =Integer.parseInt(br.readLine());
		   Set<String> set=new TreeSet<>(Collections.reverseOrder());
		 for(int i=0;i<N;i++) {
			   StringTokenizer st=new StringTokenizer(br.readLine());
		
			   String name=st.nextToken();
			   String order=st.nextToken();
			   if(order.equals("enter")) {
				   set.add(name);
			   }else {
				   set.remove(name);
			   }
		   
			   
		 }
		 for(String n:set) {
			   sb.append(n).append("\n");
		   }
			  System.out.println(sb); 
		   

    }

}