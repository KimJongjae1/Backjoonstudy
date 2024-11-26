import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    String s = scan.nextLine();
    char[] a = s.toCharArray();
    int count=0;
    if(a[0]==' ') {
		count--;
	}	
    if(a[a.length-1]==' ') {
    	count--;
    }	
    for(int i=0;i<a.length;i++) {
    	if(a[i]==' ') {
    		count++;
    	}
    }
    System.out.println(count+1);
		
	}
}