import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] visit;
    static int[] diy= {1,1,1};
    static int[] dix= {-1,0,1};
    static int ans=0;
 	public static void main(String args[])throws IOException {
 	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

 		 N=Integer.parseInt(br.readLine());
 		 visit=new int[N+1][N+1];
 		 ans=0;
 		 
 		 chess(1);
 		 System.out.println(ans);
 	
  }
 public static void chess(int queennum) {
	 if(queennum==N+1) {
		 ans++;
	 }else {
		 for(int i=1;i<=N;i++) {
			 if(visit[queennum][i]==0) {
				 queen(queennum,i);
				 visit[queennum][i]++;
				 chess(queennum+1);
				 visit[queennum][i]--;
				 init(queennum,i);
			 }
		 }
	 }
 }
  
 public static void queen(int y, int x) {
	     for(int i=0;i<3;i++) {
	    	 int Y=y+diy[i]; int X=x+dix[i];
	    	 while(Y<=N&&X<=N&&X>=1) {
	    		 visit[Y][X]++;
	    		 Y+=diy[i];
	    		 X+=dix[i];
	    	 }
	    	 
	     }
 }
 public static void init(int y,int x) {
	 for(int i=0;i<3;i++) {
    	 int Y=y+diy[i]; int X=x+dix[i];
    	 while(Y<=N&&X<=N&&X>=1) {
    		 visit[Y][X]--;
    		 Y+=diy[i];
    		 X+=dix[i];
    	 }
    	 
     }
 }
}