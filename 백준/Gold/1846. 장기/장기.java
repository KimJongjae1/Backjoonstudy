import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
	static int N;
	static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine()) ;
      StringBuilder sb=new StringBuilder();
      N=Integer.parseInt(st.nextToken());
      if(N==3) System.out.println(-1);
      else {
    	  int mid=N/2;
    	  if(N%2==1)mid++;
    	  int idx=2;
    	  for(int i=0;i<mid-1;i++) {
    		  sb.append(idx++).append("\n");
    	  }
    	  sb.append(1).append("\n");
    	  sb.append(N).append("\n");
    	  for(int i=0;i<N/2-1;i++) {
    		  sb.append(idx++).append("\n");
    	  }
      }
      System.out.println(sb);
      
    }
}