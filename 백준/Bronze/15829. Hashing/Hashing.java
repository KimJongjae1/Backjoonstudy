import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    
    int N=scan.nextInt();
    scan.nextLine();
    
    String s=scan.nextLine();
	char[] a=s.toCharArray();
	long[] ina = new long[a.length];
	for(int i=0;i<a.length;i++) {
		ina[i]= (long)(a[i]-'a'+1);
	}
	
	long R=1;
	long M=1234567891;
	long sum=0;
	for(int i=0;i<a.length;i++) {
		ina[i]=(ina[i]*(R%M));
		R*=31;
		sum+=ina[i];
	}
    System.out.println(sum%M);
		
	}
}