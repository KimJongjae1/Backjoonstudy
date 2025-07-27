import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] dist;
    static int[] diy= {-1,1,-1,1};
    static int[] dix= {1,1,-1,-1};
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        dist=new int[N+1][M+1];
        for(int i=0;i<N;i++) {
        	String str=br.readLine();
        	for(int k=0;k<M;k++) {
        		if(str.charAt(k)=='\\'){
        			arr[i][k]=1;	
        		}else {
        			arr[i][k]=2;
        		}
        		
        }
      	
        	
       }
        dij();   
        if(dist[N][M]==Integer.MAX_VALUE) System.out.println("NO SOLUTION");
        else System.out.println(dist[N][M]);
    }
    public static void dij() {
    	PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a,int[] b) {
    			if(a[2]!=b[2]) return a[2]-b[2];
    			else if(a[1]!=b[1]) return b[1]-a[1];
    			else return b[0]-a[0];
    		}
    	});
    	for(int i=0;i<=N;i++) {
    		for(int k=0;k<=M;k++) {
    			dist[i][k]=Integer.MAX_VALUE;
    		}
    	}
    		dist[0][0]=0;
    		pq.offer(new int[] {0,0,0});
    	while(!pq.isEmpty()) {
    		int[] now=pq.poll();
    		int y=now[0];
    		int x=now[1];
    		if(now[2]>dist[y][x]) continue;
    		
    		for(int i=0;i<4;i++) {
    			int Y=y+diy[i];
    			int X=x+dix[i];
    			if(Y<0||X<0||X>M||Y>N) continue;
    			int cost=check(y,x,i);
    			if(dist[Y][X]>now[2]+cost) {
    				dist[Y][X]=now[2]+cost;
    				pq.offer(new int[] {Y,X,dist[Y][X]});
    			}
    		}
    	}
    }
    //static int[] diy= {-1,1,-1,1};
    //static int[] dix= {1,1,-1,-1};
    public static int check(int y,int x,int i) {
   
    	switch(i) {
    	case 0: if(arr[y-1][x]==2) return 0;
    			else return 1; 
    		  
    	case 1:  if(arr[y][x]==1) return 0;
				else return 1; 
    			
    	case 2:  if(arr[y-1][x-1]==1) return 0;
    			else return 1; 
 		       
    	case 3:  if(arr[y][x-1]==2) return 0;
				else return 1; 	
    	}
    	return -1;
    }
}