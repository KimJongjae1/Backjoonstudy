import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] Ai = new int[N];
    int count=0;
    for(int i=0;i<N;i++) {
    	Ai[i]=Integer.parseInt(br.readLine());
    }
    
    for(int i=N-1;0<=i;i--) {
    	if(K%Ai[i]!=K) {
    		count+=K/Ai[i];
    		K%=Ai[i];
    	
    		if(K==0) {
    			break;
    		}
    	}

    }
    
    System.out.println(count);
    
   }
}