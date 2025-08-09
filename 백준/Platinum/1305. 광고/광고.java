import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;



public class Main {
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=new StringTokenizer(br.readLine()) ;
       int L=Integer.parseInt(st.nextToken());
        	
       	String str=br.readLine();


        	int idx=0;
        	int[] table=new int[L];
        	for(int k=1;k<L;k++) {
        		if(idx>0&&str.charAt(k)!=str.charAt(idx)) {
        			idx=table[idx-1];
        		}
        		
        		if(str.charAt(k)==str.charAt(idx)) {
        			table[k]=++idx;
        		}
        	}
      
        	System.out.println(L-table[L-1]);
        
        
    }
  }
 