import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] dp; 
	static int[] dix= {-1,0,1};
	static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
       
        arr=new int[N+1][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
        	for(int k=0;k<M;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        	
        	}
        }
        for(int i=0;i<M;i++) {
        	dfs(0,i,-1,arr[0][i]);
        }
        System.out.println(ans);
    }
    public static void dfs(int y,int x,int direct,int sum) {
    	if(y==N) {
    		ans=Math.min(ans, sum);
    	}else {
    		for(int i=0;i<3;i++) {
    			if(i==direct)continue;
    			int Y=y+1;
    			int X=x+dix[i];
    			if(X<0||X>=M)continue;
    			
    			dfs(Y,X,i,sum+arr[Y][X]);
    			
    		}
    	}
    	
    }
}