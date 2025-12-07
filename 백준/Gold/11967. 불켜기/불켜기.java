import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
  static  Map<Integer,List<Integer>> map;
  static Queue<int[]> CheckIfLight;
   static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        list=new ArrayList<>();
       arr=new int[N][N];
       visit=new boolean[N][N];
       arr[0][0]=1;
	    map=new HashMap<>();
	    
       for(int i=0;i<M;i++) {
    	   st=new StringTokenizer(br.readLine());
    	   int x=Integer.parseInt(st.nextToken())-1;
    	   int y=Integer.parseInt(st.nextToken())-1;
    	   int a=Integer.parseInt(st.nextToken())-1;
    	   int b=Integer.parseInt(st.nextToken())-1;
    	   
    	   int n=x*N+y;
    	   map.putIfAbsent(n, new ArrayList<Integer>());
    	   map.get(n).add(a*N+b);
       }
       BFS();
       
       for(int i=0;i<N;i++) {
    	   for(int k=0;k<N;k++) {
    		   if(arr[i][k]==1)ans++;
    	   }
       }

       
       System.out.println(ans);
    }
    public static void BFS() {
    	Queue<int[]> qu=new LinkedList<>();
    	CheckIfLight=new LinkedList<>();
    	qu.offer(new int[] {0,0});
    	visit[0][0]=true;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		int n=cur[0]*N+cur[1];
    		
    		if(map.containsKey(n)) {
	    		for(int lightRoom:map.get(n)) {
	    			int y=lightRoom/N;
	    			int x=lightRoom%N;

	    			arr[y][x]=1;
	    		}
    		}
    		
    		for(int i=0;i<4;i++) {
    			int y=cur[0]+diy[i];
    			int x=cur[1]+dix[i];
    			
    			if(y<0||y>=N||x<0||x>=N)continue;
    			
    			if(visit[y][x])continue;
    			visit[y][x]=true;
    			
    			if(arr[y][x]==0) CheckIfLight.offer(new int[] {y,x});
    			else qu.offer(new int[] {y,x});
    				
    			
    		}
    		
    		if(qu.isEmpty()) {
    			CheckTheRoomLight(qu);
    		}
    	}
    	
    }
    public static void CheckTheRoomLight(Queue<int[]> qu) {
    	int size=CheckIfLight.size();
    	int cnt=0;
    	while(size!=cnt) {
    		
    		int[] cur=CheckIfLight.poll();
    		if(arr[cur[0]][cur[1]]==1)qu.offer(cur);
    		else {
    			CheckIfLight.offer(cur);
    			visit[cur[0]][cur[1]]=false;
    		}
    		cnt++;
    	}
    	
    }
    
    public static void printArr() {
    	  for(int i=0;i<N;i++) {
       	   for(int k=0;k<N;k++) {
       		   System.out.print(arr[i][k]+" ");
       	   }System.out.println();
          }
          System.out.println();
    }
}