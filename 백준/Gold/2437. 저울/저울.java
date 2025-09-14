import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st=new StringTokenizer(br.readLine()) ;
	        StringBuilder sb=new StringBuilder();
	      
	        String str=st.nextToken();
	        N=Integer.parseInt(str);
	        List<Integer> list=new ArrayList<>();
	        st=new StringTokenizer(br.readLine()) ;
	        for(int i=0;i<N;i++) {
	        	int a=Integer.parseInt(st.nextToken());
	        	list.add(a);
	        }
	        
	       Collections.sort(list);
	     //  if(list.get(0)!=1) {
	    //	   System.out.println(1);
	    	//   return;
	      // }
	       
	       long sum=0;
	       for(int i=0;i<N;i++) {
	    	   long s=list.get(i);
	    	  if(sum+1<s)break;
	    	  sum+=s;
	       }
	       System.out.println(sum+1);
	       
    }
}