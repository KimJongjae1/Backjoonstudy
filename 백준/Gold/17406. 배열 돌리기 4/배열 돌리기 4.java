import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
     static int N;
     static int M;
     static int K;
     static int[] diy= {0,1,0,-1};
     static int[] dix= {1,0,-1,0};
     static int[][] rotate;
     static int[][] arr;
     static int[][] samearr;
     static boolean[] visit;
     static ArrayList<Integer> list=new ArrayList<>();
     static int min=Integer.MAX_VALUE;
     
     public static void main(String[] args)throws Exception {
     BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st =new StringTokenizer(br.readLine());
     
     N=Integer.parseInt(st.nextToken());
     M=Integer.parseInt(st.nextToken());
     K=Integer.parseInt(st.nextToken());
     arr =new int[N+1][M+1];
     samearr =new int[N+1][M+1];
     
     for(int i=1;i<=N;i++) {
    	 st =new StringTokenizer(br.readLine());
    	 for(int k=1;k<=M;k++ ) {
    		 arr[i][k]=Integer.parseInt(st.nextToken());
    		 samearr[i][k]=arr[i][k];
    	 }
     }
     
     rotate=new int[K][3];
     visit =new boolean[K];
      for(int i=0;i<K;i++) {
    	  st =new StringTokenizer(br.readLine());
    	  rotate[i][0]=Integer.parseInt(st.nextToken());
    	  rotate[i][1]=Integer.parseInt(st.nextToken());
    	  rotate[i][2]=Integer.parseInt(st.nextToken());
      }
    	 
     bfs();
      
      System.out.println(min);
     }
     
     public static void bfs() {
    	 if(list.size()==K) {
	    		 for(int a:list) {
	    			 rotation(arr,rotate[a][0]-rotate[a][2],rotate[a][1]-rotate[a][2],rotate[a][2]);
	  
	    		 }
	    		 for(int i=1;i<=N;i++) {
	      	    	  int sum=0;
	      	    	  for(int k=1;k<=M;k++) {
	      	    		  sum+=arr[i][k];
	      	    	  }
	      	    	  min=Math.min(sum, min);
	      	      	}
	   			 init();
	    		 return;
    	 }
    	 
    	 else {
	    		 for(int i=0;i<K;i++) {
	    			 if(!visit[i]) {
	    				 visit[i]=true;
	    				 list.add(i);
	    				 bfs();
	    				 list.remove(list.size()-1);
	    				 visit[i]=false;
	    			 }
	    		 }
    	 }
    	 
     }
     
     
     public static void rotation(int[][] arr,int rs,int cs, int cnt ) {
    	 if(cnt==0) return;
    	 
    	 int selectdir=0;
    	 Queue<Integer> qu = new LinkedList<>();
    	 qu.offer(arr[rs][cs]);
    	 int x=cs; int y=rs;
    	 while(selectdir<4) {
    	      
    		 for(int i=1;i<=4;i++) {
    			 for(int k=1;k<=2*cnt;k++) {
    				 	int Y=y+diy[selectdir]; 
    				 	int X=x+dix[selectdir];
    	    		 
    	        		 qu.offer(arr[Y][X]);
    	        		 arr[Y][X]=qu.poll();	
    	        		 x=X;
    	        		 y=Y;
    			 }
    			 selectdir++;
    		 }
    	 }
    	 rotation(arr,rs+1,cs+1,cnt-1); 
     }
     
     public static void init() {
    	 
    	 for(int i=1;i<=N;i++) {
    		 for(int k=1;k<=M;k++) {
    			arr[i][k]=samearr[i][k];
    		 }
    	 }
    	 
     }
     
}