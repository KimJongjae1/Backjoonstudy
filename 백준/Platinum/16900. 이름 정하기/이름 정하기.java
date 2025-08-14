import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



public class Main { 
    static long N;
    
    public static void main(String[] args) throws Exception {
    	StringBuilder sb=new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;
     

        String str=st.nextToken();
        N=Long.parseLong(st.nextToken());
        
        int n=str.length();
        long ret=N*(long)n;
        
        int idx=0;
        int[] table=new int[n];
        for(int i=1;i<n;i++) {
        	while(idx>0&&str.charAt(i)!=str.charAt(idx)) {
        		idx=table[idx-1];
        	}
        	
        	if(str.charAt(i)==str.charAt(idx)) {
        		table[i]=++idx;
        	}
        	
        }
        long len=table[n-1];
   
        ret-=len*(N-1);
        

       System.out.println(ret);
    }
  }
 