import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	  static int[] dix= {0,0,1,1};
	  static int[] diy= {0,1,0,1};
	  static int N;
	  static int ans=0;
	  public static void move(int[][] a, int r,int c,int status) {
		
          if(r==N-1&&c==N-1) {
        	  ans++;
        	  return;
          }
		  
		  for(int i=1;i<=3;i++) {
			  int Y=r+diy[i];
			  int X=c+dix[i];
			  
			  if(Y>=N||X>=N)  continue;    
			 
			   if(status==2&&i!=1) { 
				 if(i==2&&a[Y][X]==1) continue; 
				 else if(i==3&&(a[r+1][c]==1||a[r][c+1]==1||a[Y][X]==1)) continue;
				 
				 move(a,Y,X,i); 
				}
			   
			   else if(status ==1&&i!=2) { 
				   if(i==1&&a[Y][X]==1) continue; 
					 else if(i==3&&(a[r+1][c]==1||a[r][c+1]==1||a[Y][X]==1)) continue;
			   
				   move(a,Y,X,i); 
			   }
			   
			   else if(status==3) {
				   if(i==2&&a[Y][X]==1) continue; 
				   else if(i==1&&a[Y][X]==1) continue; 
				   else if(i==3&&(a[r+1][c]==1||a[r][c+1]==1||a[Y][X]==1)) continue;
				   
			   move(a,Y,X,i); 
			   }
			  
		
		  }
	  }
	
	
     public static void main(String[] args)throws Exception {
     BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
     N=Integer.parseInt(br.readLine());	 
     
     int[][] arr = new int[N][N];
     for(int i=0;i<N;i++) {
    	 StringTokenizer st = new StringTokenizer(br.readLine());
    	 for(int k=0;k<N;k++) {
    		 arr[i][k]=Integer.parseInt(st.nextToken());
    	 }
     }
    
     move(arr,0,1,2);
     
     System.out.println(ans);
     
     
    
    }
    
     
}
