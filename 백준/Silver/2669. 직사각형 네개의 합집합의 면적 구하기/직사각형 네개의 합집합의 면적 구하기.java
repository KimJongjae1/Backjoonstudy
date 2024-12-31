import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    int[][] ans = new int[101][101];
    
    int realans=0;
    for(int i=0;i<4;i++) {
    	int a = scan.nextInt();//x
    	int b = scan.nextInt();//y
    	int c = scan.nextInt();//x
    	int d = scan.nextInt();//y
    	
        for(int k=a;k<c;k++) {
        	for(int q=b;q<d;q++) {
        		if(ans[k][q]==0){
        		   ans[k][q]++;
        		   realans++;
        		}
        	}
        }
    }
    
    System.out.println(realans);
    
   }
}