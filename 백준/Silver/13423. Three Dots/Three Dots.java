import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

   static int N;
   static int M;
   static  StringBuilder sb;
   static Integer[] arr;
   static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int T=Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++) {
	        sb=new StringBuilder();
	     	N=Integer.parseInt(br.readLine());
	     	
	     	arr=new Integer[N];
	     	Set<Integer> set=new HashSet<>();
	     	st=new StringTokenizer(br.readLine());
	     	for(int i=0;i<N;i++) {
	     		arr[i]=Integer.parseInt(st.nextToken());
	     		set.add(arr[i]);
	     	}
	     	
	     	Arrays.sort(arr);
	     	int ans=0;
	     	for(int i=1;i<N/2;i++) {
	     		for(int k=0;k<i;k++) {
	     			int dist=arr[i]-arr[k];
	     			if(set.contains(arr[i]+dist))
	     				ans++;
	     		}
	     	}
	     	
	     	for(int i=N/2;i<N-1;i++) {
	     		for(int k=N-1;k>i;k--) {
	     			int dist=arr[k]-arr[i];
	     			if(set.contains(arr[i]-dist))
	     				ans++;
	     			
	     		}
	     	}
	     	System.out.println(ans);
        }
    }
}