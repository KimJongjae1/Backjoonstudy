import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] diy= {-1,1,0,0};
	static int[] dix= {0,0,1,-1};
	static int[][] paper;
	static Queue<int[]> cheese;
	static  Queue<int[]> trash;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		   StringTokenizer st =new StringTokenizer(br.readLine());

		   N=Integer.parseInt(st.nextToken());
		   M=Integer.parseInt(st.nextToken());
		  paper=new int[N][M];
		  cheese=new LinkedList<>();
		 for(int i=0;i<N;i++) {
			 st =new StringTokenizer(br.readLine());
			 for(int k=0;k<M;k++) {
				 paper[i][k]=Integer.parseInt(st.nextToken());
				 if(paper[i][k]==1) cheese.offer(new int[] {i,k});
			 }
		 }
		 

		 for(int i=0;i<N;i++) {
			 for(int k=0;k<M;k++) {
				 if(paper[i][k]==0) {
					checking(i,k);
					}
			 }
		 }
		 deletecheese();
		 int time=1;
		 while(!cheese.isEmpty()) {

		 for(int i=0;i<N;i++) {
			 for(int k=0;k<M;k++) {
				if(paper[i][k]==2) {
					paintnocheck(i,k);
				}
			 }
		 }
		 
		 deletecheese();
		 time++;
		 
		 }
		 System.out.println(time);
   }
   
   public static void deletecheese() {
		 int size=cheese.size();
		 trash=new LinkedList<>();
		 for(int i=0;i<size;i++) {
			 int[] now=cheese.poll();
			 int cnt=0;
			 for(int k=0;k<4;k++) {
				   int Y=now[0]+diy[k];
				   int X=now[1]+dix[k];
				   if(X>=0&&X<M&&Y>=0&&Y<N) {
					   if(paper[Y][X]==-1) {
						   cnt++;
					   }
				   }
			 }
			 if(cnt>=2) {trash.offer(now);
			 } else {cheese.offer(now);}
		 }
		 while(!trash.isEmpty()) {
			 int[] now=trash.poll();
			 paper[now[0]][now[1]]=-1;
		 }
   }
   
   
   public static void checking(int y,int x) {
	   Queue<int[]> qu=new LinkedList<>();
	   boolean[][] visit=new boolean[N][M];
	   visit[y][x]=true;
	   qu.offer(new int[] {y,x});
	   while(!qu.isEmpty()) {
		   int[] now =qu.poll();
		   
		   for(int i=0;i<4;i++) {
			   int Y=now[0]+diy[i];
			   int X=now[1]+dix[i];
			   if(X<0||X>=M||Y<0||Y>=N) {//치즈에 쌓인 칸이 아니라는 뜻
				   paint(y,x);
				   return;
			   }else if(X>=0&&X<M&&Y>=0&&Y<N) {
				   if(paper[Y][X]==0&&!visit[Y][X]) {//0아니면 2이이며 visit안되어있으면 담고 계속 확인
					   visit[Y][X]=true;
					   qu.offer(new int[] {Y,X});
				   }
			   }
			   
		   }
	   }
	   
	   paintprotect(y,x);  
   }
   
   public static void paint(int y,int x) {//0을 전부 확인 후 치즈보호 없다는 것이 확인되면 -1로 변경
	   Queue<int[]> qu=new LinkedList<>();
	   paper[y][x]=-1;
	   qu.offer(new int[] {y,x});
	   while(!qu.isEmpty()) {
		   int[] now =qu.poll();
		   
		   for(int i=0;i<4;i++) {
			   int Y=now[0]+diy[i];
			   int X=now[1]+dix[i];
			   if(X>=0&&X<M&&Y>=0&&Y<N) {
				   if(paper[Y][X]==0) {
					   paper[Y][X]=-1;
					   qu.offer(new int[] {Y,X});
				   }
			   } 
		   }
	   } 
   }
   
   public static void paintprotect(int y,int x) {//치즈 보호 확인하면 2로 변경
	   Queue<int[]> qu=new LinkedList<>();
	   paper[y][x]=2;
	   qu.offer(new int[] {y,x});
	   while(!qu.isEmpty()) {
		   int[] now =qu.poll();
		   
		   for(int i=0;i<4;i++) {
			   int Y=now[0]+diy[i];
			   int X=now[1]+dix[i];
			   if(X>=0&&X<M&&Y>=0&&Y<N) {
				   if(paper[Y][X]==0) {
					   paper[Y][X]=2;
					   qu.offer(new int[] {Y,X});
				   }
			   }
			   
		   }
		   
		   
	   }
   }
   
   public static void paintnocheck(int y,int x) {
	   for(int i=0;i<4;i++) {
		   int Y=y+diy[i];
		   int X=x+dix[i];
		   if(X>=0&&X<M&&Y>=0&&Y<N) {
			   if(paper[Y][X]==-1) {
				   repaint(y,x);
			   }
		   }
	   }


   }
   
   public static void repaint(int y,int x) {
	   Queue<int[]> qu=new LinkedList<>();
	   paper[y][x]=-1;
	   qu.offer(new int[] {y,x});
	   while(!qu.isEmpty()) {
		   int[] now =qu.poll();
		   
		   for(int i=0;i<4;i++) {
			   int Y=now[0]+diy[i];
			   int X=now[1]+dix[i];
			   if(X>=0&&X<M&&Y>=0&&Y<N) {
				   if(paper[Y][X]==2) {
					   paper[Y][X]=-1;
					   qu.offer(new int[] {Y,X});
				   }
			   }
			   
		   }
		   
		   
	   }
   }
   
}