import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       // StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	// N=Integer.parseInt(st.nextToken());
     	 
     	 String str=br.readLine();
     	 int cnt=str.length();
     	 while(true) {
     		int idx=0;
     		int len=cnt-1;
     		 while(idx<len) {
     			 if(len>=str.length()) {
     				 len--;
     				 idx++;
     				 continue;
     			 }
     			 if(str.charAt(idx)!=str.charAt(len)) break;
     			 len--;
 				 idx++;
     		 }
     		 if(idx>=len) {
     			 System.out.println(cnt);
     			 break;
     		 }
     		 cnt++;
     	 }
     	
    }

}