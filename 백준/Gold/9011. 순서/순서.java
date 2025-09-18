import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        int T=Integer.parseInt(st.nextToken());       
        
        Loop:for(int t=0;t<T;t++) {
     	N=Integer.parseInt(br.readLine());
        sb=new StringBuilder();
	     	arr=new int[N];
	     	 st=new StringTokenizer(br.readLine());
	     	for(int i=0;i<N;i++) {
	     		arr[i]=Integer.parseInt(st.nextToken());
	     	}
	     	
	     	boolean[] visit=new boolean[N+1];
	     	int[] ans=new int[N];
	     	for(int i=N-1;i>=0;i--) {
	     		if(i<arr[i]) {
	     			System.out.println("IMPOSSIBLE");
	     			continue Loop;
	     		}
	     		
	     		int a=check(visit,arr[i]+1);

	     		if(a==-1) {
	     			System.out.println("IMPOSSIBLE");
	     			continue Loop;
     			}
	     
	     		
		     		visit[a]=true;
		     		ans[i]=a;
	     		
	     	}
	     	
	     	for(int i=0;i<N;i++) {
	     		sb.append(ans[i]+" ");
	     	}
	     	System.out.println(sb);
        }
    }

    public static int check(boolean[] visit,int I) {
    	int cnt=0;

    	for(int i=1;i<=N;i++) {
    		if(!visit[i])cnt++;
    		if(cnt==I) {
    			return i;
    		}
    	}
    	return -1;
    }
}