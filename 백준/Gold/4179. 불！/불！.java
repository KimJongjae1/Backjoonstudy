import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	static int N;
    static int M;
    static char[][] arr;
    static Queue<pair> fire;
    static Queue<pair> jihoon;
    static int[] diy= {-1,1,0,0};
    static int[] dix= {0,0,-1,1};
    static class pair{
    	int y;
    	int x;
    	
    	pair(int y,int x){
    		this.y=y;
    		this.x=x;
    	}
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
         M=Integer.parseInt(st.nextToken());
        
        arr=new char[N][M];
        fire=new LinkedList<>();
        jihoon=new LinkedList<>();
        for(int i=0;i<N;i++) {
        	String str=br.readLine();
        	for(int k=0;k<M;k++) {
        		arr[i][k]=str.charAt(k);
        		if(arr[i][k]=='J') {
        			jihoon.offer(new pair(i,k));
        		}else if(arr[i][k]=='F') {
        			fire.offer(new pair (i,k));
        		}
        		
        	}
        }
        int ret=BFS();
        if(ret==-1) System.out.println("IMPOSSIBLE");
        else System.out.println(ret);
    }
    public static int BFS() {
    	int ret=0;
    	boolean escape=false;
    	Loop:while(!jihoon.isEmpty()) {
    		ret++;
    		int size=fire.size();
    		for(int i=0;i<size;i++) {
    			pair f=fire.poll();
    			for(int k=0;k<4;k++) {
    				int Y=f.y+diy[k];
    				int X=f.x+dix[k];
    				if(Y<0||Y>=N||X<0||X>=M) continue;
    				if(arr[Y][X]=='#'||arr[Y][X]=='F') continue;
    				arr[Y][X]='F';
    				fire.offer(new pair(Y,X));
    			}
    		}
    		
    		size=jihoon.size();
    		for(int i=0;i<size;i++) {
    			pair j=jihoon.poll();
    			for(int k=0;k<4;k++) {
    				int Y=j.y+diy[k];
    				int X=j.x+dix[k];
    				if(Y<0||Y>=N||X<0||X>=M) {
    					escape=true;
    					break Loop;
    				}
    				if(arr[Y][X]=='.') {
    					arr[Y][X]='J';
    					jihoon.offer(new pair(Y,X));
    				}
    			}
    			
    			
    		}
    		
    		
    		
    	}
    	if(escape) return ret;
    	else return -1;
    	
    }
  
}