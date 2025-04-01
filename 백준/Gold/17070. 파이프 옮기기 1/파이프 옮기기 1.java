import java.io.*;
import java.util.*;

public class Main {
    static int N;   
    static int[][] arr;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        
        for(int i=0;i<N;i++) {
        	StringTokenizer st =new StringTokenizer(br.readLine());
        	for(int k=0;k<N;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        	}
        }
        if(arr[N-1][N-1]==1) {
        	System.out.println(0);
        	return;
        }
        dfs(0,1,0);
        System.out.println(cnt);
        
        
    }
    
    static void dfs(int y,int x,int direct) {//0==가로 1==세로 2==대각선
 
    	     if(y==N-1&&x==N-1) {
    	    	 cnt++;
    	    	return;
    	     }
    		
    	     if(direct==0) {
    	    	if(x+1<N) {
    	    		if(arr[y][x+1]!=1) dfs(y,x+1,0);
    	    	}
    	    	 
    	    	if(x+1<N&&y+1<N) {
    	    		if(check(y,x))  dfs(y+1,x+1,2);
    	    	}
    	    	
    	     }
    	     else if(direct==1) {
    	    	 if(y+1<N) {
     	    		if(arr[y+1][x]!=1)  dfs(y+1,x,1);
     	    	}
     	    	 
     	    	if(x+1<N&&y+1<N) {
     	    		if(check(y,x))  dfs(y+1,x+1,2);
     	    	}
    	    	 
    	     }
    	     else {
    	    	 if(y+1<N) {
      	    		if(arr[y+1][x]!=1)  dfs(y+1,x,1);
      	    	}
    	    	 
    	    	 if(x+1<N) {
     	    		if(arr[y][x+1]!=1)  dfs(y,x+1,0);
     	    	}
      	    	 
      	    	if(x+1<N&&y+1<N) {
      	    		if(check(y,x)) dfs(y+1,x+1,2);
      	    	}
    	     }
    	}
    	
    	
    
    public static boolean check(int y,int x) {
    	
    	if(arr[y][x+1]==1||arr[y+1][x]==1||arr[y+1][x+1]==1)
    		return false;
   
    	return true;
    }
    
  }
 