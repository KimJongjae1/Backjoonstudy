import java.io.BufferedReader;
import java.io.InputStreamReader;
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
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,0,-1,1,0,0};
   static int[] dix= {-1,1,0,0,0,0};
   static int[] diz= {0,0,0,0,-1,1};
   static boolean[] visit;
   static List<Set<Integer>>[] list;
   static Set<Integer> set;  
   static boolean[] Pvisit;
   static Queue<int[]> qu;
   static Map<Integer,Integer> map;
   static int[][] people;
   static boolean[] used;
   static int[] win;
   static int useP;
   static int[] turnidx;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer.parseInt(st.nextToken());
		 K=Integer.parseInt(st.nextToken());
        arr=new int[N+1][N+1];
		 for(int i=1;i<=N;i++) {
			 st=new StringTokenizer(br.readLine());
			 for(int k=1;k<=N;k++) {
				 arr[i][k]=Integer.parseInt(st.nextToken());
			 }
		 }
	   
		 people=new int[3][20];
		 st=new StringTokenizer(br.readLine());
		 for(int i=0;i<20;i++) {
			 people[1][i]=Integer.parseInt(st.nextToken());
		 }
		 st=new StringTokenizer(br.readLine());
		 for(int i=0;i<20;i++) {
			 people[2][i]=Integer.parseInt(st.nextToken());
		 }
		 used=new boolean[N+1];
		 win=new int[3];
		 turnidx=new int[3];
		 DFS(0,0,1);
		 if(flag)System.out.println(1);
		 else System.out.println(0);
   }
    //지우0 경희1 민호2 
    public static void DFS(int turn,int first,int second) {
    	if(flag)return;
    	if(turn==20)return;
    	
    	int IsThereWinner=FindWinner();
    	if(IsThereWinner==0) {
    		flag=true;
    		return;
    	}
    	else if(IsThereWinner>0) return;
    	
    	

    		int winner=-1;
    		int NEWPLAYER=newPlayer(first,second);
    		if(first==0) {
    	   
    			for(int i=1;i<=N;i++) {
    				if(used[i])continue;
    				used[i]=true;
    				winner =game(first,second,i);
    				
    				win[winner]++;
    				
    				
    				int f=winner;
    				int n=NEWPLAYER;
    				if(f>n) {
    					int temp=f;
    					f=n;
    					n=temp;
    				}
    				
    				DFS(turn+1,f,n);
    				if(flag)return;
    				used[i]=false;
    				win[winner]--;
    				turnidx[first]--;
    				turnidx[second]--;
    			}
    			
    		}else {
    	    
    			winner =game(first,second,-1);
    			if(winner==-1)return;
				win[winner]++;
				
				int f=winner;
				int n=NEWPLAYER;
				if(f>n) {
					int temp=f;
					f=n;
					n=temp;
				}
				
				DFS(turn+1,f,n);
				if(flag)return;
				win[winner]--;
				turnidx[first]--;
				turnidx[second]--;
    			
    		}
    		
    	
    }
    
    public static int game(int first,int second,int f) {

    	int firstP=-1;
    	if(first==0)firstP=f;
    	else firstP=people[first][turnidx[first]++];
    	
    	int secondP=people[second][turnidx[second]++];
    	
  
    	if(arr[firstP][secondP]<=1)return second;
    	else return first;
   
    }
    
    public static int newPlayer(int first,int second) {
    	int NEWPLAYER=-1;
    	for(int i=0;i<3;i++) {
    		if(first!=i&&second!=i) {
    			NEWPLAYER=i;
    			break;
    		}
    	}

    	return NEWPLAYER;
    	
    }
   public static int FindWinner() {
	   
	   for(int i=0;i<3;i++) {
		   if(win[i]>=K) {
			   return i;
		   }
	   }
	   return -1;
   }
}