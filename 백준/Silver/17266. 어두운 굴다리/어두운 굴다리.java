import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static List<int[]>[] list;
   static int[] diy= {0,0,1,-1};
   static int[] dix= {1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(br.readLine());
        arr=new int[M];
        st=new StringTokenizer(br.readLine());
    	for(int i=0;i<M;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
        
       
        System.out.println(lowerbound());
        
        
    }
    public static int lowerbound() {
    	int max=N;
    	int min=1;
    	while(min<max) {
    		int mid=(max+min)/2;
    		
    		if(check(mid)) {
    			max=mid;
    		}else {
    			min=mid+1;
    		}
    	}
    	return min;
    }
    public static boolean check(int h) {
    	int prev=0;
    	for(int i=0;i<M;i++) {
    		if(arr[i]-h<=prev) {
    			prev=arr[i]+h;
    		}else break;
    	}
    	if(prev>=N)return true;
    	return false;
    	
    }
}