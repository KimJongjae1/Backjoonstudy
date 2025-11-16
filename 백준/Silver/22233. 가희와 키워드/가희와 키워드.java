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
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        Set<String> set =new HashSet<>();
        
        for(int i=0;i<N;i++) {
        	set.add(br.readLine());
        }
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine(),",",false);
        	while(st.hasMoreTokens()) {
        		String str=st.nextToken();
        		if(set.contains(str)) set.remove(str);
        	}
        	sb.append(set.size()+"\n");
        }
        System.out.println(sb);
        
        
    }
}