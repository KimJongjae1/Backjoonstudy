import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
   static int idxB;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] copy;
   static int[][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,0,-1,1,0,0};
   static int[] dix= {-1,1,0,0,0,0};
   static int[] diz= {0,0,0,0,-1,1};
   static boolean[][] visit;
   static boolean[] Islandvisit;
   static List<int[]> list;
   static Set<bridge>[][] set;  
   static Map<Integer,Integer> map;
   static int[] virus;
   static class bridge{
	   int id;
	   List<int[]> b;
	   int point1;
	   int point2;
	   bridge(int id,int point1,int point2){
		   this.id=id;
		   this.point1=point1;
		   this.point2=point2;
	   }
	   
   }
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
		 idx=1;
		 visit=new boolean[N][M];
    	 list=new ArrayList<>();
    	 Bridge();
//    		for(int i=0;i<N;i++) {
//        		for(int k=0;k<M;k++) {
//        			System.out.print(arr[i][k]+" ");
//        		}System.out.println();
//        	}System.out.println();
//    	for(int i=1;i<idx;i++) {
//    		for(int k=1;k<idx;k++) {
//    			System.out.print(dp[i][k]+" ");
//    		}System.out.println();
//    	}System.out.println();
    	
    	
    	 Islandvisit=new boolean[idx];
    	 ans=Integer.MAX_VALUE;
    	 for(int i=1;i<idx;i++) {
    		 Islandvisit[i]=true;
    		 DFS(i,1,0);
    		 Islandvisit[i]=false;
    	 }
    	 if(ans==Integer.MAX_VALUE)System.out.println(-1);
    	 else System.out.println(ans);
    	 
    }
    public static void Bridge() {
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<M;k++) {
    			if(arr[i][k]==0)continue;
    			else if(visit[i][k])continue;
    			visit[i][k]=true;
    			IslandBFS(i,k);
    		}
    	}
    	dp=new int[idx][idx];
    	MakeBridge();
    }
    public static void IslandBFS(int y,int x) {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {y,x});
    	arr[y][x]=idx;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		for(int i=0;i<4;i++) {
    			int Y=cur[0]+diy[i];
    			int X=cur[1]+dix[i];
    			if(!range(Y,X))continue;
    			if(visit[Y][X])continue;
    			if(arr[Y][X]==0) {
    				list.add(new int[] {cur[0],cur[1],i});
    			}else {
    				visit[Y][X]=true;
    				arr[Y][X]=idx;
    				qu.offer(new int[] {Y,X});
    			}
    		}
    		
    	}
    	idx++;
    	
    }
    public static void MakeBridge() {
    	
    	Loop:for(int[] info:list) {
   
    		int Y=info[0];
    		int X=info[1];
    		int dir=info[2];
    		int point1=arr[Y][X];
    		int point2=-1;
    		int cnt=0;
  
    		Y+=diy[dir];
    		X+=dix[dir];
    		while(true) {
    			if(!range(Y,X))continue Loop;
    			if(arr[Y][X]>0) {
    				point2=arr[Y][X];
    				break;
    			}else {
    				cnt++;
    		 		Y+=diy[dir];
    	    		X+=dix[dir];
    			}
    		}
    		if(cnt<=1)continue;
    		
    		if(dp[point1][point2]==0||dp[point1][point2]>cnt) {
    			dp[point1][point2]=cnt;
    			dp[point2][point1]=cnt;
    		}
    		
    	}
    	
    	
    }
    public static boolean range(int Y,int X) {
    	if(Y>=N||Y<0||X<0||X>=M) return false;
    	return true;
    }
    
    public static void DFS(int cur,int level,int sum) {
    	if(level==idx-1) {
    		ans=Math.min(ans, sum);
    	}else {
    		
    		for(int i=1;i<idx;i++) {
    			if(dp[cur][i]==0)continue;
    			if(Islandvisit[i])continue;

    			Islandvisit[i]=true;
    			DFS(i,level+1,sum+dp[cur][i]);
    			DFS(cur,level+1,sum+dp[cur][i]);
    			Islandvisit[i]=false;

    		}
    		
    	}
    }
}