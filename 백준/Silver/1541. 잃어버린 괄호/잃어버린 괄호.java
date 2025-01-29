import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    StringTokenizer st = new StringTokenizer(br.readLine(),"-+",true);
    int ans=0;
    
    
    int N=Integer.parseInt(st.nextToken());
    char sign;
    int count=0;
    int minuscount=0;
	ans+=N;
 
    while(st.hasMoreElements()) {
    	
    	sign=st.nextToken().charAt(0);
   
    	count++;
    	N=Integer.parseInt(st.nextToken());
    	count++;

    	if(minuscount==0&&sign=='+'){
    		ans+=N;
    	}
    	else if(sign=='-') {
    		minuscount++;
    		ans-=N;
    	}else {
    		ans-=N;
    	}
    	
    	

    	
    }
  System.out.println(ans);
    
 }  
}