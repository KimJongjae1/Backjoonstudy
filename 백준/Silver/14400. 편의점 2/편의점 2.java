import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
     	 N=Integer.parseInt(st.nextToken());
     	 int[] x=new int[N];
     	 int[] y=new int[N];
     	 for(int i=0;i<N;i++) {
     		st=new StringTokenizer(br.readLine());
     		x[i]=Integer.parseInt(st.nextToken());
     		y[i]=Integer.parseInt(st.nextToken());
     	 }
     	 
     	 Arrays.sort(x);
     	 Arrays.sort(y);
     	long X=half(x);
     	long Y=half(y);
     	System.out.println(X+Y);
    }
    public static long half(int[] a) {
    	
    	int s=N/2;
    	long dist=0;
    	for(int k=0;k<N;k++){
    		dist+=Math.abs(a[k]-a[s]);
    	}

    	return dist;
    }
}