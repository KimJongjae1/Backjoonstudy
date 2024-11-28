import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] al=new int[26];
    Arrays.fill(al, -1);
    
    String s = scan.nextLine();
    
    for(int i=0;i<s.length();i++) {
    	int temp = (s.charAt(i)-'a');
    	if(al[temp]==-1)
    	al[temp]=i;
    }
    for(int i=0;i<26;i++) {
    	System.out.print(al[i]);
    	if(i<25)
    	System.out.print(" ");
    }
		
	}
}