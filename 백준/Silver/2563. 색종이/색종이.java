import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);

    int[][] ans = new int[100][100];
    int realans=0;
    int N = scan.nextInt();
    
    for(int i=0;i<N;i++) {
    	int x = scan.nextInt();
    	int y = scan.nextInt();
    	
    	for(int k=x;k<x+10;k++) {
    		for(int q=y;q<y+10;q++) {
    			if(ans[k][q]==0) {
    				ans[k][q]++;
    				realans++;
    			}
    		}
    	}
    	
    }
    
    System.out.println(realans);
    
   }
}