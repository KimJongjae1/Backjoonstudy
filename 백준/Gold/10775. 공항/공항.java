import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
     
       // StringBuilder sb=new StringBuilder();
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=1;i<=N;i++) {
        	set.add(i);
        }
       int cnt=0;
    	int P=Integer.parseInt(br.readLine());
    	for(int i=0;i<P;i++) {
    		Integer a=Integer.parseInt(br.readLine());
    		if(set.contains(a))set.remove(a);
    		else {
    			a=set.lower(a);
    			if(a==null) break;
    			else set.remove(a);
    		}
    		cnt++;
    	}
    	System.out.println(cnt);
    }
}