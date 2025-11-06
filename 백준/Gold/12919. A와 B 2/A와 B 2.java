import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static char[][] carr;
   static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       // StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
       String s1=br.readLine();
       String s2=br.readLine();
      sb.append(s2);
      canMake(s1,s2);
      if(!flag)System.out.println(0);
      
       
       
    }

    public static void canMake(String s1,String s2) {
    	  if(flag) return;
    	  if(s1.length()==s2.length()) {
    		  if(answer(s1,s2)) {
    			  System.out.println(1);
    			  flag=true;
    		  }
    	  }else {
    		  
    		  if(s2.charAt(0)=='B') {
    			 sb=new StringBuilder();
    			 sb.append(s2.substring(1,s2.length()));
    			 String s=sb.reverse().toString();
    			 canMake(s1,s);
    		  }
    		  if(flag)return;
    		  if(s2.charAt(s2.length()-1)=='A') {
    			 canMake(s1,s2.substring(0,s2.length()-1)); 
    		  }
    		  
    		  
    	  }

    }
    
    public static boolean answer(String s1,String s2) {
    	if(s1.length()!=s2.length())return false;
    	
    	for(int i=0;i<s1.length();i++) {
    		if(s1.charAt(i)!=s2.charAt(i))return false;
    	}
    	return true;
    }
}