import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	

	static int[] ans;
	public static int dps(int a) {
		int square = (int)Math.sqrt(a);//25  square = 5
	
		int mincount=5;
		for(int i=square;i>=1 ;i--) {
			int temp =a;
			int count=0;
			temp=temp-(int)Math.pow(i,2);
			
			count++;
			count+=ans[temp];
			if(mincount>count) {
				mincount=count;
			}
		}
		return mincount;
	}
	
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    int N=Integer.parseInt(br.readLine());
    
    ans= new int[N+4];
    ans[1]=1;
    ans[2]=2;
    ans[3]=3;
    for(int i=4;i<=N;i++) {
    	ans[i]=dps(i);
    }
    
  
    System.out.println(ans[N]);
    
 }  
}