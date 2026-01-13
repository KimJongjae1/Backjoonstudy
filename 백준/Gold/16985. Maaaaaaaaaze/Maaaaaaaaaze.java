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
   static int[][][][] arr;
   static int[][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,0,-1,1,0,0};
   static int[] dix= {-1,1,0,0,0,0};
   static int[] diz= {0,0,0,0,-1,1};
   static boolean[][][] visit;
   static List<Set<Integer>>[] list;
   static Set<Integer> set;  
   static boolean[] Pvisit;
   static Queue<int[]> qu;
   static Map<Integer,Integer> map;
   static int[] direct;
   static int[] P;
   
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

		  
		  //  N=Integer.parseInt(st.nextToken());
        
		  arr=new int[5][5][5][4];
		  for(int i=0;i<5;i++) {
			  for(int k=0;k<5;k++) {
				  StringTokenizer st=new StringTokenizer(br.readLine());
				  for(int q=0;q<5;q++) {
					  arr[i][k][q][0]=Integer.parseInt(st.nextToken());
				  }
			  }
		  }



		  
		  
		for(int i=0;i<5;i++) {
			rotate(i);
		}
//		for(int w=0;w<5;w++) {
//		   for(int i=0;i<4;i++) {
//				  for(int k=0;k<5;k++) {
//					  for(int q=0;q<5;q++) {
//						  System.out.print(arr[w][k][q][i]+" ");
//					  }System.out.println();
//				  }System.out.println();
//			  }System.out.println();
//		}System.out.println("end");
		
		 
		direct=new int[5];
		P=new int[5];
		Pvisit=new boolean[5];
		ans=Integer.MAX_VALUE;
		BACK(0);
		if(ans==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(ans);
	   
   }
    public static void rotate(int level) {
    	
    	for(int i=0;i<5;i++) {
    		for(int k=0;k<5;k++) {
    			arr[level][k][4-i][1]=arr[level][i][k][0];
    		}
    	}
    	
    	for(int i=0;i<5;i++) {
    		for(int k=0;k<5;k++) {
    			arr[level][k][4-i][2]=arr[level][i][k][1];
    		}
    	}
    	
    	for(int i=0;i<5;i++) {
    		for(int k=0;k<5;k++) {
    			arr[level][k][4-i][3]=arr[level][i][k][2];
    		}
    	}
    	
    }
   public static void BACK(int level) {
	   if(level==5) {
		   BFS();

	   }
	   else {
		   for(int i=0;i<4;i++) {
			   direct[level]=i;
			   for(int k=0;k<5;k++) {
				   if(Pvisit[k])continue;
				   Pvisit[k]=true;
				   P[level]=k;
				   BACK(level+1);
				   Pvisit[k]=false;
			   }
			  
		   }
	   }
		   
   }
   public static void BFS() {
	   if(arr[P[0]][0][0][direct[0]]==0)return;
	   if(arr[P[4]][4][4][direct[4]]==0)return;
	   Queue<int[]> qu=new LinkedList<>();
	   qu.offer(new int[] {0,0,0,0});
	   visit=new boolean[5][5][5];
	   visit[P[0]][0][0]=true;
	   
	   while(!qu.isEmpty()) {
		   int[] cur=qu.poll();
		   if(ans<=cur[3])continue;
		   
		   for(int i=0;i<6;i++) {
			   int Y=cur[1]+diy[i];
			   int X=cur[2]+dix[i];
			   int z=cur[0]+diz[i];
			   if(Y<0||Y>=5||X<0||X>=5||z<0||z>=5)continue;
			   int Z=P[z];
			   int d=direct[z];
			   if(visit[Z][Y][X])continue;
			   visit[Z][Y][X]=true;
			   if(arr[Z][Y][X][d]==0)continue;
		
			   if(Y==4&&X==4&&Z==P[4]) {
				   ans=Math.min(ans, cur[3]+1);
				   return;
			   }
			   qu.offer(new int[] {z,Y,X,cur[3]+1});
			   
		   }
	   }
	   
	   
	   
   }
 
}