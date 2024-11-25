import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	
	int N=scan.nextInt();
	
	for(int i=0;i<N;i++) {
		for(int k=N-1;i<k;k--) {
			System.out.print(" ");
		}
		for(int q=0;q<=i;q++) {
			System.out.print("*");
		}System.out.print("\n");
	}
		
	}
}