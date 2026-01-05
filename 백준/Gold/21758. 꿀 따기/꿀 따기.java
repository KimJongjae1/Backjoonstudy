import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
   static int[] arr;
   static int[] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[] visit;
   static List<Integer>[] list;
   static Set<int[]> set;  
   static Queue<Integer> qu;
   static int[] sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
    
        arr=new int[N+1];
        sum=new int[N+1];
        st=new StringTokenizer(br.readLine());
        arr[1]=Integer.parseInt(st.nextToken());
        sum[1]=arr[1];
        for(int i=2;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        	sum[i]=sum[i-1]+arr[i];
        }
        FindMaxHoney();
        System.out.println(ans);
    }
    public static void FindMaxHoney() {
    	
    	
    	for(int bee2=2;bee2<=N-1;bee2++) {
    		ans=Math.max(ans, Math.max(Math.max(calculate(1,N,bee2), calculate(1,N,bee2)), calculate(1,N,bee2)));
    		ans=Math.max(ans, Math.max(Math.max(calculate(N,1,bee2), calculate(N,1,bee2)), calculate(N,1,bee2)));
    	}
    	
    	ans=Math.max(ans, Math.max(Math.max(calculate(N/2+1,1,2), calculate(N/2+1,N,N-1)), calculate(N/2+1,1,N)));
    	if(N/2==0)
    	ans=Math.max(ans, Math.max(Math.max(calculate(N/2,1,2), calculate(N/2,N,N-1)), calculate(N/2,1,N)));
    }
    public static int calculate(int house,int bee1,int bee2) {
    	int s=0;
    	if(bee1==house||house==bee2) return s;
    	
    	s+=IndividualCal(house,bee1)+IndividualCal(house,bee2)-arr[bee2];
    	
    	if(bee1<house&&house<bee2)s+=arr[bee2];
    //	System.out.println(s+" "+house+" "+bee1+" "+bee2);
    	return s;
    }
    public static int IndividualCal(int house ,int bee1) {
    	
    	if(house>bee1) {
    		return sum[house]-sum[bee1];
    	}else {
    		return sum[bee1-1]-sum[house-1];
    	
    	}
    }
}