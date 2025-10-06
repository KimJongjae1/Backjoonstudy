import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static long[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	N=Integer.parseInt(st.nextToken());
     	arr=new long[N];
     	st=new StringTokenizer(br.readLine());
     	for(int i=0;i<N;i++) {
     		arr[i]=Long.parseLong(st.nextToken());
     	}
     	long speed=arr[N-1];
     		for(int i=N-2;i>=0;i--) {
     			long n=speed%arr[i];
     			if(n!=0) speed+=arr[i]-n;
     			
     		}
     		System.out.println(speed);
    }
    
}