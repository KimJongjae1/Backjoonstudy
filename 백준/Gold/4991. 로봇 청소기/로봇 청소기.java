import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
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
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][][] visit;
   static List<Set<Integer>>[] list;
   static Set<Integer> set;  
   static Queue<int[]> qu;
   static Map<Integer,Integer> map;
   static int[] index;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
        while(true) {
		    StringTokenizer st=new StringTokenizer(br.readLine());
		    M=Integer.parseInt(st.nextToken());
		    N=Integer.parseInt(st.nextToken());
		    if(N==0)break; 
		    arr=new int[N][M];
		    map=new HashMap<>();	
		    idx=1;
		    int id=0;

		    for(int i=0;i<N;i++) {
		    	String str=br.readLine();
		    	for(int k=0;k<M;k++) {
		    		char a=str.charAt(k);
		    		
		    		if(a=='*') {
		    			arr[i][k]=idx++;
		    		}
		    		else if(a=='o') {
		    			id=i*M+k;
		    		 }else if(a=='x'){
		    			 arr[i][k]=-1;
		    		 }
		    		
		    	}
		    }
	
		   ans=Integer.MAX_VALUE;
		   BFS(id);
		 
		 
		   if(ans==Integer.MAX_VALUE)sb.append(-1+"\n");
		   else sb.append(ans+"\n");
		   
        }
        System.out.println(sb);
    }
    public static void BFS(int id) {

    	qu=new LinkedList<>();
    	qu.offer(new int[] {id/M,id%M,0,0});
    	visit=new boolean[N][M][1<<idx];
    	visit[id/M][id%M][0]=true;
    	int end=0;
    	for(int i=1;i<idx;i++) {
    		end+=1<<i;
    	}
    
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		if(end==cur[2]) {
    			ans=cur[3];
    			return;
    		}
    		
    		for(int i=0;i<4;i++) {
    			int Y=cur[0]+diy[i];
    			int X=cur[1]+dix[i];
    			if(Y<0||Y>=N||X<0||X>=M)continue;
    			if(visit[Y][X][cur[2]])continue;
    			   visit[Y][X][cur[2]]=true;
    			   
    			if(arr[Y][X]==-1)continue;
    			int finish=cur[2];
    			if(arr[Y][X]>0) {
    				if((finish&(1<<arr[Y][X]))==0)
    			    finish+=1<<arr[Y][X];
    			}

    			  qu.offer(new int[] {Y,X,finish,cur[3]+1});
    			
    		}
    	}
    	
    	
    }
   
}