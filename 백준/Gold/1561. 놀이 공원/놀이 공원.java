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
    public static long M;
    static long target;
    public static  long[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M= Long.parseLong(st.nextToken());
        
        if(N<=M) {
        	System.out.println(N);
        	return;
        }
        target=N-M;
        time=new long[(int)M+1];
        st=new StringTokenizer(br.readLine());
        long maxtime=0;
        
        for(int i=1;i<=M;i++) {
        	time[i]=Integer.parseInt(st.nextToken());
        }
        
        maxtime=30*N;
        long min=0;
        while(min<=maxtime) {
        	long mid=(min+maxtime)/2;
        	long num=check(mid);//시간 mid는 시간 
        	
        	if(num<target) min=mid+1;
        	else maxtime=mid-1;
        	
        	
        }
        long ret=0;
        long beforechildnum=check(min-1)+M;
    
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
    	
    	long ret=0;
    	for(int i=1;i<=M;i++) {
    		ret+=mid/time[i];

    	}
    	
    	return ret;
    }
}
