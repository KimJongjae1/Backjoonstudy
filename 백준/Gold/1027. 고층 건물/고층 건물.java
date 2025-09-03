import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
   static int N;
   static int M;
   static int[] arr;

 static   StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
     	  N=Integer.parseInt(st.nextToken());
     	 arr=new int[N];
     	st=new StringTokenizer(br.readLine());
     	 for(int i=0;i<N;i++) {
     		 arr[i]=Integer.parseInt(st.nextToken());
     	 }
     	 int ret=0;
     	  for(int i=0;i<N;i++) {
     		  int a=check(i);
     		  ret=Math.max(a,ret);
     		
     	  }
     	  System.out.println(ret);
    }
    public static int check(int s) {
    	int ret=0;
    	double slide=Integer.MAX_VALUE;
    	for(int i=s-1;i>=0;i--) {
    		double sli=(double)(arr[s]-arr[i])/(double)(s-i);
    		if(sli<slide) {
    			slide=sli;
    			ret++;
    		}
    	}
    	
    	slide=Integer.MAX_VALUE;
    	for(int i=s+1;i<N;i++) {
    		double sli=(double)(arr[s]-arr[i])/(double)(i-s);
    		if(sli<slide) {
    			slide=sli;
    			ret++;
    		}
    	}
    	return ret;
    }
}