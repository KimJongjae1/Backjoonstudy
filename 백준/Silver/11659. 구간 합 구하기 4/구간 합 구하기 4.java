import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine());
    int N=Integer.parseInt(st.nextToken());
    int M =Integer.parseInt(st.nextToken());
    
    st= new StringTokenizer(br.readLine());
    int[] arr = new int[N+1];
    int[] prefixsum = new int[N+1];
    int sum=0;
    for(int i=1;i<=N;i++) {
    	arr[i]=Integer.parseInt(st.nextToken());
    	sum+=arr[i];
    	prefixsum[i]=sum;
    }
    
    for(int i=0;i<M;i++) {
    	int ans=0;
    	 st= new StringTokenizer(br.readLine());
    	 int k=Integer.parseInt(st.nextToken());
    	 int j =Integer.parseInt(st.nextToken());
    	 if(k==j) {
    		 System.out.println(arr[k]);
    		 continue;
    	 }else {
    		 ans=prefixsum[j]-prefixsum[k-1];
    	 }
    		System.out.println(ans); 
    	 
    }
    
 }  
}