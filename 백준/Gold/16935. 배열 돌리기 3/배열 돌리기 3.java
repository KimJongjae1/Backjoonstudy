import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<int[]> list;
   static Set<int[]> set;
   static int MaxCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        
        
        arr=new int[N][M];

        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int k=0;k<M;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        	}
        }
        
        st=new StringTokenizer(br.readLine());
        while(st.hasMoreElements()) {
        	int order=Integer.parseInt(st.nextToken());
        	switch(order) {
	        	case 1: {
	        		ONE();
	        		break;
	        	}
	        	case 2: {
	    			TWO();
	    			break;
	        	}
	        	case 3: {
	    			THREE();
	    			break;
	        	}
	        	case 4: {
	    			FOUR();
	    			break;
	        	}	
	        	case 5: {
	    			FIVE();
	    			break;
	        	}
	        	case 6: {
	    			SIX();
	    			break;
	        	}
        	}
        }
        for(int i=0;i<N;i++) {
        	 for(int a:arr[i]) {
        		 sb.append(a+" ");
        	 }sb.append("\n");
        }
       
        System.out.println(sb);
        
        
    }
    public static void ONE() {
    	
    	for(int k=0;k<M;k++) {
    		for(int i=0;i<N/2;i++) {
    			int temp=arr[i][k];
    			arr[i][k]=arr[N-i-1][k];
    			arr[N-i-1][k]=temp;
    		
    		}
    	
    	}
    }
    public static void TWO() {
    	
    
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<M/2;k++) {
    			int temp=arr[i][k];
    			arr[i][k]=arr[i][M-k-1];
    			arr[i][M-k-1]=temp;
    		}
    	}
    	
    }
    
    public static void THREE() {
    	int[][] temp =new int[M][N];
    	
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<M;k++) {
    			temp[k][N-i-1]=arr[i][k];
    		}
    	}
    	int t=N;
    	N=M;
    	M=t;
    	arr=temp;
    }
    
    public static void FOUR() {
    	int[][] temp =new int[M][N];
    	
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<M;k++) {
    			temp[M-k-1][i]=arr[i][k];
    		}
    	}
    	int t=N;
    	N=M;
    	M=t;
    	arr=temp;
    }
    
    public static void FIVE() {

    	for(int i=0;i<N/2;i++) {
    		
    		for(int k=0;k<M/2;k++) {
    			int temp=arr[i][k];
    			arr[i][k]=arr[i+N/2][k];
    			arr[i+N/2][k]=arr[i+N/2][k+M/2];
    			arr[i+N/2][k+M/2]=arr[i][k+M/2];
    			arr[i][k+M/2]=temp;
    		}
    	}
    
    }
    
    public static void SIX() {
  	for(int i=0;i<N/2;i++) {
    		
    		for(int k=0;k<M/2;k++) {
    			int temp=arr[i][k];
    			arr[i][k]=arr[i][k+M/2];
    			arr[i][k+M/2]=arr[i+N/2][k+M/2];
    			arr[i+N/2][k+M/2]=arr[i+N/2][k];
    			arr[i+N/2][k]=temp;
    		}
    	}
    }
}