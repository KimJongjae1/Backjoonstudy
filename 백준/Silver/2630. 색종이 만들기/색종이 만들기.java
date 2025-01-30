import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    
	static int white=0;
	static int black=0;
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    int N = Integer.parseInt(br.readLine());
    int[][] paper = new int[N][N];
    StringTokenizer st;
    for(int i=0;i<N;i++) {
    	 st = new StringTokenizer(br.readLine());
    	for(int k=0;k<N;k++) {
    		paper[i][k] = Integer.parseInt(st.nextToken());
    	}
    }
    
    divide(paper, 0,0,N);
    System.out.println(white);
    System.out.println(black);
    
 }  
    
    public static void divide(int[][] a, int x, int y, int size) {
    	if(check(a,x,y,size)) {
    		if(a[y][x]==0) {
    			white++;
    		}else {
    			black++;
    		}
    		return;
    	}
    	
    	int newsize = size/2;
    	
    	divide( a, x+newsize, y,  newsize);
    	divide( a, x, y+newsize, newsize);
    	divide( a, x+newsize,  y+newsize, newsize);
    	divide( a, x, y,  newsize);
    	
    }
    
    
    
    public static boolean check(int[][] a, int x,int y, int size) {
    	int temp = a[y][x];
    	
    	for(int i=y;i<y+size;i++) {
    		for(int k=x;k<x+size;k++) {
    			if(a[i][k]!=temp) {
    				return false;
    			}
    		}
    	}
    	return true;
    	
    	
    }
    
    
    
}