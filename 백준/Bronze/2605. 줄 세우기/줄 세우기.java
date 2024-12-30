import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    
    int N=scan.nextInt();
    int[] a =new int[N+1];
    int[] b =new int[N+1];
    for(int i=1;i<=N;i++) {
       a[i]=i;
    }
    
    for(int i=1;i<=N;i++) {
    	int num=scan.nextInt();
    	if(num!=0) {
    		int T=num;
    	   while(num>0) {
    		   b[i-num+1]=a[i-num];
    		   num--;
    	   }
    	   a[i-T]=a[i];
    	   while(T>0) {
    		   a[i-T+1]=b[i-T+1];
    		   T--;
    	   }
    	}
    }
    for(int i=1;i<=N;i++) {
    System.out.print(a[i]+" ");
    }
    		
   }
}