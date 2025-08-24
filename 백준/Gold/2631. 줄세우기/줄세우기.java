import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	static int N;
    static int M;
    static int[] arr;
    static int[] temp;
    static int[] lis;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
        arr=new int[N+1];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        
        int idx=0;
        lis=new int[N+1];
        temp=new int[N+1];
        for(int i=0;i<N;i++) {
        	int ridx=lowerbound(idx,arr[i]);
        	
        	if(idx==ridx) idx++;
        	lis[ridx]=arr[i];
        	temp[i]=ridx;
        }
        
        System.out.println(N-idx);
    	
    }
  public static int lowerbound(int idx,int n) {
	  int min=0;
	  int max=idx;
	  while(min<max) {
		  int mid=(max+min)/2;
		  
		  if(lis[mid]<n) {
			  min=mid+1;
		  }else {
			  max=mid;
		  }
	  }
	  return min;
  }
}