import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static boolean[][] dp;
	static int[] chu;


     public static void main (String[] args) throws IOException {
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	 StringBuilder sb=new StringBuilder();
    	 N=Integer.parseInt(br.readLine());
    	 
    	 StringTokenizer st=new StringTokenizer(br.readLine());
    	 chu=new int[N+1];
 
    	 for(int i=0;i<N;i++) {
    		 chu[i]=Integer.parseInt(st.nextToken());
    	 }
    	
         M=Integer.parseInt(br.readLine());
     	 dp=new boolean[N+1][16000];

        st=new StringTokenizer(br.readLine());
        dyna(0,0);
         for(int i=1;i<=M;i++) {
    		 int bead=Integer.parseInt(st.nextToken());
    		 if(bead>15000 ) sb.append("N ");
    		 else if(dp[N][bead]) sb.append("Y ");
    		 else sb.append("N ");
    	 } 
       System.out.println(sb);
      
     }
    public static void dyna(int y,int x) {
       if(dp[y][x]) return;
       dp[y][x]=true;
       if(y==N) return;
    	
       dyna(y+1,x);
       dyna(y+1,x+chu[y]);
       dyna(y+1,Math.abs(x-chu[y]));
    	
    	
    }
}