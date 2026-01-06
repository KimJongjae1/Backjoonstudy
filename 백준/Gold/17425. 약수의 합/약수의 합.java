import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static  StringBuilder sb;
   static long[] arr;
   static int[] dp;
   static long[] sum;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[] visit;
   static List<Integer>[] list;
   static Set<int[]> set;  
   static Queue<Integer> qu;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
    

       int MAX=0;
       int[] temp=new int[N];
        for(int i=0;i<N;i++) {
        	int n=Integer.parseInt(br.readLine());
        	temp[i]=n;
        	MAX=Math.max(n, MAX);
        }

        arr=new long[MAX+1];
        cal(MAX);
        for(int i=0;i<N;i++) {
        	sb.append(sum[temp[i]]+"\n");
        }

        System.out.println(sb);
        
        
    }
    public static void cal(int max) {

    	arr[1]=1;
    	sum=new long[max+1];
    for(int n=2;n<=max;n++) {
    	arr[n]++;
    	for(int i=1;i*n<=max;i++) {
    		arr[i*n]+=n;
    	}

    }
    
    for(int i=1;i<=max;i++) {
    	sum[i]=sum[i-1]+arr[i];
    }

    }
}