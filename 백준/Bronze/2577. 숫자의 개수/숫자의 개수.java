import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    int A=scan.nextInt();
    int B=scan.nextInt();
    int C=scan.nextInt();
		
	int x=A*B*C;
	
	String S = Integer.toString(x);
	
	for(int i=0;i<10;i++) {
		int count =0;
		for(int k=0;k<S.length();k++) {
			if((S.charAt(k)-'0')== i) {
				count++;
			}
		}System.out.println(count);
	}
	
	
	}
}