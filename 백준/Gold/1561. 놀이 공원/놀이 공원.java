import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static long N;
    public static int M;
    public static  long[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        
        if(N<=M) {
        	System.out.println(N);
        	return;
        }
 
        time=new long[M+1];
        st=new StringTokenizer(br.readLine());
        long max=0;
        
        for(int i=1;i<=M;i++) {
        	time[i]=Integer.parseInt(st.nextToken());
        }
        
        max=30*N;
        long min=0;
        while(min<=max) {
        	long mid=(min+max)/2;
        	long num=check(mid);//시간 mid는 시간 
        	
        	if(num<N) min=mid+1;
        	else max=mid-1;
        	
        	
        }
       
        
        long beforechildnum=check(min-1);
    
        for(int i=1;i<=M;i++) {
        	if(min%time[i]==0)
        		beforechildnum++;
        	
        	if(beforechildnum==N) {
        		System.out.println(i);
        		break;
        	}
        }
        
       
        
        
    }
    public	static long check(long mid) {
    	
    	long ret=M;
    	for(int i=1;i<=M;i++) {
    		ret+=mid/time[i];

    	}
    	
    	return ret;
    }
}
