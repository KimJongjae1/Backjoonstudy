import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int[][] dp;
     static int[][] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
     static int[] diy= {-1,1,0,0};
     static int[] dix= {0,0,-1,1};
     static boolean flag;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
         int T=1;
 
        while(true) { 

	        StringTokenizer st=new StringTokenizer(br.readLine());
	        N=Integer.parseInt(st.nextToken());
	      
	        if(N==0)break;
	
	        sb.append("Puzzle"+" "+T).append("\n");
	        set=new HashSet<>();
	        T++;
	        visit=new boolean[100];
	        for(int i=1;i<9;i++) {
	        	for(int k=i+1;k<=9;k++) {
	        		set.add(i*10+k);
	        	}
	        }
	         arr=new int[9][9];
	         flag=false;
	         for(int i=0;i<N;i++) {
	        	 st=new StringTokenizer(br.readLine());
	  
		        	 int v1=Integer.parseInt(st.nextToken());
		        	 String a=st.nextToken();
		        	 int y1=a.charAt(0)-'A';
		        	 int x1=a.charAt(1)-'1';
		        	 arr[y1][x1]=v1;
		        	 
		        	 int v2=Integer.parseInt(st.nextToken());
		        	 String b=st.nextToken();
		        	 int y2=b.charAt(0)-'A';
		        	 int x2=b.charAt(1)-'1';
		        	 arr[y2][x2]=v2;
		        	 
		        	 if(v1>v2) {
		        		 set.remove(v2*10+v1);
		        		 visit[v2*10+v1]=true;
		        	 }
		        	 else {
		        		 set.remove(v1*10+v2);
		        		 visit[v1*10+v2]=true;
		        	 }
	         }
	         st=new StringTokenizer(br.readLine());
	         for(int i=1;i<=9;i++) {
	        	 String a=st.nextToken();
	        	 int y=a.charAt(0)-'A';
	        	 int x=a.charAt(1)-'1';
	        	 arr[y][x]=i;
	         }
	         BACK(0,0);
	        
        }
        System.out.println(sb);
    }
    public static void BACK(int y,int x) {
    	if(flag)return;
    	if(x>=9) {
    		BACK(y+1,0);
    		return;
    	}
    	
    	if(y>=9) {
    		Print();
    		flag=true;
    		return;
    	}
    	
    	if(arr[y][x]>0)BACK(y,x+1);
    	else {
    		for(int next:set) {
    			if(visit[next])continue;
    			visit[next]=true;
    			for(int i=0;i<4;i++) {
    				int Y=y+diy[i];
    				int X=x+dix[i];
    				if(Y<0||Y>=9||X<0||X>=9)continue;
    				if(arr[Y][X]>0)continue;
    				int v1=next/10;
    				int v2=next%10;
    				if(check(y,x,v1)&&check(Y,X,v2)) {
    					arr[y][x]=v1;
    					arr[Y][X]=v2;
    					BACK(y,x+1);
    					if(flag)return;
    					arr[y][x]=0;
    					arr[Y][X]=0;
    				}
    				
    				if(check(y,x,v2)&&check(Y,X,v1)) {
    					arr[y][x]=v2;
    					arr[Y][X]=v1;
    					BACK(y,x+1);
    					if(flag)return;
    					arr[y][x]=0;
    					arr[Y][X]=0;
    				}
    				
    			}
    			visit[next]=false;;
    		}
    	}
    	
    	
    }
    public static void Print() {
    	
    	for(int i=0;i<9;i++) {
    		for(int k=0;k<9;k++) {
    			sb.append(arr[i][k]);
    		}sb.append("\n");
    	}
    	
    }
    public static boolean check(int y,int x,int v) {
    	
    	for(int i=0;i<9;i++) {
    		if(arr[y][i]==v)return false;
    		if(arr[i][x]==v)return false;
    	}
    	int Y=y/3*3;
    	int X=x/3*3;
    	for(int i=0;i<3;i++) {
    		for(int k=0;k<3;k++) {
    			if(arr[Y+i][X+k]==v)return false;
    		}
    	}
    	return true;
    }
 }