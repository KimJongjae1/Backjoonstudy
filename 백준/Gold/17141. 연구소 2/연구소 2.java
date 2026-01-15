import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
   static int[][] copy;
   static int[][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,0,-1,1,0,0};
   static int[] dix= {-1,1,0,0,0,0};
   static int[] diz= {0,0,0,0,-1,1};
   static boolean[] visit;
   static List<Integer> list;
   static Set<Integer> set;  
   static Map<Integer,Integer> map;
   static int[] virus;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer.parseInt(st.nextToken());
		 M=Integer.parseInt(st.nextToken());
        arr=new int[N+1][N+1];
        copy=new int[N][N];
        list=new ArrayList<>();
        virus=new int[M];
		 for(int i=0;i<N;i++) {
			 st=new StringTokenizer(br.readLine());
			 for(int k=0;k<N;k++) {
				 arr[i][k]=copy[i][k]=Integer.parseInt(st.nextToken());
				 if(arr[i][k]==2) {
					 list.add(i*N+k);
				 }
				 
				 
				 if(arr[i][k]==1) {
					 arr[i][k]=copy[i][k]=-1;
				 }else {
					 arr[i][k]=copy[i][k]=Integer.MAX_VALUE;
				 }
			 }
		 }
	   ans=Integer.MAX_VALUE;
		BACK(0,0);
		if(ans==Integer.MAX_VALUE)System.out.println(-1); 
		else System.out.println(ans);
		 
		 
   }
    public static void BACK(int level,int next) {
    	if(level==M) {
    		BFS();
    	}else {
    		for(int i=next;i<list.size();i++) {
    			virus[level]=list.get(i);
    			BACK(level+1,i+1);
    			
    		}
    	}
    }
    public static void BFS() {
    	Queue<int[]> qu=new LinkedList<>();
    	for(int i=0;i<M;i++) {
    		qu.offer(new int[] {virus[i]/N,virus[i]%N,0});
    		arr[virus[i]/N][virus[i]%N]=0;
    	}
    	while(!qu.isEmpty()) {
    		int[] virusCur=qu.poll();
    		if(virusCur[2]>arr[virusCur[0]][virusCur[1]])continue;
    		
    		for(int i=0;i<4;i++) {
    			int Y=virusCur[0]+diy[i];
    			int X=virusCur[1]+dix[i];
    			if(Y<0||Y>=N||X<0||X>=N)continue;
    			if(arr[Y][X]<=virusCur[2]+1)continue;
    			arr[Y][X]=virusCur[2]+1;
    			qu.offer(new int[] {Y,X,arr[Y][X]});
    			
    		}
    	}
    	AnsAndClean();
    }
    public static void AnsAndClean() {
    	int cnt=0;
    	int min=0;
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<N;k++) {
    			if(arr[i][k]==0)cnt++;
    			min=Math.max(min, arr[i][k]);
    			arr[i][k]=copy[i][k];
    		}
    	}
    	
    	if(cnt==M) ans=Math.min(ans, min);
    	
    }
}