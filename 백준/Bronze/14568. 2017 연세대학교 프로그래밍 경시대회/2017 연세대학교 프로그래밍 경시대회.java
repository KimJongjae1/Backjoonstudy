import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
	static int N;
	static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
	    int cnt=0;
	    for(int i=1;i<=98;i++) {
	    	for(int k=i+2;k<=100;k++) {
	        	int n=N;
	    		n-=i+k;
	    		if(n>0) {
	    			if(n%2==0)cnt++;
	    		}else break;
	    	}
	    }
        
        System.out.println(cnt);
        
    }
}