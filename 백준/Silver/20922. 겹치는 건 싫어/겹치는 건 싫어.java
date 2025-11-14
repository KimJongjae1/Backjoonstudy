import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int idx;
	static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb=new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
       
        arr=new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        int right=0;
        int left=0;
        int max=1;
        int[] cnt=new int[100001];
        cnt[arr[right]]++;
        while(left<=right) {
        	right++;
        	if(right==N)break;
        	cnt[arr[right]]++;
        	if(cnt[arr[right]]>M) {
        		while(arr[left]!=arr[right]) {
        			cnt[arr[left]]--;
        			left++;
        		}
        		cnt[arr[left]]--;
        		left++;
        	}
        	
        	max=Math.max(right-left+1, max);
        	
        }
        System.out.println(max);
    }
  
}