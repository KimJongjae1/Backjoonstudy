import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,-1,1};
   static boolean[] visit;
   static int[] planet;
   static boolean flag;
   static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N][N];
        ans=Integer.MAX_VALUE;
        dp=new int[N][N];
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int k=0;k<N;k++) {
        		dp[i][k]=Integer.MAX_VALUE;
        		arr[i][k]=Integer.parseInt(st.nextToken());
        	}
        	dp[i][i]=0;
        }
     
        for(int q=0;q<N;q++) {
        	for(int i=0;i<N;i++) {
        		if(q==i)continue;
        		for(int k=0;k<N;k++) {
        			if(i==k||q==k)continue;
        			if(arr[i][q]+arr[q][k]<arr[i][k]) {
        				arr[i][k]=arr[i][q]+arr[q][k];
        			}
        		}
        	}
        }
        visit=new boolean[N];
        planet=new int[N];
        planet[K]++;
        visit[K]=true;
    	back(K,0);
    	System.out.println(ans);
    }
    public static void back(int k,int sum) {
    	if(AllPlanet()) {
    		ans=Math.min(ans, sum);
    		return;
    	}
    	for(int next=0;next<N;next++) {
    		
    		if(visit[next])continue;
    		visit[next]=true;
    		back(next,sum+arr[k][next]);
    		visit[next]=false;

    	}
    	
    }
    public static boolean AllPlanet() {
    	for(int i=0;i<N;i++) {
    		if(!visit[i])return false;
    	}
    	return true;
    }
}