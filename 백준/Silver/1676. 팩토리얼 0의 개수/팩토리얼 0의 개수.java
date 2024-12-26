import java.util.*;
import java.io.*;
public class Main {
	

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    
    int N=scan.nextInt();
    int count =0;
    
    if(N==0) {System.out.println(0);}
    else {//100=== 20+1  5 25 125 
    	count += (N/5+N/25+N/125);
    	System.out.println(count);
    }	
    
   }
}