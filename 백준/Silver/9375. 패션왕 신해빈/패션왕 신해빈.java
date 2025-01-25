import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T=Integer.parseInt(br.readLine());
  
    for(int i=0;i<T;i++) {
    	int N=Integer.parseInt(br.readLine());
    	String[] temp = new String[N];
    	
    	for(int k=0;k<N;k++){
    		String str =br.readLine();
    		String[] tem = str.split(" ");
    		temp[k]=tem[1];
    	}
    	Arrays.sort(temp);
    	int count=0;
    	int[] cloth =new int[31];
    	for(int k=0;k<N-1;k++) {
    		if(temp[k].equals(temp[k+1])) {
    			cloth[count]++;
    		}else {
    			cloth[count]++;
    			count++;
    		}
    	}cloth[count]++;
    	//count==옷종류 cloth[count]--옷 종류별 갯수   1벌만 입을때 N
    	
       int ans=1;
    	for(int k=0;k<N;k++) {
    		ans*=(cloth[k]+1);
    	}
    	if(N==1) 
        System.out.println(1);
    	else {
    	System.out.println(ans-1);}
    }
 
 }  
}