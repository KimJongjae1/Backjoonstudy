import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static  StringBuilder sb;
   static int[][][][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {-1,0,1,0};
   static int[] dix= {0,1,0,-1};
   static boolean[] visit;
   static List<Integer> list;
   static int idx;
   static int[][] paper;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        
        arr=new int[K][][][];
        paper=new int[N][M];
        list=new ArrayList<>();
        for(int i=0;i<K;i++) {
        	st=new StringTokenizer(br.readLine());
        	int r=Integer.parseInt(st.nextToken());
        	int c=Integer.parseInt(st.nextToken());
        	list.add(r*100+c);
        	arr[i]=new int[4][][];
        	arr[i][0]=new int[r][c];
        	arr[i][1]=new int[c][r];
        	arr[i][2]=new int[r][c];
        	arr[i][3]=new int[c][r];
        	
        	for(int k=0;k<r;k++) {
        		st=new StringTokenizer(br.readLine());
        		for(int q=0;q<c;q++) {
        			arr[i][0][k][q]=Integer.parseInt(st.nextToken());
        		}
        	}
        	rotate(i);
        }
        
        game();
   
        System.out.println(ans);
        
      
    }
    public static void game() {
    	
    Loop: for(int i=0;i<K;i++) {
    	   for(int dir=0;dir<4;dir++) {	
    		for(int k=0;k<N;k++) {
    			for(int q=0;q<M;q++) {
    				if(stick(k,q,i,dir)) continue Loop;
    			}
    				
    		}
    	 }
    	}
    }
    
    public static boolean stick(int k,int q,int idx,int dir) {
    	int r=list.get(idx)/100;
    	int c=list.get(idx)%100;
    	if(dir%2==1) {
    		int temp=r;
    		r=c;
    		c=temp;
    	}
    	Set<Integer> set=new HashSet<>();
    	if(r+k>N||c+q>M)return false;
    	for(int i=k;i<r+k;i++) {
    		for(int j=q;j<q+c;j++) {
    			if(arr[idx][dir][i-k][j-q]==0)continue;
    			else {
    				if(paper[i][j]==0) {
    					set.add(i*100+j);
    					continue;
    				}
    				else return false;
    			}
    		}
    	}
    	ans+=set.size();
    	for(int loca:set) {
    		int y=loca/100;
    		int x=loca%100;
    		paper[y][x]=1;
    	}
    	return true;
    	
    }
    public static void rotate(int idx) {
       	int r=list.get(idx)/100;
    	int c=list.get(idx)%100;
    	
    	for(int i=0;i<r;i++) {
    		for(int k=0;k<c;k++) {
    			arr[idx][1][k][r-i-1]=arr[idx][0][i][k];	
    		}
    	}
    	
    	for(int i=0;i<c;i++) {
    		for(int k=0;k<r;k++) {
    			arr[idx][2][k][c-i-1]=arr[idx][1][i][k];
    		}
    	}
    	
    	for(int i=0;i<r;i++) {
    		for(int k=0;k<c;k++) {
    			arr[idx][3][k][r-i-1]=arr[idx][2][i][k];
    		}
    	}
    	
    	
    }
    
}