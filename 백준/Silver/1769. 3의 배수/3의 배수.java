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
      //StringTokenizer st=new StringTokenizer(br.readLine()) ;

        String str=br.readLine();
        int cnt=0;
        if(str.length()>1)cnt++;
        int sum=0;
        for(int i=0;i<str.length();i++) {
        	sum+=str.charAt(i)-'0';
        }
   
        
        while(sum/10>0) {
        	 int s=0;
        	 for(int i=0;i<10;i++) {
        		s+=sum%10;
        		sum/=10;
        		if(sum==0)break;
        	 }
        	 sum=s;
        	 cnt++;
        }
        System.out.println(cnt);
        if(sum%3==0) System.out.println("YES");
        else System.out.println("NO");
    }
}