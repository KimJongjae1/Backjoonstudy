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
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<Set<Integer>>[] list;
   static Set<Integer> set;  
   static Queue<int[]> qu;

   static int[][] location;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	     
	    arr=new int[N][M];
	    for(int i=0;i<N;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int k=0;k<M;k++) {
	    		arr[i][k]=Integer.parseInt(st.nextToken());
	    	}
	    }
	    visit=new boolean[N][M];
	    set=new HashSet<>();
	    
	    for(int i=0;i<N;i++) {
	    	for(int k=0;k<M;k++) {
	    		if(arr[i][k]==2&&!visit[i][k]) {
	    			BFS(i,k);
	    		}
	    	}
	    }


	    visit=new boolean[N][M];

	    
	    for(int loca1:set) {
	    	arr[loca1/M][loca1%M]=1;
	    	for(int loca2:set) {
	
	    		visit=new boolean[N][M];
	    		arr[loca2/M][loca2%M]=1;
	        	BFSANS(loca1/M,loca1%M);
	        	if(loca1!=loca2)BFSANS(loca2/M,loca2%M);
		    	cnt=0;
		    	arr[loca2/M][loca2%M]=0;
		    	
	    	}
	    	arr[loca1/M][loca1%M]=0;

	    }
	    System.out.println(ans+sum);
	}
	    

  
    public static void BFS(int y,int x) {
    	qu=new LinkedList<>();
    	Set<Integer> s=new HashSet<>();
    	qu.offer(new int[] {y,x});
    	
    	visit[y][x]=true;
    	int cnt=1;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		for(int i=0;i<4;i++) {
    			int Y=cur[0]+diy[i];
    			int X=cur[1]+dix[i];
    			if(Y<0||Y>=N||X<0||X>=M)continue;
    			if(visit[Y][X])continue;
    			visit[Y][X]=true;
    			
    			if(arr[Y][X]==2) {
    				cnt++;
    				qu.offer(new int[] {Y,X});
    			}
    			else if(arr[Y][X]==1)continue;
    			else {
    				s.add(Y*M+X);
    				visit[Y][X]=false;
    			}
    			
    		}
    	}
    	if(s.size()>2)return;
    	for(int loca:s) {
    		set.add(loca);
    	}
    	
    }
    public static void BFSANS(int y,int x) {
    
    	for(int i=0;i<4;i++) {
    		int Y=y+diy[i];
    		int X=x+dix[i];
    		if(Y<0||Y>=N||X<0||X>=M)continue;
    		if(arr[Y][X]==2&&!visit[Y][X]) {
    			cnt+=BFSREAL(Y,X);

    		}
    	}
    	ans=Math.max(ans, cnt);
    	
    }
    public static int BFSREAL(int Y,int X) {
    	qu=new LinkedList<>();
    	qu.offer(new int[] {Y,X});
    	visit[Y][X]=true;
    	int cnt=1;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		
        	for(int i=0;i<4;i++) {
        		int y=cur[0]+diy[i];
        		int x=cur[1]+dix[i];
        		if(y<0||y>=N||x<0||x>=M)continue;
 
        		if(arr[y][x]==2&&!visit[y][x]) {
        			visit[y][x]=true;
        			qu.offer(new int[] {y,x});
        			cnt++;
        			
        		}
        		if(arr[y][x]==0)return 0;
        	}
    		
    	}
    	return cnt;
    }
}