import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a= scanner.nextInt();
		int b= scanner.nextInt();
		int c= scanner.nextInt();
		int d= scanner.nextInt();
		int e= scanner.nextInt();
		
		
		int x =a*a+b*b+c*c+d*d+e*e;
		System.out.printf("%d",x%10);
		
		
	}
}