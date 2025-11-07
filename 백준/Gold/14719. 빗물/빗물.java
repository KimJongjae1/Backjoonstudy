import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static char[] carr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
      
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[M];
        st=new StringTokenizer(br.readLine());
      
        for(int i=0;i<M;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
       int ans=0;
       for(int i=1;i<M-1;i++) {
    	    int leftmax=0;
            int rightmax=0;
            
            for(int k=0;k<=i-1;k++)
            	leftmax=Math.max(leftmax,arr[k]);
            
            for(int k=i+1;k<M;k++)
            	rightmax=Math.max(rightmax,arr[k]);
    	   
            int H=Math.min(leftmax, rightmax);

            if(H>arr[i])
            ans+=H-arr[i];
       }
        System.out.println(ans);
    }
}