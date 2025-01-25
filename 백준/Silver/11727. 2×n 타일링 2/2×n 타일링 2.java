import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    int N=Integer.parseInt(br.readLine());
    
    int[] method = new int[N+2];
    method[1]=1;//1
    method[2]=3;//1+1 2
    for(int i=3;i<=N;i++) {
    	method[i]=(method[i-1]+method[i-2]*2)%10007;
    }
    System.out.println(method[N]);
    
 }  
}