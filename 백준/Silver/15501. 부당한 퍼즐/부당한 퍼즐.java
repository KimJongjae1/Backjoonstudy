import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static int[] a;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();

     	N=Integer.parseInt(st.nextToken());
        sb=new StringBuilder();
	     	arr=new int[N];
	     	a=new int[N+2];
	     	 st=new StringTokenizer(br.readLine());
	       	 Map<Integer,Integer> map=new HashMap<>();
	     	 for(int i=1;i<=N;i++) {
	       		a[i]=Integer.parseInt(st.nextToken());
	       		map.put(a[i],i);
	     	 }
	    	 st=new StringTokenizer(br.readLine());
	 
	     	for(int i=0;i<N;i++) {
	     		arr[i]=Integer.parseInt(st.nextToken());
	     	}
	     	a[0]=a[N];
	     	a[N+1]=a[1];
	     	
	     	for(int i=0;i<N-1;i++) {
	     		int idx=map.get(arr[i]);
	     		int before=a[idx-1];
	     		int after=a[idx+1];
	     		if(i==0) {
	     			if(before==arr[N-1]&&after==arr[i+1])continue;
	     			if(before==arr[i+1]&&after==arr[N-1])continue;	
	     		}else {
	     			if(before==arr[i-1]&&after==arr[i+1])continue;
	     			if(before==arr[i+1]&&after==arr[i-1])continue;	
	     		}
	     		System.out.println("bad puzzle");
	     		return;
	     	}
	     	
	     	System.out.println("good puzzle");
	     	
    }
}