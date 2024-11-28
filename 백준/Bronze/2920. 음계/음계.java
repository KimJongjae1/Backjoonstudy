import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    int a[]=new int[8];
    Scanner scan = new Scanner(System.in);
    
    for(int i=0;i<8;i++) {  	
    	a[i] = scan.nextInt();
    }
    
    int sum=0;
    
    for(int i=0;i<7;i++) {
    	if(a[i]<a[i+1]) {
    		sum++;
    	}else if(a[i]>a[i+1]) sum--;	
    }
    
    
    if(sum==7) {System.out.print("ascending");}
    else if(sum==-7) {System.out.print("descending");}
	else {System.out.print("mixed");}
	
	}
}