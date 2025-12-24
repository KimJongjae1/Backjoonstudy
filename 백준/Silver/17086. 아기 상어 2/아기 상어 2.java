import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
      
        arr=new int[N][M];
        list=new ArrayList<>();
        for(int i=0;i<N;i++) {
        	 st=new StringTokenizer(br.readLine());
        	for(int k=0;k<M;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        		if(arr[i][k]==1) {
        			arr[i][k]=-1;
        			list.add(i*M+k);        	
        		}else arr[i][k]=Integer.MAX_VALUE;
        	}
        }
        
        for(int loca:list) {
        	int y=loca/M;
        	int x=loca%M;
        	BFS(y,x);
        }
        for(int i=0;i<N;i++) {
        	for(int k=0;k<M;k++) {
        		ans=Math.max(ans,arr[i][k]);
        	}
        }
        
        System.out.println(ans);
        
        
    }
    public static void BFS(int y,int x) {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {y,x,0});
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		for(int i=0;i<8;i++) {
    			int Y=cur[0]+diy[i];
    			int X=cur[1]+dix[i];
    			if(Y<0||Y>=N||X<0||X>=M)continue;
    			int cost=cur[2]+1;
    		
    			if(arr[Y][X]<=cost)continue;
    			arr[Y][X]=cost;
    			qu.offer(new int[] {Y,X,cost});
    			
    		}
    	}
    }
    
    
}