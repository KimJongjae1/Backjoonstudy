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
	    int ret=0;
	    for(int i=500;i>=1;i--) {
	    	int cur=i*i+N;
	    	int sqrt=(int)Math.sqrt(cur);
	    	if(sqrt>500) continue;
	    	if(sqrt*sqrt==cur )ret++;
	    	
	    	
	    }
        System.out.println(ret);
        
    }
}