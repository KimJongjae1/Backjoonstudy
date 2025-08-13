import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



public class Main { 
    static int N;
    
    public static void main(String[] args) throws Exception {
    	StringBuilder sb=new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    //  StringTokenizer st=new StringTokenizer(br.readLine()) ;
      // N=Integer.parseInt(st.nextToken());
      String ret="";
      String str=br.readLine();
	  int[] table=new int[str.length()];

    	  int idx=0;
 
    	  for(int k=1;k<str.length();k++) {
    		  while(idx>0&&str.charAt(k)!=str.charAt(idx)) {
    			  idx=table[idx-1];
    		  }
    		  
    		  if(str.charAt(k)==str.charAt(idx)) {
    			  table[k]=++idx;
    		  }
    	  }
	  
	  int len=table[str.length()-1];
	 Loop: while(len>0) {
		  for(int i=1;i<str.length()-1;i++) {
			  if(len==table[i]) {
				  ret=str.substring(0,len);
				  break Loop;
			  }
		  }
		  len=table[len-1];
	  }
	  

     if(ret.equals("")) System.out.println(-1);
     else System.out.println(ret);
       
    }
  }
 