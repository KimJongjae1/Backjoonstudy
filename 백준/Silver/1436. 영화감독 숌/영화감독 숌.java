import java.util.*;
import java.io.*;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    int N = scan.nextInt();
    int ans =0;
    int i=665;
    for(;;) {
    	i++;
    	int cnt=0;//666을 확인하는
    	int temp= i;
    	
    	while(temp>0) {
    		if(temp%10!=6) {
    			cnt=0;
    			temp/=10;
    		}else {
    			temp/=10;
    			cnt++;
    		}
    		if(cnt>=3) {
    		ans++;	
          	break;  
            }
    	}
     if(ans==N) {
      System.out.println(i);
      break;
     }
  	
    	
    }

   }
}