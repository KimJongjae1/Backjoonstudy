import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int[] arr;
	static long ans;
	static int idx;
	static List<int[]> list;
	static boolean[] visit;
	static int[] diy= {-1,0,1,0};
	static int[] dix= {0,-1,0,1};
	static StringBuilder sb;
	static BufferedReader br;	
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());	
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        list=new ArrayList<>();
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	int y=Integer.parseInt(st.nextToken());
        	int x=Integer.parseInt(st.nextToken());
        	list.add(new int[] {y,x});
        }
    	int[][] dp=new int[N][K+1];
   
        for(int i=1;i<N;i++) {
        	Arrays.fill(dp[i], Integer.MAX_VALUE);
        	int[] cur=list.get(i);
        	for(int jump=0;jump<=K;jump++) {
        		int idx=i-jump-1;
        		if(idx<0)break;
        		int[] before=list.get(idx);
        		int len=Math.abs(cur[0]-before[0])+Math.abs(cur[1]-before[1]);
        		for(int q=0;q<=K-jump;q++) {
        			if(dp[idx][q]==Integer.MAX_VALUE)continue;
	        		dp[i][jump+q]=Math.min(dp[i][jump+q], dp[idx][q]+len);
        	   }
        	}
        }
    	int ans=Integer.MAX_VALUE;
    	for(int i=0;i<=K;i++) {
    		ans=Math.min(ans, dp[N-1][i]);
    	}
    	System.out.println(ans);
    }
    
}