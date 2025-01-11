import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	
    public static void main(String[] args) throws IOException {
    	Scanner scan=new Scanner(System.in);
    	
    	
    	int N=scan.nextInt();
    	int p=0;
    	for(int i=0;i<N;i++) {
        	if(Math.pow(2, i)<=N&&Math.pow(2, i+1)>N) {
        		 p=i;
        		
        		break;
        	}
          }
    	int p2 = (N-(int)Math.pow(2, p));
    	if(p2==0)System.out.println((int)Math.pow(2, p));
    	else {
        System.out.println(2*p2);
    	}
    	
    	
        //  1    2   3  4  5   6   7    8     9      10   11  12    13    14 15   16    17 18
    	//  1    2   2  4   2   4   6   8     2      4     6   8     10   12  14  16    2   4  6 8                  
    	//       1      2               3                                          4
      }    
    } 