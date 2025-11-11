import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
 
   static int[] diy= {0,0,1,-1};
   static int[] dix= {1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        String[] str=new String[N];
        List<Integer> list=new ArrayList<>();
        arr=new int[N];
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	String s=st.nextToken();
        	int n=Integer.parseInt(st.nextToken());
        	
    
        	arr[i]=n;
        	str[i]=s;
        	
        }
        
        for(int i=0;i<M;i++) {
        	int power=Integer.parseInt(br.readLine());
        	int key=lowerbound(power);
        	
        	sb.append(str[key]+"\n");
        }
        
    	System.out.println(sb);
    }
    public static int lowerbound(int t) {
    	int max=N-1;
    	int min=0;
    	while(min<max) {
    		int mid=(max+min)/2;
    		
    		if(arr[mid]<t) {
    			min=mid+1;
    		}else {
    			max=mid;
    		}
    	}
    	return min;
    }
}