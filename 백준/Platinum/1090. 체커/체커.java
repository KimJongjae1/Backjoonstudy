import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static  List<int[]> chain;
   static  List<int[]> sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
     	 N=Integer.parseInt(st.nextToken());
     	 int[] x=new int[N];
     	 int[] y=new int[N];
     	
     	arr=new int[N];
     	 for(int i=0;i<N;i++) {
     		st=new StringTokenizer(br.readLine());
     		 x[i]=Integer.parseInt(st.nextToken());
     		 y[i]=Integer.parseInt(st.nextToken());
     		 arr[i]=Integer.MAX_VALUE;
     	 }
     	 
     	 for(int i=0;i<N;i++) {
     		 for(int k=0;k<N;k++) {
     			 int[] cost=new int[N];
     			 
     			 for(int q=0;q<N;q++) {
     				 cost[q]=Math.abs(x[i]-x[q])+Math.abs(y[k]-y[q]);
     			 }
     			 Arrays.sort(cost);
     			 int c=0;
     			 for(int q=0;q<N;q++) {
     				 c+=cost[q];
     				 arr[q]=Math.min(c, arr[q]);
     			 }
     		 }
     	 }
     	 
     	 for(int i=0;i<N;i++) {
     		 sb.append(arr[i]+" ");
     	 }
     	
     	 System.out.println(sb);
    }
   
    
    
}