import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,-1,1};
   static boolean[][] visit;
   static List<int[]> list;
   static Set<Integer> school;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        school=new HashSet<>();
        if(M>0)
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
        	school.add(Integer.parseInt(st.nextToken()));
        }
        dp=new int[N+1][N+1];
        for(int i=0;i<=N;i++) {
        	Arrays.fill(dp[i], -1);
        }
        
        System.out.println(Dynamic(1,0));
    }
    public static int Dynamic(int day,int coopon) {
    	
    	if(day>N)return 0;
    	
    	if(dp[day][coopon]!=-1) return dp[day][coopon];
    	
    	dp[day][coopon]=Integer.MAX_VALUE;
    	if(school.contains(day)) {
    		return dp[day][coopon]=Math.min(dp[day][coopon], Dynamic(day+1,coopon));
    	}else {
    		if(coopon>=3) {
    			dp[day][coopon]=Math.min(dp[day][coopon], Dynamic(day+1,coopon-3));
    		}
    		dp[day][coopon]=Math.min(dp[day][coopon], Dynamic(day+1,coopon)+10000);
    		dp[day][coopon]=Math.min(dp[day][coopon], Dynamic(day+3,coopon+1)+25000);
    		dp[day][coopon]=Math.min(dp[day][coopon], Dynamic(day+5,coopon+2)+37000);
    		
    	}
    	return dp[day][coopon];
    }
}