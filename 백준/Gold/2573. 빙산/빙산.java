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
   static Queue<int[]> qu;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        
        arr=new int[N][M];
        qu=new LinkedList<>();
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int k=0;k<M;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        		if(arr[i][k]>0)qu.offer(new int[] {i,k});
        	}
        }
        int year=0;
        if(Divide()) {
        	System.out.println(year);
        	return;
        }
        while(!qu.isEmpty()) {
        	year++;
        	if(find()) {
        		System.out.println(year);
        		return;
        	}

        }
        System.out.println(0);
    	
    }
    public static boolean find() {
    	int len=qu.size();
    	List<int[]> Zero=new ArrayList<>();
    	for(int i=0;i<len;i++) {
    		int[] cur=qu.poll();
    		int cnt=0;
    		for(int k=0;k<4;k++) {
    			int y=cur[0]+diy[k];
    			int x=cur[1]+dix[k];
    			if(y<0||y>=N||x<0||x>=M)continue;
    			if(arr[y][x]==0)cnt++;
    			
    		}
    		if(arr[cur[0]][cur[1]]-cnt>0) {
    			arr[cur[0]][cur[1]]-=cnt;
    			qu.offer(cur);
    		}
    		else Zero.add(cur);
    	}
    	for(int[] Z:Zero)
    		arr[Z[0]][Z[1]]=0;
    	
    	if(Divide()) return true;
    	return false;
    }
    public static boolean Divide() {
    	int cnt=0;
    	int len=qu.size();
      	visit=new boolean[N][M];
    	for(int i=0;i<len;i++) {
    		int[] cur=qu.poll();
    		if(!visit[cur[0]][cur[1]]) {
    			BFS(cur[0],cur[1]);
    			cnt++;
    		}
    		qu.offer(cur);
    	}
    	if(cnt>1)return true;
    	return false;
    }
    public static void BFS(int sy,int sx) {
    	Queue<int[]> q=new LinkedList<>();
    	q.offer(new int[] {sy,sx});
  
    	visit[sy][sx]=true;
    	while(!q.isEmpty()) {
    		int[] cur=q.poll();
    		
    		for(int k=0;k<4;k++) {
    			int y=cur[0]+diy[k];
    			int x=cur[1]+dix[k];
    			if(y<0||y>=N||x<0||x>=M)continue;
    		
    			if(arr[y][x]==0)continue;
    			if(visit[y][x])continue;
    			visit[y][x]=true;
    			q.offer(new int[] {y,x});
    			
    		}
    	}
    }
    
}