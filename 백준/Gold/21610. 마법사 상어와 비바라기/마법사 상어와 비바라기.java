import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[][] cloud;
	static int N;
	static int M;
	static int max=-1;
	static int[] cloudiy= {0,0,-1,-1,-1,0,1,1,1};
	static int[] cloudix= {0,-1,-1,0,1,1,1,0,-1};
	static int[] diy= {1,-1,1,-1};
	static int[] dix= {1,-1,-1,1};
	static Queue<int[]> qu;
	static Queue<int[]> checkqu;
	static Queue<int[]> rainqu;
     public static void main(String[] args)throws Exception {
     BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st =new StringTokenizer(br.readLine());
     N=Integer.parseInt(st.nextToken());
     M=Integer.parseInt(st.nextToken());
     
     arr= new int[N+2][N+2];
   
     for(int i=1;i<=N;i++) {
    	 st =new StringTokenizer(br.readLine());
    	 for(int k=1;k<=N;k++) {
    		 arr[i][k]=Integer.parseInt(st.nextToken());
    	 }
     }
     
     qu=new LinkedList<>();
     rainqu=new LinkedList<>();
     checkqu=new LinkedList<>();
      qu.offer(new int[] {N-1,1});
      qu.offer(new int[] {N-1,2});
      qu.offer(new int[] {N,1});
      qu.offer(new int[] {N,2});
    
     for(int i=0;i<M;i++) {
    	 
    	 st =new StringTokenizer(br.readLine());
    	 int direction =Integer.parseInt(st.nextToken());
    	 int range =Integer.parseInt(st.nextToken());
    	 cloud=new boolean[N+1][N+1];
    	 
    	 while(!qu.isEmpty()) {
    		 int[] temp=qu.poll();
    		 int[] newcloudpos=cloudmove(temp[0],temp[1],direction,range);
    		 checkqu.offer(newcloudpos);

    	 }
    	 
    	 while(!checkqu.isEmpty()) {
    		 int[] temp=checkqu.poll();
    		 cloudraincheck(temp[0],temp[1]);
    	 }
    	 
    	 while(!rainqu.isEmpty()) {
    		 cloudrain();
    	 }
    	 checknewcloud();
     }
     
     int ans=0;
     for(int i=1;i<=N;i++) {
    	 for(int k=1;k<=N;k++) {
    		 ans+=arr[i][k];
    	 }
     }
     
     System.out.println(ans);
    }
     
     static int[] cloudmove(int y, int x,int direction, int range) {//4 1에서 시작(격자다)
    	 int X=x; int Y=y;
    	 
    	   for(int i=0;i<range;i++) {
    		   X+=cloudix[direction];
    		   Y+=cloudiy[direction];
    		   
    		   if(X==0)X=N;
    		   else if(X==N+1)X=1;
    		   
    		   if(Y==0)Y=N;
    		   else if(Y==N+1)Y=1;
    	   }
 
           cloud[Y][X]=true;
           arr[Y][X]++;
    	   return new int[] {Y,X};
     }
     
     static void cloudraincheck(int Y,int X) {
         int cnt=0;
         
        	   for(int k=0;k<4;k++) {
        		   int Y2=Y+diy[k];
        		   int X2=X+dix[k];
        		   if(Y2>=1&&Y2<=N&&X2>=1&&X2<=N) {
        			   if(arr[Y2][X2]>0) {
        				 cnt++;
        			   }
        		   }
        	   }
        	   rainqu.offer(new int[] {Y,X,cnt});
        	  
	    }
     
     static void cloudrain() {
          int[] temp=rainqu.poll();
          arr[temp[0]][temp[1]]+=temp[2];
	    }
     
     static void checknewcloud() {
   
    	 for(int i=1;i<=N;i++) {
    		 for(int k=1;k<=N;k++) {
    			 if(cloud[i][k]) {
    				 cloud[i][k]=false;
    				 continue; }
    				 
    			 if(arr[i][k]>=2&&!cloud[i][k]) {
    				 cloud[i][k]=true;
    				 qu.offer(new int[] {i,k});
    				 arr[i][k]-=2;
    			 }
    		 }
    	 }
     }
     
     
 }
 