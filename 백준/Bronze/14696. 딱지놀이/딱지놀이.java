import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);

    int N=scan.nextInt();
    int[] a=new int[5];
    int[] b=new int[5];
    
    for(int i=0;i<N;i++) {
    	
    	int ta=scan.nextInt();  
    	
    	for(int k=0;k<ta;k++) {
    	   a[scan.nextInt()]++;
          }
    	
    	int tb=scan.nextInt();
    	
    	for(int q=0;q<tb;q++) {
    		b[scan.nextInt()]++;
    	}
    
    	for(int w=4;1<=w;w--) {
    		if(a[w]>b[w]) {
    			System.out.println("A");
    			break;
    		}else if(a[w]<b[w]) {
    			System.out.println("B");
    			break;
    		}else {
    			if(w==1) {System.out.println("D");
    			break;}
    			else{continue;}}
    	}
    	Arrays.fill(a,0);
    	Arrays.fill(b,0);
    }
    
   }
}