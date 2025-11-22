import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[][] arr;
   static int ans;
   static int[] diy= {1,-1,0,0};
   static int[] dix= {0,0,1,-1};
   static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

    
       // N=Integer.parseInt(st.nextToken());
        
       Loop: for(int t=0;t<3;t++) {
        	arr=new int[6][6];
        	List<Integer> list=new ArrayList<>();
     
            
        	for(int i=0;i<6;i++) {
        		StringTokenizer st=new StringTokenizer(br.readLine());
        		for(int k=0;k<6;k++) {
        			arr[i][k]=Integer.parseInt(st.nextToken());
        			if(arr[i][k]==1) {
        				list.add(6*i+k);
        			}
        		}
        	}
        	check=new boolean[36];

        	for(int s:list) {
        		int y=s/6;
        		int x=s%6;
        	
        		if(!check[s]) {
        			if(!ifline(y,x)) {
        				if(!ifcurve(y,x)) {
        					System.out.println("no");
        					continue Loop;
        				}
        			}
        		
        		}
        	}
        	System.out.println("yes");
        	
        }
       
    }
    public static boolean ifline(int y,int x) {
    	for(int i=0;i<4;i++) {
    		int Y=y+diy[i]*2;
    		int X=x+dix[i]*2;
    		
    		if(Y<0||Y>=6||X<0||X>=6)continue;
    		if(arr[Y][X]==1) {
    			if(check[Y*6+X])return false;
				check[Y*6+X]=true;
				check[y*6+x]=true;
				return true;
    		}
    	}
    	return false;
    }
    
    
   
    public static boolean ifcurve(int y,int x) {
    	
    	for(int i=0;i<4;i++) {
    		int Y=y+diy[i];
    		int X=x+dix[i];
    		if(Y<0||Y>=6||X<0||X>=6)continue;
    		
    		if(arr[Y][X]==1) {
    			
    			
    			Loop:for(int k=0;k<4;k++) {
    				if(k==i)continue;
    				int ty=Y+diy[k];
    				int tx=X+dix[k];
    				if(ty<0||ty>=6||tx<0||tx>=6)continue;
    				if(ty==y&&tx==x)continue;
    			
    				
    				while(arr[ty][tx]==1) {
    					int tY=ty+diy[i];
    					int tX=tx+dix[i];
    					if(tY<0||tY>=6||tX<0||tX>=6) continue Loop;
    					if(arr[tY][tX]==1) {
    						if(check[tY*6+tX]) return false;
    						check[tY*6+tX]=true;
    						check[y*6+x]=true;
    						return true;
    					}
    					
    					ty+=diy[k];
    					tx+=dix[k];
    					if(ty<0||ty>=6||tx<0||tx>=6)break;
    					
    					
    				}
    				
    				
    			}
    			
    			
    		}
    		
    	}
    	return false;
    	
    	
   }
}