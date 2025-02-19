import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        	
        Queue<Integer> qu =new LinkedList<>();
        
        for(int i=1;i<=N;i++) {
        	qu.offer(i);
        }
        
        StringBuilder sb= new StringBuilder();
        sb.append("<");
        
        int count=0;
        while(qu.size()>1) {
        	int temp=qu.poll();
        	count++;
        	if(count==M) {
        		count=0;
        		sb.append(temp).append(",").append(" ");
        		continue;
        	}
        	qu.offer(temp);
        	
        }
        
        sb.append(qu.poll()).append(">");
        System.out.println(sb);
        
	}
	
}
