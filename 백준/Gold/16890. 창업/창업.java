import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int T;
   static int idx;
   static int max;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<Integer> list;
   static TreeSet<Integer> set;  
   static TreeMap<Integer,Integer> map;
   static int first;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	
        String a=br.readLine();
        String b=br.readLine();
        char[] A=a.toCharArray();
        char[] B=b.toCharArray();
        
        Arrays.sort(A);
        Arrays.sort(B);
        int N=a.length();

        int AS=0;int AE=(N+1)/2-1;
        int BE=AE+1;int BS=N-1;
        
         char[] ans=new char[N];
       
         int Back=N-1;
         int First=0;
        for(int i=0;i<N;i++){
           if(i%2==0) {
	        	if(A[AS]>=B[BS]) {
	        		ans[Back--]=A[AE--];
	        	}else {
	        		ans[First++]=A[AS++];
	        	}
           }else {
        	   if(A[AS]>=B[BS]) {
        		   ans[Back--]=B[BE++];
	        		
	        	}else {
	        		
	        		 ans[First++]=B[BS--];
	        	}
           }
        	
        }
        
        for(int i=0;i<N;i++){
            sb.append(ans[i]);
        }
        System.out.println(sb);
        
	   
    }
}