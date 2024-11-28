import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    int [] num=new int[42];
    int [] a=new int[10];
    Scanner scan=new Scanner(System.in);
    
    Arrays.fill(num,0);
    int ans=0;
    for(int i=0;i<10;i++) {
    	a[i]=scan.nextInt();
    	scan.nextLine();
    	a[i]%=42;
    	num[a[i]]++;
    	if(num[a[i]]==1) {
    		ans++;
    	}
    }
   
    System.out.print(ans);
		
		
	}
}