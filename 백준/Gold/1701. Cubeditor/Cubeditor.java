import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      //  StringTokenizer st=new StringTokenizer(br.readLine()) ;
     
       // N=Integer.parseInt(st.nextToken());
        int max=0;
        String str=br.readLine();
        for(int i=0;i<str.length();i++) {
        	String sub=str.substring(i);
        	int idx=0;
        	int[] table=new int[sub.length()];
        	for(int k=1;k<sub.length();k++) {
        		while(idx>0&&sub.charAt(k)!=sub.charAt(idx)) {
        			idx=table[idx-1];
        		}
        		
        		if(sub.charAt(k)==sub.charAt(idx)) {
        			table[k]=++idx;
        			max=Math.max(max, idx);
        		}
        	}
        }
        System.out.println(max);
        
    }
}