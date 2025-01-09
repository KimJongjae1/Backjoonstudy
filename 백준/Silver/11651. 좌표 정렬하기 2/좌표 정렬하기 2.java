import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[][] n=new int[N][2];
    	
    	for(int i=0;i<N;i++) {
    		StringTokenizer st= new StringTokenizer(br.readLine());
    		
    		n[i][0]=Integer.parseInt(st.nextToken());
    		n[i][1]=Integer.parseInt(st.nextToken());    			
    	}
    	
    	Arrays.sort(n, new Comparator<int[]>() {
    		public int compare(int[] a,int[] b) {
    			if(a[1]!=b[1])
    				return Integer.compare(a[1], b[1]);
    			else{return Integer.compare(a[0], b[0]);}
    		}
    	});
    	
    	for(int i=0;i<N;i++) {
    		System.out.println(n[i][0]+" "+n[i][1]);
    	}
    	
    	
    }  
}