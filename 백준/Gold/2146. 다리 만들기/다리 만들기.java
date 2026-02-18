import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int T;
   static int idx;
   static int max;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,1,-1};
   static boolean[][][] visit;
   static List<Integer>[] list;
   static TreeSet<Integer> set;  
   static TreeMap<Long,Long> map;
   static Queue<int[]> s;
   static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     
	        
	     	StringTokenizer st=new StringTokenizer(br.readLine());
	     	N=Integer.parseInt(st.nextToken());
	       cnt=2;
	       arr=new int[N][N];
	     
	       s=new LinkedList<>();
	       min=Integer.MAX_VALUE;
	       for(int i=0;i<N;i++) {
	    	   st=new StringTokenizer(br.readLine());
	    	   for(int k=0;k<N;k++) {
	    		   arr[i][k]=Integer.parseInt(st.nextToken());
	    	   }
	       }
	       for(int i=0;i<N;i++) {
	    	   for(int k=0;k<N;k++) {
	    		   if(arr[i][k]==1) {
	    			   island(i,k);
	    		   }
	    	   }
	       }
	       
	
	       
	       visit=new boolean[N][N][cnt+1];
	       bridge();
	       System.out.println(min);
	       
   }
    public static void island(int  y,int x) {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {y,x,0,cnt});
    	arr[y][x]=cnt;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		boolean startcheck=false;
    		for(int i=0;i<4;i++) {
    			int Y=cur[0]+diy[i];
    			int X=cur[1]+dix[i];
    			if(Y<0||Y>=N||X<0||X>=N)continue;
    			if(arr[Y][X]==1) {
    				arr[Y][X]=cnt;
    				qu.offer(new int[] {Y,X,0,cnt});
    			}else if(arr[Y][X]==0) {
    				startcheck=true;
    			}
    			
    		}
    		if(startcheck) {
				s.offer(cur);
			}
    	}
    	cnt++;
    }

    
    public static void bridge() {
    	for(int[] st:s) {
    		visit[st[0]][st[1]][st[3]]=true;
    	}
    
    	
    	while(!s.isEmpty()) {
    		int[] cur=s.poll();
    		if(min<cur[2])continue;
    		
    		for(int i=0;i<4;i++) {
    			int Y=cur[0]+diy[i];
    			int X=cur[1]+dix[i];
    			if(Y<0||Y>=N||X<0||X>=N)continue;
    			if(visit[Y][X][cur[3]])continue;
    			visit[Y][X][cur[3]]=true;
    			
    			if(arr[Y][X]==0) {
    				s.offer(new int[] {Y,X,cur[2]+1,cur[3]});
    			}else if(arr[Y][X]!=cur[3]) {
    				
    				//System.out.println(cur[0]+" "+cur[1]+" "+cur[2]+" "+cur[3]);
    				min=Math.min(min, cur[2]);
    			}
    			
    		}
    	}

    }
    
   
}