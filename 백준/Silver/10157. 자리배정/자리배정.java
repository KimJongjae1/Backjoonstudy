import java.io.IOException;
import java.util.Scanner;
public class Main {
	
	
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
  
       int C=scan.nextInt();
       int R=scan.nextInt();
       int K=scan.nextInt();
       
       if(K>C*R) {
    	   System.out.println(0);
    	   return;
       }
       
       int[][] seat = new int[C+2][R+2];
       int[] dx = {0,1,0,-1};
       int[] dy = {1,0,-1,0};
       int x=1;
       int y=1;
       int px=0;
       int py=0;
    		   
       for(int i=1;i<=R*C;i++) {
    	   seat[x][y]=i;
    	   
    	   if(seat[x][y]==K) {
    		   System.out.print(x+" "+y);
    		   break;
    	   }
    	   x+=dx[px];
    	   y+=dy[py];
    	   
    	   if(x==0||y==0||x==(C+1)||y==(R+1)||seat[x][y]>=1) {
    		   x-=dx[px];
    		   y-=dy[py];
    		   px=(px+1)%4;
    		   py=(py+1)%4;
    		   x+=dx[px];
    		   y+=dy[py];
    	   }
       }  
       

    }  
}