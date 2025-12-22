import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static int G;
   static int R;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,0,0,-1,1};
   static int[] dix= {0,1,-1,0,0};
   static boolean[][] visit;
   static List<Integer> list;
   static List<chess>[][] chessboard;
   static int idx;
   static class chess{
	   int id;
	   int dir;
	   int loca;
	   chess(int id,int dir,int loca){
		   this.id=id;
		   this.dir=dir;
		   this.loca=loca;
	   }
   }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
      
        arr=new int[N][N];
        chessboard=new ArrayList[N][N];
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int k=0;k<N;k++) {
        		arr[i][k]=Integer.parseInt(st.nextToken());
        		chessboard[i][k]=new ArrayList<>();
        	}
        }
        chess[] ch=new chess[M];
        
        for(int k=0;k<M;k++) {
        	st=new StringTokenizer(br.readLine());
        	int y=Integer.parseInt(st.nextToken())-1;
        	int x=Integer.parseInt(st.nextToken())-1;
        	int dir=Integer.parseInt(st.nextToken());
        	ch[k]=new chess(k+1,dir,y*N+x);
        	chessboard[y][x].add(ch[k]);
        }

        while(idx<=1000) {
        	for(int i=0;i<M;i++) {
        		game(ch[i]);
        	}
     
        	idx++;
        	if(flag)break;
        }
        if(idx>1000)System.out.println(-1);
        else System.out.println(idx);
    	
    }
    public static void game(chess ch) {
    	
    	
    		int loca=ch.loca;
    		int y=loca/N;
    		int x=loca%N;
    		int dir=ch.dir;

    		int Y=y+diy[dir];
    		int X=x+dix[dir];
    		
    		if(Y<0||Y>=N||X<0||X>=N||arr[Y][X]==2) {
    			int newdir=changeDirect(dir);
    			Y=y+diy[newdir];
    			X=x+dix[newdir];
    			ch.dir=newdir;
    			if(Y<0||Y>=N||X<0||X>=N||arr[Y][X]==2) return;
    			game(ch);
    		}else if(arr[Y][X]==0) {//흰
    			move(y,x,Y,X,0,ch.id);
    		}else {//붉
    			move(y,x,Y,X,1,ch.id);
    		}
    		
    		
    	
    	
    }
    public static int changeDirect(int dir) {
    	if(dir==1)return 2;
    	if(dir==2)return 1;
    	if(dir==3)return 4;
    	if(dir==4)return 3;
    	return 0;
    }
    public static void move(int y,int x,int Y,int X,int color,int id) {
    	List<chess> temp=new ArrayList<>();
    	for(int i=0;i<chessboard[y][x].size();i++) {
    		if(chessboard[y][x].get(i).id==id) {
    			if(color==0) {
    			for(int k=i;k<chessboard[y][x].size();k++) 
    				temp.add(chessboard[y][x].get(k));
    			}
    			else {
    				for(int k=chessboard[y][x].size()-1;k>=i;k--) 
        				temp.add(chessboard[y][x].get(k));
    			}
    			
    			for(int k=chessboard[y][x].size()-1;k>=i;k--)
    				chessboard[y][x].remove(k);
    			
    			break;
    		}
    	}
    	

    	
    	for(int i=0;i<temp.size();i++) {
    		temp.get(i).loca=Y*N+X;
    		chessboard[Y][X].add(temp.get(i));
    	}
    	
    	if(chessboard[Y][X].size()>=4)flag=true;
    	
    }
}