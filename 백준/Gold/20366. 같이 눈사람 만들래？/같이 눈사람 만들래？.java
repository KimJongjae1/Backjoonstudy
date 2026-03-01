import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int[][] dp;
     static int[] arr;
     static int ans;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

         StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         st=new StringTokenizer(br.readLine());
         arr=new int[N];
         for(int i=0;i<N;i++) {
        	 arr[i]=Integer.parseInt(st.nextToken());
         }
         Arrays.sort(arr);
         ans=Integer.MAX_VALUE;
         for(int i=0;i<N;i++) {
        	 for(int k=i+3;k<N;k++) {
        		 int left=i+1;
        		 int right=k-1;
        		 int Tall=arr[i]+arr[k];
        		 while(left<right) {
        			 int sh=arr[left]+arr[right];
        			 ans=Math.min(ans, Math.abs(sh-Tall));
        			 if(sh<Tall) {
        				 left++;
        			 }else if(sh>=Tall) {
        				 right--;
        			 }
        		 }
        	 }
         }
        System.out.println(ans);
    }
}