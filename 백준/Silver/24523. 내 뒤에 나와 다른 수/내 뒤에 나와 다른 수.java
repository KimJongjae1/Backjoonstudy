import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();;
     	N=Integer.parseInt(st.nextToken());//나무 수


     	st=new StringTokenizer(br.readLine());
     	arr=new int[N+1];
     	for(int i=1;i<=N;i++) 
     		arr[i]=Integer.parseInt(st.nextToken());
     	
     	int[] ans=new int[N+1];
     	ans[N]=-1;
     	int idx=N;
     	int n=arr[N];
     	for(int i=N-1;i>=1;i--) {
     		 if(arr[i+1]!=arr[i]) {
     			 idx=i+1;
     			 n=arr[i+1];
    			 ans[i]=idx;
     		 }else {
     			 ans[i]=ans[i+1];
     		 }
 		
     	}
     	for(int i=1;i<=N;i++) {
     		sb.append(ans[i]+" ");
     	}
     	System.out.println(sb);
    }
}