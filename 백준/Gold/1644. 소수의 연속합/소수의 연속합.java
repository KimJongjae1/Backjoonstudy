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
			 int[] temp=new int[N+1];
			 
			 for(int i=2;i<=N;i++) {
				 temp[i]=i;
			 }
			 int sq=(int)Math.sqrt(N);
			 for(int i=2;i<=sq;i++) {
				 if(temp[i]!=0) {
					 for(int k=i+i;k<=N;k+=i) {
						 temp[k]=0;
					 }
				 }
			 }
			 int idx=0;
			 for(int i=2;i<=N;i++) {
				 if(temp[i]!=0) {
					 prime[idx++]=temp[i];
				 }
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
