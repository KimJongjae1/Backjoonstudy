import java.io.BufferedReader;
import java.io.InputStreamReader;
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
     	int T=Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++) {
	        N=Integer.parseInt(br.readLine());
	     	
	     	String[] str=new String[N]; 
	     	st=new StringTokenizer(br.readLine());
	     	for(int i=0;i<N;i++)
	     		str[i]=st.nextToken();
	     	
	     	if(N>=33) 
	     		System.out.println(0);

	     	else {
	     	
		     	int ans=12;
		     	for(int i=0;i<N-2;i++) {
		     		for(int k=i+1;k<N-1;k++) {
		     			for(int q=k+1;q<N;q++) {
		     				ans=Math.min(ans,check(str[i],str[k])+check(str[k],str[q])+check(str[i],str[q]));
		     			}
		     		}
		     	}
		     	System.out.println(ans);
		     }
        }
    	
    }
    public static int check(String a,String b) {
    	int cnt=0;
    	for(int i=0;i<4;i++) {
    		if(a.charAt(i)!=b.charAt(i))
    			cnt++;
    	}
    	return cnt;
    }
}