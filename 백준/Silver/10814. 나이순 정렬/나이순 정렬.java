import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N=Integer.parseInt(br.readLine());
    	
    	String[][] S = new String[N][3];
    	for(int i=0;i<N;i++) {
    	   StringTokenizer st = new StringTokenizer(br.readLine());
    	   S[i][0]=st.nextToken();
    	   S[i][1]=st.nextToken(); 
    	   S[i][2]=Integer.toString(i);
    	
    	}
    	// 21 Junkyu 0
    	Arrays.sort(S,new Comparator<String[]>(){
    	    public int compare(String[] a, String[] b) {
    	    	if(Integer.parseInt(a[0])!= Integer.parseInt(b[0]))
    	    	return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
    	    	else {return Integer.compare(Integer.parseInt(a[2]), Integer.parseInt(b[2]));}
    	    }
    	});
    	
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<2;k++) {
    			System.out.print(S[i][k]+" ");
    		}
    		System.out.println();
    	}
    	
    	
    }  
}