import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int ans;
	static StringBuilder sb;
	static BufferedReader br;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
	     int H= Integer.parseInt(st.nextToken());
	     int W=Integer.parseInt(st.nextToken());
	     int Y=Integer.parseInt(st.nextToken());
	     int X=Integer.parseInt(st.nextToken());
	     
	     arr=new int[H+Y][W+X];

	     for(int i=0;i<H+Y;i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 for(int k=0;k<W+X;k++) {
	    		 arr[i][k]=Integer.parseInt(st.nextToken());
	    	 }
	     }
	     
	     for(int i=0;i<H;i++) {
	    	 for(int k=0;k<W;k++) {
	    		 int y=i-Y;
	    		 int x=k-X;
	    		 if(y<0||y>=H||x<0||x>=W) {
	    			 sb.append(arr[i][k]+" ");
	    			 continue;
	    		 }
	    		 arr[i][k]-=arr[y][x];
	    		 sb.append(arr[i][k]+" ");
	    	 }
	    	 sb.append("\n");
	     }
	     System.out.println(sb);
	     
	     
    }
    
    
}