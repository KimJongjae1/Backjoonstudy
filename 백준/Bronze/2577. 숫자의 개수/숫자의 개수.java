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
	char[] s = S.toCharArray();
	char[] ans=new char[10];
	Arrays.fill(ans,'0');
	
	for(int i=0;i<s.length;i++) {
		ans[s[i]-'0']++;
	}
	for(int i=0;i<10;i++) {
		System.out.println(ans[i]); 
	}
		
	
	}
}