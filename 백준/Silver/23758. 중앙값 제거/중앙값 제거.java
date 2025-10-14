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
     	arr=new int[N];
     	for(int i=0;i<N;i++) 
     		arr[i]=Integer.parseInt(st.nextToken());
     	
     	Arrays.sort(arr);
   		
   		int n=N/2;
   		

   		int cnt=1;
   		if(N%2==0)n--;
   		for(int i=0;i<=n;i++) {
   			for(int k=30;k>=0;k--) {
   				if((arr[i]&(1<<k))>0) {

   					cnt+=k;
   					break;
   				}
   			}
   		}
   

     	System.out.println(cnt);
     	
    }
}