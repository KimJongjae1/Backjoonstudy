import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T=Integer.parseInt(br.readLine());
    int[] sumnum = new int[12];
	   sumnum[1]=1;
	   sumnum[2]=2;
	   sumnum[3]=4;
	   int[] number = new int[12];
	   int max=0;
 
    	for(int k=1;k<=T;k++) {
    		number[k]=Integer.parseInt(br.readLine());
    		if(max<number[k]) {
    			max=number[k];
    		}
         }
    
    	for(int i=4;i<=max;i++) {
    		sumnum[i]=sumnum[i-1]+sumnum[i-2]+sumnum[i-3];
    	}
    	
    	
    	for(int i=1;i<=T;i++) {
    		System.out.println(sumnum[number[i]]);
    	}
    
 }  
}