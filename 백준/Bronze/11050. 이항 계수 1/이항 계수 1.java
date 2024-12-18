import java.util.*;
import java.io.*;
public class Main {
	

	public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(System.in);
	
    
    int N = scan.nextInt();
    int K = scan.nextInt();
  
	int X=1;
	int Y=1;
    for(int i=0;i<K;i++) {
    	X *= (N-i);	
    }
    for(int i=0;i<K;i++) {
    	Y *= (K-i);	
    }
     
    System.out.println(X/Y);
    
	}
}