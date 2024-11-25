import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
	
     Scanner scan = new Scanner(System.in);
     
     int N = scan.nextInt();
     scan.nextLine();
     
     String S = scan.nextLine();
     char[] s = S.toCharArray();
      
     int sum=0;
     for(int i=0;i<N;i++) {
    	 sum+=(s[i]-'0');
     }
		
		System.out.println(sum);

	}
}