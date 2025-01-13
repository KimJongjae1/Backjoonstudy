import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int N =Integer.parseInt(br.readLine());
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
   
    for(int i=0;i<N;i++) {
    	arr[i]=Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(arr);
    //-10 -10 2 3 3 6 7 10 10 10
  
    
    
    int M=Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    
    for(int i=0;i<M;i++) {
    	int temp = Integer.parseInt(st.nextToken());
    	int num= upper(arr,temp)-down(arr,temp);  	
    	if(num>=0) {
    	   	sb.append(num).append(" ");
    }else {sb.append(0).append(" ");} 
    }System.out.print(sb);
 }  
    public static int upper(int[] a,int b) {
    	 
    	int min = 0;
    	int max = a.length;
    	
    	while(min<max) {
    		 int mid=(max+min)/2;
    		
    		if(b>=a[mid]) {
    			min=mid+1;
    		}
    		else if(b<a[mid]) {
    			max=mid;
    		}
             }return min;
    		
    	}
    
    public static int down(int[] a,int b) {
   	 
    	int min = 0;
    	int max = a.length;
    	
    	while(min<max) {
    		 int mid=(max+min)/2;
    		
    		if(b>a[mid]) {
    			min=mid+1;
    		}
    		else if(b<=a[mid]) {
    			max=mid;
    		}
             }return min;
    		
    	}
    
    }