import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		int num2 = scanner.nextInt();
		if(num>num2) {
		System.out.println(">");}
		else if(num<num2) {
			System.out.println("<");
		}else {System.out.println("==");}

	}

}