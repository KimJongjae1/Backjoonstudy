import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] w;
	static int[] v;
	static Integer[][] dp;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		w=new int[N+1];
		v=new int[N+1];
		dp=new Integer[N+1][K+1];
		for(int i=1;i<=N;i++) {
			st =new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			v[i] =Integer.parseInt(st.nextToken());
			
		}
		System.out.println(dppack(N,K));
	}
	static int dppack(int i,int k) {
		if(i<1) return 0;
		
		if(dp[i][k]==null) {
			
			
			if(w[i]>k) {
				dp[i][k]=dppack(i-1,k);
			}else {
				dp[i][k]=Math.max(dppack(i-1,k),dppack(i-1,k-w[i])+v[i] );			
			}
			
		}
		
		
		
		
		return dp[i][k];
	}
	
	
}