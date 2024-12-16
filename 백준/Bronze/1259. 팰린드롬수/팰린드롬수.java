import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    for(;;) {
    	String A=scan.nextLine();
    	if( A.equals("0")) {break;}
    	
    	char[] S=A.toCharArray();
    	int count =0;
    	for(int i=0;i<S.length;i++) {
    		if(S[i]==S[S.length-1-i])// 121  0배열==2배열 1배열==1배열 2배열==0배열
    			count++;
    	}
    	if(count==S.length) {
    		System.out.println("yes");
    	}else {System.out.println("no");}
      }
		
		
	}
}