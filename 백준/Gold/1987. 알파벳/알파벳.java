
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	 static int C; 
	 static int R; 
	 static char[][] board;
	 static boolean[] alpha;
	 static int max=0;
	 static int[] dix= {1,-1,0,0};
	 static int[] diy= {0,0,1,-1};
     public static void main(String[] args)throws Exception {
	 BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
	    R=Integer.parseInt(st.nextToken());
	    C=Integer.parseInt(st.nextToken());
	    
	    board=new char[R+1][C+1];
	    alpha=new boolean[26];
	    Arrays.fill(alpha, true);
	    for(int i=1;i<=R;i++) {
	    	String temp =br.readLine();
	    	for(int k=0;k<C;k++) {
	    		board[i][k+1]=temp.charAt(k);
	    		alpha[board[i][k+1]-'A']=false;
	    	}
	    }
	    alpha[board[1][1]-'A']=true;
	    back(1,1,1);
	    System.out.println(max);
	    
     }
     static void back(int cnt,int y,int x) {
    	 int moveX=0;
    	 
    	 for(int i=0;i<4;i++) {
    	     int Y=y+diy[i];
    	     int X=x+dix[i];
    	     moveX++;
    	     if(Y>=1&&Y<=R&&X>=1&&X<=C) {
    	    	 int idx=board[Y][X]-'A';
    	    	if(!alpha[idx]) {
    	    		moveX--;
    	    		alpha[idx]=true;
    	    		back(cnt+1,Y,X);
    	    		alpha[idx]=false;
    	    	}
    	     }
    	 }
    	 if(moveX==4) {
    		 max=Math.max(cnt, max);
    	 }
    	 
     }
  
 }