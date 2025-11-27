import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static List<Integer>[] list;
	static long ans;
	static int idx;
	static boolean[][] visit;
	static int[] diy= {-1,0,1,0};
	static int[] dix= {0,-1,0,1};
	static StringBuilder sb;
	static BufferedReader br;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
     
      
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N= Integer.parseInt(st.nextToken());
        	M= Integer.parseInt(st.nextToken());
        	arr=new int[N][M];
        	for(int i=0;i<N;i++) {
        		String str=br.readLine();
        		for(int k=0;k<M;k++) {
        			if(str.charAt(k)=='x') arr[i][k]=1;
        			else arr[i][k]=0;
        		}
        	}
        	visit=new boolean[N][M];
        	for(int i=0;i<N;i++) {
        		if(DFS(i,0))ans++;
        	}
        	
        	System.out.println(ans);
        	
        	
    }
    public static boolean DFS(int y,int x) {

    		for(int i=0;i<3;i++) {
    			int Y=y+diy[i];
    			int X=x+1;
    			
    			if(Y<0||Y>=N||X<0||X>=M)continue;
    			if(arr[Y][X]!=0)continue;
    			if(X==M-1)return true;
    			arr[Y][X]=2;
    			if(DFS(Y,X))return true;
    			
    		}
    		
    		return false;
    }

}