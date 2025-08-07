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
      //  StringTokenizer st=new StringTokenizer(br.readLine()) ;
       
        	String T=br.readLine();
        	String P=br.readLine();
        	
        	
        	int cnt=0;
        	StringBuilder sb=new StringBuilder();
        	
        	int idx=0;
        	int[] table=new int[P.length()];
        	for(int i=1;i<P.length();i++) {
        		while(idx>0&&P.charAt(i)!=P.charAt(idx)) {
        			idx=table[idx-1];
        		}
        				
        		if(P.charAt(i)==P.charAt(idx))
        			table[i]=++idx;
        		
        	}
//        	int id=0;
//        	int[] table2=new int[P.length()];
//        	for(int i=1;i<P.length();i++) { 
//        		if(P.charAt(i)==P.charAt(id)) {
//        			table2[i]=table2[i-1]+1;
//        			id++;
//        		}else {
//        			table2[i]=0;
//        			id=0;
//        		}
//        	}
        	
        	idx=0;
        	for(int i=0;i<T.length();i++) {
        		if(idx>0&&T.charAt(i)!=P.charAt(idx)) {
        			idx=table[idx-1];
        		}
        		
        		if(T.charAt(i)==P.charAt(idx)) {
        			if(idx==P.length()-1) {
        				sb.append((i-idx+1)+" ");
        				cnt++;
        				idx=table[idx];
        			}else {
        				idx++;
        			}
        		}
        		
        	}
        System.out.println(cnt);
        System.out.println(sb);
        
        
    }
  }
 