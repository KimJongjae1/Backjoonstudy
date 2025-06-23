import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(br.readLine());
        
        long min=1;
        long max=M;
        while(min<max) {
        	long mid=(max+min)/2;
        	long cnt=count(mid);//mid== 매개변수 그 자체// 이걸 풀어내는 방법
        	
        	if(cnt<M) {
        		min=mid+1;
        	}else {
        		max=mid;
        	}
        	
        			
        	
        }
        
        System.out.println(min);
    }
    public static long count(long mid) {
    	long ret=0;
    	
    	for(int i=1;i<=N;i++) {
    		
    		ret+=Math.min(mid/i, N);
    	}
    	return ret;
    	
    }
}
