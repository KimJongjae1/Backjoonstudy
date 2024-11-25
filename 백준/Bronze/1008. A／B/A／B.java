import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double num = scanner.nextInt();
		double num2 = scanner.nextInt();
		System.out.printf("%.10f",num/num2);

	}

}