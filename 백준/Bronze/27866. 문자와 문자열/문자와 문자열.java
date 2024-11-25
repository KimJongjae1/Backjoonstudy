import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	
	String S  = scan.nextLine();
	int N = scan.nextInt();
	

	System.out.println(S.charAt(N-1));
		
	}
}