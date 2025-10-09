import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


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
     	arr=new int[N+2];
     	arr[0]=100000;
     	arr[N+1]=100000;
     	int min=1000000;
     	int[] sum1=new int[N/2+1];
     	int[] sum2=new int[N/2+1];
     	st=new StringTokenizer(br.readLine());
     	for(int i=1;i<=N;i++) {
     		int n=Integer.parseInt(st.nextToken());
     		arr[i]=n;
     		if(i%2==1) {

     			sum1[i/2+1]+=sum1[i/2]+n;//1 2 3 4 
     		}
     		else
     		sum2[i/2]+=sum2[i/2-1]+n;// 1 2 3 4 
     	}
     	int max=sum1[N/2];
     	for(int i=1;i<=N/2;i++) {
     		max=Math.max(max,sum1[i]+sum2[N/2-1]-sum2[i-1]);
     		max=Math.max(max, sum2[N/2]-sum2[i-1]+sum1[i-1]);
     	}
     
     	System.out.println(max);
    }
    
}