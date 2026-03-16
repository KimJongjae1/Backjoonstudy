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
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
        // StringTokenizer st=new StringTokenizer(br.readLine());
        // N=Integer.parseInt(st.nextToken());
         arr=new int[9][9];
         for(int i=0;i<9;i++) {
        	 String str=br.readLine();
        	 
        	 for(int k=0;k<9;k++) {
        		 arr[i][k]=str.charAt(k)-'0';
        	 }
         }
         BACK(0,0);
         
         
         
     }
    public static void BACK(int y,int x) {
    	if(x>=9) {
    		BACK(y+1,0);
    		return;
    	}

    	if(y>=9) {
    		Print();
    		System.exit(0);
    	}
    	
    	if(arr[y][x]>0) {
    		BACK(y,x+1);
    		return;
    	}
    	
    	for(int i=1;i<=9;i++) {
    		if(check(i,y,x)) {
    			arr[y][x]=i;
    			BACK(y,x+1);
    			arr[y][x]=0;
    		}
    	}
    	
    }
    public static void Print() {
    	
    	for(int i=0;i<9;i++) {
    		for(int k=0;k<9;k++) {
    			sb.append(arr[i][k]);
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
    public static boolean check(int n,int y,int x) {
    	int Y=y/3*3;
    	int X=x/3*3;
    	//System.out.println(Y+" "+X+" "+y+" "+x);
 
    	for(int i=0;i<3;i++) {
    		for(int k=0;k<3;k++) {
    			if(arr[Y+i][X+k]==n) {
    				return false;
    			}
    		}
    	}
    	for(int i=0;i<9;i++) {
    		if(arr[y][i]==n)return false;
    		if(arr[i][x]==n)return false;
    	}
    	
    	return true;
    	
    }
 }