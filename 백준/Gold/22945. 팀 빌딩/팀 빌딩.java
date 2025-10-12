import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
     		arr[i]=Integer.parseInt(st.nextToken());
     		
     	}

     	long max=0;
     	int left=0;
     	int right=N-1;
     	while(right-left>=2) {
     		long n=Math.min(arr[right],arr[left]);
     		max=Math.max(max, n*(right-left-1));
     		
     		if(arr[left]<=arr[right]) {
     			left++;
     		}else  {
     			right--;
     		}
     	}
     	System.out.println(max);
    }
}