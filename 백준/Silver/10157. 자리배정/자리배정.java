import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] diy= {0,1,0,-1};
	static int[] dix= {1,0,-1,0};
	
     public static void main(String[] args)throws Exception {
	 BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st =new StringTokenizer(br.readLine());
     int C=Integer.parseInt(st.nextToken());//가로
     int R=Integer.parseInt(st.nextToken());//세로
     int K=Integer.parseInt(br.readLine());
	    
	  int[][] map=new int[C+2][R+2];
      
	  int idx=0;
	  int cnt=1;
	  int y=1;
	  int x=1;
     for(int i=0;i<R*C;i++) {
    	 map[y][x]=cnt;
    	 if(cnt==K) {
    		 System.out.println(y+" "+x);
    		 return;
    	 }
    	 cnt++;
    	 y+=diy[idx]; x+=dix[idx];
    	 if(y<1||y>C||x<1||x>R||map[y][x]>0) {
    		 y-=diy[idx]; x-=dix[idx];
    		 idx++;
    		 if(idx>=4) idx%=4;
        	 y+=diy[idx]; x+=dix[idx];
    	 }
 
     }
     System.out.println(0);
    
     }
 }