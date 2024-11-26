import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	int A = scan.nextInt();
	int B = scan.nextInt();
	int C = scan.nextInt();
     
	System.out.println(A+B-C);
   

	String s ="";
	s+=A;
	s+=B;
	
	int D = Integer.parseInt(s);
    
	
	System.out.println(D-C);
	
	}
}