import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int max =0;
    int num =0;
    for(int i=1;i<=9;i++) {
    	int a = scan.nextInt();
    	if(max<a) {
    		max=a;
    		num =i;
    	}
    }
    System.out.println(max);
    System.out.println(num);
		
		
		
	}
}