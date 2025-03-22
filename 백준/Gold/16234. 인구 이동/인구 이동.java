import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
    static int L;
    static int R;
    static int[] diy= {-1,1,0,0};
    static int[] dix= {0,0,-1,1};
    static int[][] land;
    static boolean change;
    static boolean[][] visit;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st=new StringTokenizer(br.readLine());
		  
         N=Integer.parseInt(st.nextToken());
         L=Integer.parseInt(st.nextToken());
         R=Integer.parseInt(st.nextToken());
	     land=new int[N][N];
         for(int i=0;i<N;i++) {
        	 st=new StringTokenizer(br.readLine());
        	 for(int k=0;k<N;k++) {
        		 land[i][k]=Integer.parseInt(st.nextToken());
        	 }
         }
         int ans=0;
         while(true) {
        	 visit=new boolean[N][N];
        	 change=false;
        	 for(int i=0;i<N;i++) {
        		 for(int k=0;k<N;k++) {
        			 if(!visit[i][k])
        			 bfs(i,k);
        		 }
        	 }
        	 if(!change)  break;
        	 
        	 ans++;
         }
        
         
	   System.out.println(ans);
   }
   public static void bfs(int y,int x) {
	   Queue<int[]> qu =new LinkedList<>();
	   List<int []> list=new ArrayList<>();
	   list.add(new int[] {y,x});
	   int sum=land[y][x];
	   int cnt=1;
	   qu.offer(new int[] {y,x});
	   visit[y][x]=true;
	   while(!qu.isEmpty()) {
		   int[] now=qu.poll();
		   
		   for(int i=0;i<4;i++) {
			   int Y=now[0]+diy[i];
			   int X=now[1]+dix[i];
			   if(0<=Y&&Y<N&&0<=X&&X<N) {
				   if(!visit[Y][X]) {
					   int diff=Math.abs(land[Y][X]-land[now[0]][now[1]]);
					   if(L<=diff&&diff<=R) {
						   sum+=land[Y][X];
						   cnt++;
						   change=true;
						   visit[Y][X]=true;
						   list.add(new int[] {Y,X});
						   qu.offer(new int[] {Y,X});
					   }
				   }
			   }
		   }
	   }
	   int newpeople=sum/cnt;
	   for(int[] place:list) {
		   land[place[0]][place[1]]=newpeople;
	   }
	   
   }
   
}