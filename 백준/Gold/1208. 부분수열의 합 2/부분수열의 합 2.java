import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
   static int N;
   static int M;
   static long[] arr;
   static List<Long> left;
   static List<Long> right;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
     	  N=Integer.parseInt(st.nextToken());
     	  M=Integer.parseInt(st.nextToken());
     	  
     	  arr=new long[N+1];
     	  
     	 st=new StringTokenizer(br.readLine());
     	 left=new ArrayList<>();
     	 right=new ArrayList<>();
     	  for(int i=0;i<N;i++) {
     		  arr[i]=Long.parseLong(st.nextToken());
     	  }
     	
     	  getSum(0,N/2,0,left,0);
     	  getSum(N/2,N,0,right,0);
     	  Collections.sort(right);
     	  
     	  long cnt=0;
     	  for(long a:left) 
     		  if(a==M)cnt++;
     	  
     	  left.add(0L);
     	 // System.out.println(left);
     	 // System.out.println(right);
     	  for(int i=0;i<left.size();i++) {
     		  long L=left.get(i);
     		  long n=M-L;
     		
     		 int min=lowerbound(n);
     		  int max=upperbound(n);
     		 // System.out.println(min+" "+max+" "+n);
     		  cnt+=max-min;
     		  
     	  }
     	  System.out.println(cnt);
     	  
     	  
    }
    public static void getSum(int r,int n,long s,List<Long> sum,int cnt) {
    	if(r==n) {
    		if(cnt>0)
    		sum.add(s);
    		return;
    	}
    	
    	getSum(r+1,n,s+arr[r],sum,cnt+1);
    	getSum(r+1,n,s,sum,cnt);
    	
    }
    
    public static int lowerbound(long t) {
    	int max=right.size();
    	int min=0;
    	while(min<max) {
    		int mid=(max+min)/2;
    		
    		if(right.get(mid)<t) {
    			min=mid+1;
    		}else {
    			max=mid;
    		}
    	}
    	return min;
    }
    
    public static int upperbound(long t) {
    	int max=right.size();
    	int min=0;
    	while(min<max) {
    		int mid=(max+min)/2;
    		
    		if(right.get(mid)<=t) {
    			min=mid+1;
    		}else {
    			max=mid;
    		}
    	}
    	return min;
    }
}