import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static int idxB;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][][][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[][] visit;
   static List<int[]>[][] list;
   static Set<Integer> set;  
   static Map<Integer,Integer> map;
   static class shark{
	   int dir;
	   int size;
	   int speed;
	   int y;
	   int x;
	   boolean dead;
	   shark(int dir,int size,int speed,int y,int x){
		   this.dir=dir;
		   this.size=size;
		   this.speed=speed;
		   this.y=y;
		   this.x=x;
	   }
	  
   }
 
   static shark[] sharks; 
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer.parseInt(st.nextToken());
		 M=Integer.parseInt(st.nextToken());
		 G=Integer.parseInt(st.nextToken());
		 arr=new int[N+1][M+1];
		 idx=1;
		 sharks=new shark[G+1];
		 for(int i=1;i<=G;i++) {
			 st=new StringTokenizer(br.readLine());
			 int r=Integer.parseInt(st.nextToken());
			 int c=Integer.parseInt(st.nextToken());
			 int s=Integer.parseInt(st.nextToken());
			 int d=Integer.parseInt(st.nextToken());
			 int z=Integer.parseInt(st.nextToken());
			 sharks[i]=new shark(d,z,s,r,c);
			 arr[r][c]=idx++;
		 }
		 Fishing();
		 System.out.println(ans);
    }
    public static void Fishing() {
    	
    	for(int i=1;i<=M;i++) {
    		for(int k=1;k<=N;k++) {
    			if(arr[k][i]>0) {
    				ans+=sharks[arr[k][i]].size;
    				sharks[arr[k][i]].dead=true;
    				arr[k][i]=0;
    				break;
    			}
    		}
    		MOVE();
    	}
    }
    public static void MOVE() {
    	Map<Integer,List<Integer>> m=new HashMap<>();
    	for(int i=1;i<=G;i++) {
    		if(sharks[i].dead)continue;
    		int dir=sharks[i].dir;
    		int Y=sharks[i].y+diy[dir]*sharks[i].speed;
    		int X=sharks[i].x+dix[dir]*sharks[i].speed;
    		if(!range(Y,X)) {
    			int[] NewInfo=RangeOutMove(sharks[i].y,sharks[i].x,sharks[i].speed,dir);
    			Y=NewInfo[0];
    			X=NewInfo[1];
    			dir=NewInfo[2];
    			
    		}
    		arr[sharks[i].y][sharks[i].x]=0;
    		sharks[i].y=Y;
    		sharks[i].x=X;
    		sharks[i].dir=dir;
    		
    		if(!m.containsKey(Y*M+X))m.put(Y*M+X, new ArrayList<>());
    		m.get(Y*M+X).add(i);
    		
    	}
    	
    	for(int key:m.keySet()) {
    		List<Integer> temp=m.get(key);
    		if(temp.size()==1) {
    			sharkIN(temp.get(0));
    			continue;
    		}
    		else {
    			int max=0;
    			int i=-1;
    			for(int id:temp) {
    				if(max<sharks[id].size) {
    					max=sharks[id].size;
    					i=id;
    				}
    			}
				sharkIN(i);
    			for(int id:temp) {
    				if(i==id) continue;
    				
    				sharks[id].dead=true;
    			}
    		}
    	}
    	
    }
    public static boolean range(int Y,int X) {
    	if(Y<1||Y>N||X<1||X>M) return false;
    	return true;
    }
    public static int[] RangeOutMove(int y,int x,int speed,int dir) {
    	int cnt=speed;
    	int d=dir;
    	int Y=y;
    	int X=x;
    	if(dir==1) {//y -1
    		cnt+=N-y;
    		int n=cnt/(N-1);
    		int left=cnt%(N-1);
    		if(n%2==1) {Y=1+left;d=2;}
    		else {Y=N-left;}
    	}else if(dir==2) {//y 1
    		cnt+=y-1;
    		int n=cnt/(N-1);
    		int left=cnt%(N-1);
    		if(n%2==1) {Y=N-left;d=1;}
    		else {Y=1+left;}
    	}else if(dir==3) {//x 1
    		cnt+=x-1;
    		int n=cnt/(M-1);
    		int left=cnt%(M-1);
    		if(n%2==1) {X=M-left;d=4;}
    		else {X=1+left;}
    	}else {//x -1
    		cnt+=M-x;
    		int n=cnt/(M-1);
    		int left=cnt%(M-1);
    		if(n%2==1) {X=1+left;d=3;}
    		else {X=M-left;}
    	}
    	
    	
    	return new int[] {Y,X,d};
    	
    	
    }
    public static void sharkIN(int id) {
    	shark s=sharks[id];
    	arr[s.y][s.x]=id;
    }
}