import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static int[] a;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
        String str=st.nextToken();
     	//N=Integer.parseInt(st.nextToken());
        sb=new StringBuilder();
	     int ret=-1;
	     int end=str.length()-1;
	     int start=0;
	     while(start<end) {
	    	 if(str.charAt(start)!=str.charAt(end))break;
	    	 start++;
	    	 end--;
	     }
	     	if(start>=end) {
	     		boolean exist=true;
	     		for(int i=1;i<str.length();i++) {
	     			if(str.charAt(0)!=str.charAt(i)) {
	     				exist=false;
	     				break;
	     			}
	     			
	     		}
	     		if(!exist)
	     		System.out.println(str.length()-1);
	     		else System.out.println(-1);
	     	}else {
	     		System.out.println(str.length());
	     	}
    }
}