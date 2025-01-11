import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	
    public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    
    int N =scan.nextInt();
    int[] A =new int[N];
    for(int i=0;i<N;i++) {
    	A[i]=scan.nextInt();
    }
    Arrays.sort(A);
    
    int N2=scan.nextInt();
    for(int i=0;i<N2;i++) {
    	 
    	
    	if(search(A,scan.nextInt())==1) {
    		sb.append(1).append('\n');
    	}
    	else  {sb.append(0).append('\n');}    	
    	
    }
     System.out.println(sb);
  }  
    
    public static int search(int[] a,int b) {//a=A  b=temp
    	
    	int min =0;
    	int max = a.length-1;
    	//5 2  6 2
    	
    	if(b>a[a.length-1]) return 0;
    	
    	while(min<=max) {//lo mid  l 
    		
    		int mid =(min+max)/2;
    		
    		if(b>a[mid]) {//1 3 7  8 11 - 5 mid 2 max 3 mid 1 min 2 mid 2 max 1 mid 2 
    			min=mid+1;
    		
    		}else if(b<a[mid]) {
    			max=mid-1;
    			
    		}
    		else if(b==a[mid]){return 1;}
    	}
    	return 0;
    }
}