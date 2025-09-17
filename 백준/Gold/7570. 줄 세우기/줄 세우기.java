import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	N=Integer.parseInt(st.nextToken());

     	arr=new int[N];
     	int[] dp=new int[N+1];
     	 st=new StringTokenizer(br.readLine());
     	for(int i=0;i<N;i++) {
     		arr[i]=Integer.parseInt(st.nextToken());
     	}
     	int max=0;
     	for(int i=0;i<N;i++) {
     		dp[arr[i]]++;
     	  dp[arr[i]]+=dp[arr[i]-1];
     	  max=Math.max(max, dp[arr[i]]);
     	}
     	System.out.println(N-max);
     	
     	
    }
}