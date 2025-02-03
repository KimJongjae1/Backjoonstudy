import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
	
	static int[] dix = {-1,1,0,0};
	static int[] diy = {0,0,-1,1};
	static int count=0;
	static boolean[][] check;
	static int N;
	static int M;
	public static void search(char[][] a,int x,int y) {
		check[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int c=dix[i]+x;
			int b=diy[i]+y;
			
			if(c<0||c>=N||b<0||b>=M) continue;
			
			if(check[c][b]==false) {
				if(a[c][b]=='X') {
				check[c][b]=true;
				continue;
				}
				else if(a[c][b]=='O') {
				search(a,c,b);
				}else if(a[c][b]=='P') {
				count++;
				search(a,c,b);
				}
			}
		}
	}
	
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    StringTokenizer st = new StringTokenizer(br.readLine());
   
    N=Integer.parseInt(st.nextToken());
    M=Integer.parseInt(st.nextToken());
    char[][] school =new char[N][M];
    check = new boolean[N][M];
    int x=0; int y=0;
    	for(int i=0;i<N;i++) {
    		String str=br.readLine();
    		for(int k=0;k<M;k++) {
    			school[i][k]=str.charAt(k);
    			if(str.charAt(k)=='I') {
    				x=i;
    				y=k;
    			}
    		}
    	}
    	
    	search(school,x,y);
    	if(count!=0)
    	System.out.println(count);
    	else {
    		System.out.println("TT");
    	}
   } 
}