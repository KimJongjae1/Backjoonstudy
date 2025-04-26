import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] diy= {-1,1,0,0};
	static int[] dix= {0,0,-1,1};
	static int N;
	static int ans=0;
	static int[][] arr;
     public static void main (String[] args) throws IOException {
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 
    		 N=Integer.parseInt(br.readLine());
    		 ans=0;
    	
    		 ans+=N/3;
    		 N%=3;
    		 ans+=N;
    		 if(ans%2==0) {
    			 System.out.println("CY");
    		 }else {
    			 System.out.println("SK");
    		 }
     }
}
