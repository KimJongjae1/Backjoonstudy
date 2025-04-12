
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long M;
	static long[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Long.parseLong(st.nextToken());
        arr=new long[N][N];
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int k=0;k<N;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        	}
        }
        long[][] ans=new long[N][N];
        ans= time(M);
        
       for(int i=0;i<N;i++) {
    	   for(int k=0;k<N;k++) {
    		   System.out.print(ans[i][k]%1000+" ");
    	   }
    	   System.out.println();
       }
        
    }
    public static long[][] time(long depth) {
    	if(depth==1) return arr;
    	
    	long[][] ans=new long[N][N];
    	long[][] temp=new long[N][N];
    	temp=time(depth/2);
    	
    	ans=arrtime(temp,temp);

    	if(depth%2==1) {
    		ans=arrtime(ans,arr);
    	}
    	
    	return ans;
    	
    }
    public static long[][] arrtime(long[][] a,long[][] temp) {
    	long[][] ans=new long[N][N];
    	
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<N;k++) {
    			for(int q=0;q<N;q++) {
    				ans[i][k]+=(a[i][q]*temp[q][k])%1000;
    			}
    			ans[i][k]%=1000;
    		}
    	}
    	
    	
    	return ans;
    }
    
}