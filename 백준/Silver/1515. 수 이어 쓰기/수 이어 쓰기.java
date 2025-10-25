import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
       // N=Integer.parseInt(st.nextToken());

        String str=st.nextToken();
        int base=1;
        int idx=0;
        
       Loop: while(base<=30000) {
        	String temp=String.valueOf(base);
        	
        	for(int i=0;i<temp.length();i++) {
        		if(temp.charAt(i)==str.charAt(idx))
        			idx++;
        		if(idx==str.length())break Loop;
        	}
        
        	base++;
        }
        System.out.println(base);
        
    	
    	
    }
}