import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    static ArrayList<int[]> list = new ArrayList<>();
    static StringBuilder sb= new StringBuilder();
	static void hanoi(int n,int start,int to, int finish) {
		
		if(n==1) {
			list.add(new int[] {start,finish});
			return;
		}

		hanoi(n-1, start,finish,to);
		hanoi(1,start,to,finish);
		hanoi(n-1, to,start,finish);
		
	}
	
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	    
		int N=Integer.parseInt(br.readLine());
	    
	    BigInteger A = (new BigInteger("2")).pow(N).subtract(new BigInteger("1"));
	    System.out.println(A);
		if(N<=20) {
			hanoi(N,1,2,3);
	    for(int i=0;i<list.size();i++) {
	    	int[] temp=list.get(i);
	  
	    	System.out.println(temp[0]+" "+temp[1]);
	    	
	    }
		}
		
	}
  }