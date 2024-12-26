import java.util.*;
import java.io.*;
public class Main {
	

	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int N = Integer.parseInt(br.readLine());
    int[] a = new int[N];
    
    for(int i=0;i<N;i++) {
    	a[i]=Integer.parseInt(br.readLine());
    }
    		
    Arrays.sort(a);
    
    System.out.println(a[0]);
    for(int i=1;i<N;i++) {
    	if(a[i]!=(a[i-1])) {
    		sb.append(a[i]).append("\n");
    	}
    }
    System.out.println(sb);
   }
}