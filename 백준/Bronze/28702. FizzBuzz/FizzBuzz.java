import java.util.*;
import java.io.*;
public class Main {
	

	public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String[] a = new String [4];
    char[][] b = new char [3][10];
    int x=0;
    
    for(int i=0;i<3;i++) {
        a[i]=br.readLine();
        b[i]=a[i].toCharArray();
        if((int)b[i][0]-'0'<=9) {
        	x=i;
        }
     }
	
    int num =Integer.parseInt(a[x]);// x=0 ---1 +3 x=1 ---2 +2 3-x
    num =num+(3-x);
    
    if(num%3==0&&num%5!=0) {
    	System.out.println("Fizz");
    }else if(num%3!=0&&num%5==0) {
    	System.out.println("Buzz");
    }else if(num%3==0&&num%5==0) {
    	System.out.println("FizzBuzz");
    }
    else {System.out.println(num);}
    
    
	}
}