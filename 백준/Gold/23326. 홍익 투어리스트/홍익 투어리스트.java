import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static int N;
    public static TreeSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());;
        int M=Integer.parseInt(st.nextToken());
        
        set=new TreeSet<>();
        int start=1;
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	if(Integer.parseInt(st.nextToken())==1) {
        		set.add(i);
        	}
        }
  
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	
        	int order=Integer.parseInt(st.nextToken());
        	
        	if(order==3) {
        		if(set.isEmpty()) {
        			sb.append(-1).append("\n"); continue;
        		}
        		
        		Integer popular=set.ceiling(start);
        		if(popular==null) {
        			popular=set.higher(0);
        			int range=popular-start;
        			if(range<0) range+=N;
        			sb.append(range).append("\n");
        			
        		}else {
        			int range=popular-start;
        			sb.append(range).append("\n");
        		}
        	}
        	else if(order==2) {
        		int move=Integer.parseInt(st.nextToken())%N;
        		start+=move;
        		if(start>N)start%=N;
        	}
        	else {
        		int num=Integer.parseInt(st.nextToken());
        		if(!set.contains(num)) {
        			set.add(num);
        		}else {
        			set.remove(num);
        		}
        	}
        
        }
        System.out.println(sb);
    }
}
