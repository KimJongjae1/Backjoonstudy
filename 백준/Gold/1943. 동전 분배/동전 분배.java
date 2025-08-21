import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
//    static int N;
    static boolean[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  
     for(int t=0;t<3;t++) {
    	 String str=br.readLine();
    	 int N=Integer.parseInt(str);


    	 int[][] arr=new int[N+1][2];
    	 int sum=0;
        for(int i=1;i<=N;i++) {
        StringTokenizer st=new StringTokenizer(br.readLine()) ;
    	 int n=Integer.parseInt(st.nextToken());
         int m=Integer.parseInt(st.nextToken());
         arr[i][0]=n;
         arr[i][1]=m;
         sum+=n*m;
        
        }
        if(sum%2!=0) {
        	System.out.println(0);
        	continue;
        }
   
        dp=new boolean[N+1][sum+1];
        for(int i=0;i<=arr[1][1];i++) {
        	dp[1][i*arr[1][0]]=true;
        
        }
        
        
        for(int i=2;i<=N;i++) {
        	for(int k=0;k<=sum;k++) {
        		int temp=k;
        		if(dp[i-1][k]) {
        			dp[i][k]=true;
        			for(int q=0;q<arr[i][1];q++) {
	        			temp+=arr[i][0];
	        			dp[i][temp]=true;
        			}
        		}	
        	}
        }
        
//        for(int i=0;i<=N;i++) {
//        	for(int k=0;k<=sum;k++) {
//        		if(dp[i][k])System.out.print(1+" ");
//        		else System.out.print(0+" ");
//        	}
//        	System.out.println();
//        }System.out.println();
        
        if(dp[N][sum/2]) System.out.println(1);
        else System.out.println(0);
        
        
     }
    }
}