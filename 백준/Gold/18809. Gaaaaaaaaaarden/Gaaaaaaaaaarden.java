import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static int G;
   static int R;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] Green;
   static int[][] Red;
   static int[][] dp;
   static List<int[]> Rlist;
   static List<int[]> Glist;
   static int ans;
   static boolean flag;
   static int[] diy= {-1,0,1,0};
   static int[] dix= {0,1,0,-1};
   static boolean[][] visit;
   static List<Integer> list;
   static List<int[]> lake;
   static int idx;
   static class pair{
	   int time=Integer.MAX_VALUE;
	   int type;
	   int y;
	   int x;
	   
	   pair(int y,int x){
		   this.y=y;
		   this.x=x;
	   }
	   
	 
	   
   }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        Green=new int[N][M];
        Red=new int[N][M];
        list=new ArrayList<>();
        lake=new ArrayList<>();
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int k=0;k<M;k++) {
        		int n=Integer.parseInt(st.nextToken());
        		if(n==2) {
        			list.add(i*M+k);
        			arr[i][k]=-1;
        		}else if(n==1) {
        			arr[i][k]=-2;
        		}else {
        			Green[i][k]=-3;
        			Red[i][k]=-3;
        			lake.add(new int[] {i,k});
        		}
        		
        	}
        }
     
        Glist=new ArrayList<>();
        Rlist=new ArrayList<>();
        
        DFS(0,0,G,0);
        System.out.println(ans);
        //-1 은 뿌릴수 있는 땅 -2는 초기 세팅 가능한 땅 -3 호수 
    }
    public static void DFS(int level,int id,int Max,int end) {
    	
    	if(level==Max) {
    		if(end==0) {
    			DFS(0,0,R,1);
    		}else {
    			BFS();

    		}
    	}else {
    		int leftover=Max-level-1;
    		for(int i=id;i<list.size()-leftover;i++) {
    		
    			int y=list.get(i)/M;
    			int x=list.get(i)%M;
    			if(arr[y][x]!=-1)continue; 
    			arr[y][x]=0;
    			if(end==0)Glist.add(new int[] {y,x});
    			else Rlist.add(new int[] {y,x});
    			DFS(level+1,i+1,Max,end);
    			arr[y][x]=-1;
    			if(end==0)Glist.remove(level);
    			else Rlist.remove(level);
    			
    		}
    		
    	}

    }
    
    public static void BFS() {
    	Queue<int[]> qu=new LinkedList<>();
     	pair[][] field=new pair[N][M];
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<M;k++) {
    			field[i][k]=new pair(i,k);
    		}
    		
    	}
    	
    	for(int[] la:lake) {
    		field[la[0]][la[1]].type=-3;
    	}
    	
    	for(int[] fer:Glist) {
    		field[fer[0]][fer[1]].type=1;
    		field[fer[0]][fer[1]].time=0;
    		qu.offer(fer);
    	}
    	for(int[] fer:Rlist) {
    		qu.offer(fer);
    		field[fer[0]][fer[1]].type=2;
    		field[fer[0]][fer[1]].time=0;
    	}	

    	int cnt=0;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		int cost=field[cur[0]][cur[1]].time+1;
    		int type=field[cur[0]][cur[1]].type;
    		if(type==3)continue;
    		
    		for(int i=0;i<4;i++) {
    			int y=cur[0]+diy[i];
    			int x=cur[1]+dix[i];
    			if(y<0||y>=N||x<0||x>=M) continue;
    		
    			if(field[y][x].type==-3)continue;
    			if(field[y][x].type==3)continue;
    			if(field[y][x].time<cost)continue;
    			if(field[y][x].time==cost) {
    				if(field[y][x].type==type)continue;
    				field[y][x].type=3;
    				continue;
    			}
    			field[y][x].time=cost;
    			field[y][x].type=type;
    			qu.offer(new int[] {y,x});
    			
    		}
    		
    	}
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<M;k++) {
    			if(field[i][k].type==3)cnt++;
    		}
    	}
   
    	
    	ans=Math.max(ans, cnt);
    	
    }
    


}