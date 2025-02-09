import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int r;
	static int c;
	static int ans=0;
	public static void divide(int y, int x,int length) {
		
	
		while(true) {
		int count=0;
		
		if(y>=length) {//length 4   2
		count+=2;		
		y-=length;
		}
		
		if(x>=length) {// 3 3 
		count+=1;
		x-=length;
		}
		
		ans+=count*(length*length);//48    
		if(length==1) {//2
			r=y;
			c=x;
			return;
		 }
		length=length/2;//
	
		}
		
	}
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
   
    int length = (int)Math.pow(2, N-1);
   
    divide(r,c,length);
    
    System.out.println(ans);
    
   } 
}