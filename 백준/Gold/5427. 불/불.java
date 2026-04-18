import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static char[][] arr;
     static List<int[]> list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static long ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static Queue<int[]> hu;
    static Queue<int[]> fire;
    static boolean flag;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        int T=Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++){
        	st=new StringTokenizer(br.readLine());
        	M=Integer.parseInt(st.nextToken());
        	N=Integer.parseInt(st.nextToken());
      
        	arr=new char[N][M];
        	hu=new LinkedList<>();
        	fire=new LinkedList<>();
        	flag=false;
        	for(int i=0;i<N;i++) {
        		String str=br.readLine();
        		for(int k=0;k<M;k++) {
        			arr[i][k]=str.charAt(k);
        			if(arr[i][k]=='@') {
        				hu.offer(new int[] {i,k,0});
        			}else if(arr[i][k]=='*') {
        				fire.offer(new int[] {i,k});
        			}
        		}
        	}
        	
        	while(true) {
        		
        		Human();
        		if(hu.size()==0) break;
        		if(flag)break;
        		
        		FIRE();
        	}
        	if(!flag)sb.append("IMPOSSIBLE");
        	sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void Human() {
    	int s=hu.size();
    	for(int i=0;i<s;i++) {
    		int[] cur=hu.poll();
    		int y=cur[0];
    		int x=cur[1];
    		if(arr[y][x]!='@')continue;
    		
    		for(int k=0;k<4;k++) {
    			int Y=y+diy[k];
    			int X=x+dix[k];
    			if(Y<0||Y>=N||X<0||X>=M) {
    				sb.append(cur[2]+1);
    				flag=true;
    				return;
    			}
    			if(arr[Y][X]!='.')continue;
    			arr[Y][X]='@';
    			hu.offer(new int[] {Y,X,cur[2]+1});
    			
    		}
    	}
    	
    }
    public static void FIRE() {
    	int s=fire.size();
    	for(int i=0;i<s;i++) {
    		int[] cur=fire.poll();
    		int y=cur[0];
    		int x=cur[1];
    		
    		for(int k=0;k<4;k++) {
    			int Y=y+diy[k];
    			int X=x+dix[k];
    			if(Y<0||Y>=N||X<0||X>=M) continue;
    			if(arr[Y][X]=='#'||arr[Y][X]=='*')continue;
    			arr[Y][X]='*';
    			fire.offer(new int[] {Y,X});
    		}
    		
    	}
    }
}