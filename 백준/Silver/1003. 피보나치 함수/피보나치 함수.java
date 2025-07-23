import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    int N=Integer.parseInt(br.readLine());
	    
       
	    int max=0;
	    int[] num = new int[N+2];
	    num[0]=0;
	    for(int i=0;i<N;i++) {
	    	int temp =Integer.parseInt(br.readLine());
	        if(max<temp) {
	        	max=temp;
	        }
	        num[i]=temp;
	    }
	    int[][] fibonacci = new int[max+2][2];
	    fibonacci[0][0]=1; fibonacci[0][1]=0;
	    fibonacci[1][0]=0; fibonacci[1][1]=1;
	   
        for(int i=2;i<=max;i++) {
        	fibonacci[i][0]=fibonacci[i-1][0]+fibonacci[i-2][0];
        	fibonacci[i][1]=fibonacci[i-1][1]+fibonacci[i-2][1];
        }
	    for(int i=0;i<N;i++) {
	    	System.out.println(fibonacci[num[i]][0]+" "+fibonacci[num[i]][1]);
	    }
	  
	   }
  	
}
	    
	
//  10
//  01
//    11  
//  12
//  23
//  35
//  58