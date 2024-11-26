import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    int T= scan.nextInt();
    
    
    for(int i=0;i<T;i++) {
    	int H=scan.nextInt();//6 12 10  402 
    	int W=scan.nextInt();
    	int N=scan.nextInt();
    	
    	
    	int x = N/H+1;// 10/6   1 호수   2
    	int y = N%H;//10% 6 4 층수      0 
    	
    	if(y==0) {
    		System.out.println(H*100+x-1);
    		}
    	else {System.out.println(y*100+x);}
    	
    	
     }

	}
}