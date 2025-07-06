import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static Integer N;
    public static long[] tree;
    public static long[] arr;
    public static  StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        
        arr=new long[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
       tree=new long[4*N];
       init(1,N,1);
       sb=new StringBuilder();
       for(int i=0;i<M;i++) {
    	   st=new StringTokenizer(br.readLine());
    	   int x=Integer.parseInt(st.nextToken());
    	   int y=Integer.parseInt(st.nextToken());
    	   if(x>y) {
    		   int temp=y;
    		   y=x; 
    		   x=temp;
    	   }
    	   sb.append(sumprint(1,N,1,x,y)).append("\n");
    	   
    	   int a=Integer.parseInt(st.nextToken());
    	   int b=Integer.parseInt(st.nextToken());
    	   change(1,N,1,b-arr[a],a);
    	   arr[a]=b;
       }
       
        
        System.out.println(sb);
    	 
    		 
     }
     public static long init(int start,int end,int idx) {
    	 if(start==end)
    		 return tree[idx]=arr[start];
    	 
    	 int mid=(start+end)/2;
    	 
    	return tree[idx]=init(start,mid,2*idx)+init(mid+1,end,2*idx+1);
    	 
     }
     public static void change(int start,int end,int idx,long diff,int diffidx) {
    	 if(diffidx<start||end<diffidx) return;
    	 
    	 tree[idx]+=diff;
    	 if(start==end)return;
    	 int mid=(start+end)/2;
    	 change(start,mid,idx*2,diff,diffidx);
    	 change(mid+1,end,idx*2+1,diff,diffidx);
    	 
     }
     public static long sumprint(int start,int end,int idx,int ts,int te) {
    	 if(end<ts||te<start) return 0;
    	 
    	 if(ts<=start&&end<=te) {
    		 return tree[idx];
    	 }
    	 int mid=(start+end)/2;
    	 
    	 return sumprint(start,mid,2*idx,ts,te)+sumprint(mid+1,end,2*idx+1,ts,te); 
    	 
     }
     
}
