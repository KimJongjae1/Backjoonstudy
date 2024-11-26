import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    int T = scan.nextInt();
    int max=-10000000; int min=10000000;
    for(int i=0;i<T;i++) {
    	int K =scan.nextInt();
       
    	if(max<K) {
    		max=K;
    	}
        if (min>K) {
        	min=K;
        }
    }
		System.out.println(min+" "+max);
		
		
	}
}