import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N;
    static Set<Long> hash;
    static void hashing(long[] arr,int s,int e) {
    	long offset=31;
    	long h=0;
    	for(int i=s;i<e;i++) {
    		h=h*offset+arr[i];
    	}
    	hash.add(h);
    	h=0;
    	for(int i=e-1;i>=s;i--) {
    		h=h*offset+arr[i];
    	}
    	hash.add(h);
    }
    static boolean check(long[] arr,int s,int e) {
    	long offset=31;
    	long h=0;
    	for(int i=s;i<e;i++) {
    		h=h*offset+arr[i];
    	}
    	if(hash.contains(h))return true;
    	h=0;
    	for(int i=e-1;i>=s;i--) {
    		h=h*offset+arr[i];
    	}
    	if(hash.contains(h))return true;
    	
    	return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine()) ;
     
        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
       
        
    	int n=Integer.parseInt(br.readLine());
    	if(n<M) {
    		System.out.println("NO");
    		return;
    	}
    	st=new StringTokenizer(br.readLine()) ;
    	long[] arr=new long[1020];
    	hash=new TreeSet<>();
    	for(int i=0;i<n;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i=0;i<=n-M;i++) {
    		hashing(arr,i,i+M);
    	}
    	
    	int cnt=1;
    	Loop:for(int i=0;i<N-1;i++) {
    		n=Integer.parseInt(br.readLine());
    		if(n<M) {
        		System.out.println("NO");
        		return;
        	}
    		st=new StringTokenizer(br.readLine());
    		for(int k=0;k<n;k++) {
    			arr[k]=Integer.parseInt(st.nextToken());
    			
    		}
    		
    		for(int k=0;k<=n-M;k++) {
    			if(check(arr,k,k+M)) {
    				cnt++;
    				continue Loop;
    			}
    		}
    		
    	}
   
    	if(cnt==N) {
    		System.out.println("YES");
    	}else System.out.println("NO");
  
        
    }
}