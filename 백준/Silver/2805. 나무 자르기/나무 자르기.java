import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    
	static int white=0;
	static int black=0;
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] tree = new int[N];
    st = new StringTokenizer(br.readLine());
    
    for(int i=0;i<N;i++) {
    	tree[i]=Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(tree);
   
    
    if(N==1) {
    	System.out.println(tree[0]-M);
    	return;
    }
    
    int range=0;
    for(int i=N-2;i>=0;i--) {//2 1 0
    	int previousrange=range;
    	range+=((tree[i+1]-tree[i])*(N-1-i));
    	if(range==M) {
    		System.out.println(tree[i]);
    		return;
    	}
    	else if(range>M&&previousrange<M) {
    		int num=(M-previousrange)/(N-1-i);
    		int num2=(M-previousrange)%(N-1-i);
    		if(num2==0) {
    			System.out.println(tree[i+1]-num);
    			return;
    		}else {
    			System.out.println(tree[i+1]-num-1);
    			return;
    		}
    	}
    }
    int num=(M-range)/N;
    int num2=(M-range)%N;
    if(num2==0) {
		System.out.println(tree[0]-num);
	
	}else {
		System.out.println(tree[0]-num-1);

	}

    } 
}