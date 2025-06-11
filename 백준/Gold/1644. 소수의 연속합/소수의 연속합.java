import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
			StringTokenizer st=new StringTokenizer(br.readLine());  		 
			 
			 N=Integer.parseInt(st.nextToken());
			 int[] prime=new int[N+1];
			 prime[0]=2;
			 int idx=1;
			 Loop:for(int i=3;i<=N;i++) {
				 int num=(int)Math.sqrt(i);
				 
				 for(int k=2;k<=num;k++) {
					if(i%k==0) {
						continue Loop;
					}
				 }
				 prime[idx]=i;
				 if(prime[idx]>=N) {
					 idx++;
					 break;
				 }
				 idx++;
			 }
			
			 int start=0;
			 int end=0;
			 int s=0;
			 int result=0;
			 while(start<=end&&end<=idx) {
				 if(s<N) {
					 s+=prime[end++];
				 }else if(s>N) {
					 s-=prime[start++];
				 }else {
					 result++;
					 s-=prime[start++];
				 }
			 }
			 System.out.println(result);
	 }
	 
 }
