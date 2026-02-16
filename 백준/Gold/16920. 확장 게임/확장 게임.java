import java.io.BufferedReader;
import java.io.InputStreamReader;
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
   static long[][][] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,1,-1};
   static boolean[] visit;
   static List<int[]> list;
   static TreeSet<Integer> set;  
   static TreeMap<Integer,Integer> map;
   static int[] s;
   static Queue<int[]>[] qu;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        
        arr=new int[N][M];
        s=new int[K+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=K;i++) {
        	s[i]=Integer.parseInt(st.nextToken());
        }
        qu=new LinkedList[K+1];
        for(int i=1;i<=K;i++) qu[i]=new LinkedList<>();
        for(int i=0;i<N;i++) {
            String str=br.readLine();
        	for(int k=0;k<M;k++) {
        		char a=str.charAt(k);
        		if(a>='1'&&a<='9') {
        			qu[a-'0'].add(new int[] {i,k,s[a-'0']});
        			arr[i][k]=a-'0';
        		}else if(a=='#'){
        			arr[i][k]=-1;
        		}
        	}
        }

        
        BFS();
        int[] ans=new int[K+1];
        for(int i=0;i<N;i++) {
        	for(int k=0;k<M;k++) {
        		if(arr[i][k]>=1&&arr[i][k]<=9) {
        			ans[arr[i][k]]++;
        		}
        	}
        }
        for(int i=1;i<=K;i++) {
        	sb.append(ans[i]+" ");
        }
        System.out.println(sb);
    	
    }
    public static void BFS() {
    	visit=new boolean[K+1];
	    int cnt=K;
	    for(int i=1;i<=K;i++) {
	    	visit[i]=true;
	    	if(qu[i].size()==0) {
	    		visit[i]=false;
	    		cnt--;
	    	}
	    }
	    
    while(cnt!=0) {
    		
	    	for(int i=1;i<=K;i++) {
	    		if(!visit[i])continue;
	    		Queue<int[]> temp=new LinkedList<>();
	    		
	    		while(!qu[i].isEmpty()) {
	    			int[] cur=qu[i].poll();
	    			int cost=cur[2];
	    			
		    			for(int q=0;q<4;q++) {
		    				int Y=cur[0]+diy[q];
		    				int X=cur[1]+dix[q];
		    				if(Y<0||Y>=N||X<0||X>=M)continue;
		    				
		    				if(arr[Y][X]!=0)continue;
		    				
		    				if(cost==1) temp.offer(new int[] {Y,X,s[i]});
		    				else qu[i].offer(new int[] {Y,X,cost-1});	
		    				arr[Y][X]=i;
		    				
		    			 }
		    			
	    		}
	    		
	    		if(temp.size()==0) {
	    			visit[i]=false;
	    			cnt--;
	    		}
	    		else qu[i]=temp;
	    		
	    	 }
    		
    		
    	}
    	
    }
    
}