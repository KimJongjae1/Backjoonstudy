import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[][] arr;
   static boolean[][] v;
   static int ans;
   static int[] diy= {1,-1,0,0};
   static int[] dix= {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N+2][M+2];
        v=new boolean[N+2][M+2];
        for(int i=1;i<=N;i++) {
        	String str=br.readLine();
        	for(int k=1;k<=M;k++) {
        		arr[i][k]=str.charAt(k-1)-'0';
        	}
        }
        v[0][0]=true;
        for(int i=0;i<=9;i++) {
        	bfs(i);

        }
        
        System.out.println(ans);
    }
    public static void bfs(int n){
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {0, 0});
    	boolean[][] visit=new boolean[N+2][M+2];
    	visit[0][0]=true;
    	
    	while(!qu.isEmpty()) {
    		int[] now=qu.poll();
    		
    		for(int i=0;i<4;i++) {
    			int Y=now[0]+diy[i];
    			int X=now[1]+dix[i];
    			
    			if(Y<0||Y>N+1||X<0||X>M+1)continue;
    			if(visit[Y][X])continue;
    			visit[Y][X]=true;
    			
    			if(n<arr[Y][X]) {
    				continue;
    			}else if(n>arr[Y][X]) {
    				if(!v[Y][X]) 
    				ans+=n-arr[Y][X];
    			}
    			
    			v[Y][X]=true;
    			qu.offer(new int[] {Y,X});
    		
    	
    		}
    		
    	}
    }
}