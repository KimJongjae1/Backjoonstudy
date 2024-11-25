import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 
	 int N = scanner.nextInt();
	 
	 if(N%4==0 &&N%100!=0||N%400==0) {
		 System.out.println("1");
	 }else {System.out.println("0");}
		
	}
}