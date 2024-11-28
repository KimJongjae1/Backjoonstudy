import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    
    int T=scan.nextInt();
    scan.nextLine();
    for(int i=0;i<T;i++) {
    	String s=scan.nextLine();
    	int ans=0;
    	int sum=0;
        for(int k=0;k<s.length();k++) {
           	if(s.charAt(k)=='O') {
        		sum++;
        		ans+=sum;
        	}else {sum=0;}		
        }
        System.out.println(ans);
    }
    
		
	}
}