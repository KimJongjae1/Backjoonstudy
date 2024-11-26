import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    int H = scan.nextInt();		
    int M = scan.nextInt();		
	
    if((M-45)>=0) {
    	System.out.println(H+" "+(M-45));
    }else if(M-45<0) {
    	if(H>=1)
    	System.out.println((H-1)+" "+(M+15));
    	else if(H==0)
    		System.out.println(23+" "+(M+15));
    }
    
		
	}
}