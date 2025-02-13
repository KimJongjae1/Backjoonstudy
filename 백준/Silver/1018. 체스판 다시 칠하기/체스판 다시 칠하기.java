import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
		
	    char[][] chess = new char[N][M];
	    
	    for(int i=0;i<N;i++) {
	    	String str=br.readLine();
	    	for(int k=0;k<M;k++) {
	    		chess[i][k]=str.charAt(k);
	    		
	    	}
	    }
	    char[][] bchess = new char[N][M];
	    char[][] wchess = new char[N][M];
	    bchess[0][0]='B';
	    wchess[0][0]='W';
	    for(int i=1;i<8;i++) {
	    	if(bchess[i-1][0]=='B')
	    	bchess[i][0]='W';
	    	else {bchess[i][0]='B';}
	    	
	    	if(wchess[i-1][0]=='W')
		    	wchess[i][0]='B';
		    	else {wchess[i][0]='W';}
	    }
	    
	    for(int i=0;i<8;i++) {
	    	for(int k=1;k<8;k++) {
	    		if(bchess[i][k-1]=='B') 
	    			bchess[i][k]='W';
	    		else {bchess[i][k]='B';}
	    		
	    		if(wchess[i][k-1]=='B') 
	    			wchess[i][k]='W';
	    		else {wchess[i][k]='B';}
	    		
	    	}
	    }

	    int min=N*M+1;
	    int bcount=0;
	    int wcount=0;
	    for(int q=0;q<=N-8;q++) {
	    	for(int w=0;w<=M-8;w++) {

	    		for(int i=0;i<8;i++) {
	    			for(int k=0;k<8;k++) {
	    				if(chess[i+q][k+w]!=bchess[i][k])
	    					bcount++;
	    		
	    				if(chess[i+q][k+w]!=wchess[i][k])
	    					wcount++;
	    			}
	    		}
	    		 min=Math.min(min, Math.min(bcount,wcount));
		    		bcount=0;
		    		wcount=0;
	    	}
	    }
	  
	    System.out.println(min);
	}
  }
