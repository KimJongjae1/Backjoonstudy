import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    
    int[] h = new int[9];
    int sum9 =0;
    for(int i=0;i<9;i++) {
    	h[i]=scan.nextInt();
    	sum9 += h[i];
    }
    Arrays.sort(h);
    int a=0;
    int b=0;
    for(int i=0;i<9;i++) {
       int sum7 =0;
       for(int k=i+1;k<9;k++) {
    	   sum7=(sum9-h[i]-h[k]);
    	   if(sum7==100) {
    		   a=i; b=k;
    		   break;
    	   }
       }
    }
    
    for(int i=0;i<9;i++) {
    	if(i==a || i==b) {
    		continue;
    	}else {System.out.println(h[i]);}
    }
    
		
		
   }
}