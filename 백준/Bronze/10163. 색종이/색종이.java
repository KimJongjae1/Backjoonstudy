import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    int[][] ans = new int[1001][1001];
    
    int N = scan.nextInt();
    int[] realans = new int[N+1];
    
    for(int i=1;i<=N;i++) {
    	int a = scan.nextInt();//x
    	int b = scan.nextInt();//y
    	int c = scan.nextInt();//x
    	int d = scan.nextInt();//y
    	
        for(int k=a;k<(a+c);k++) {
        	for(int q=b;q<(b+d);q++) {
        		if(ans[k][q]==0) {
        		   ans[k][q]=i;
        		   realans[i]++;
        		}else { 
        			realans[ans[k][q]]--;
        			ans[k][q]=i;
        			realans[i]++;
        		}
        	}
        }
    
    }
    
    for(int i=1;i<=N;i++) {
    	System.out.println(realans[i]);
    	
        }
   }
}