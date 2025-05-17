import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static long[] arr;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		   StringBuilder sb=new StringBuilder();
		   StringTokenizer st=new StringTokenizer(br.readLine());
		   N =Integer.parseInt(st.nextToken());
		    K =Integer.parseInt(st.nextToken());
		   
		    arr=new long[N];
		   for(int i=0;i<N;i++) {
			   arr[i]=Long.parseLong(br.readLine());
		   }
		   
		   System.out.println(lowerbound());
		   
		   
    }
	 public static long lowerbound() {
		 long max=Long.MAX_VALUE;
		 long min=0;
		 
		 while(min<max) {
			 long mid=(max+min)/2;
			 
			 if(check(mid)<K) {//k가 기준점 check이 나온값
				 min=mid+1;
			 }else {
				 max=mid;
			 } 
			 
		 }
		 
		 return min;
		 
	 }
   public static long check(long mid) {
	   long sum=0;
	   for(int i=0;i<N;i++) {
		   sum+=mid/arr[i];
		   if(sum>K)break;
	   }
	   return sum;
   }
	 
}