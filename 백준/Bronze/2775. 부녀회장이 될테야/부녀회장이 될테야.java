import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    int[][] A=new int[15][15];	
    for(int i=1;i<=14;i++) {
    	A[0][i]=i;
    }
    
    for(int i=1;i<=14;i++) {
    	int sum=0;
    	for(int k=1;k<=14;k++) {
    		sum+=A[i-1][k];
    		A[i][k]=sum;
    	}
    }
    
    int T=scan.nextInt();
    for(int i=0; i<T;i++) {
    	int k=scan.nextInt();
    	int n=scan.nextInt();
    System.out.println(A[k][n]);
    }
    // 1234 13610 1 4 10 20
	}
}