import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static  StringBuilder sb;
   static char[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,0,-1,1};
   static int[] dix= {1,-1,0,0};
   static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        arr=new char[N][N];
        list =new ArrayList<>();
  
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        
        	for(int k=0;k<N;k++) {
        		arr[i][k]=st.nextToken().charAt(0);
        		if(arr[i][k]=='T') list.add(i*N+k);
        	}
        }
        
        
        BACK(0,0);
        if(flag)System.out.println("YES");
        else System.out.println("NO");
    }
    public static void BACK(int Obstacle,int idx) {
    	if(flag)return;
    	if(Obstacle>3)return;
    	if(Obstacle==3||idx>=list.size()) {
    		if(AllStudentSafe()) {
    			flag=true;
    		
    		}
    	}else {
    	
    			int TeacherLocation=list.get(idx);
    			int y=TeacherLocation/N;
    			int x=TeacherLocation%N;
    			BACK(Obstacle,idx+1);
    			
    			for(int i=0;i<4;i++) {
    				if(!CheckIfStudentExist(y,x,i))continue;
    				for(int k=1;k<=N;k++) {
    					int Y=y+diy[i]*k;
    					int X=x+dix[i]*k;
    					if(Y<0||Y>=N||X<0||X>=N) break;
    					
    					if(arr[Y][X]!='X') break;
    					
    					arr[Y][X]='O';
    					BACK(Obstacle+1,idx);
    					BACK(Obstacle+1,idx+1);
    					arr[Y][X]='X';
    					if(flag)return;
    					
    				}
    				
    				
    			}
    		
    	}
    	
    	
    }
    public static boolean AllStudentSafe() {
    	
    	for(int TeacherLocation:list) {
    		int y=TeacherLocation/N;
			int x=TeacherLocation%N;
		Loop:for(int i=0;i<4;i++) {
				for(int k=1;k<=N;k++) {
					int Y=y+diy[i]*k;
					int X=x+dix[i]*k;
					if(Y<0||Y>=N||X<0||X>=N) continue Loop;
					if(arr[Y][X]=='O')continue Loop;
					if(arr[Y][X]=='S')return false;
				}
			}
    	}
    	
    	return true;
    	
    }
    public static boolean CheckIfStudentExist(int y,int x,int dir) {
    	
    	for(int i=1;i<=N;i++) {
    		int Y=y+diy[dir]*i;
			int X=x+dix[dir]*i;
			if(Y<0||Y>=N||X<0||X>=N) return false;
			if(arr[Y][X]=='O')return false;
			if(arr[Y][X]=='S')return true;

    	}
    	return false;
    }
}