import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int N;
	static int[] ans=new int[3];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        sb=new StringBuilder();
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        for(int i=0;i<N;i++) {
        	//StringTokenizer st =new StringTokenizer(br.readLine());
        	String str=br.readLine();
        	for(int k=0;k<N;k++) {
        		arr[i][k]=str.charAt(k)-'0';
        	}
        }
       
	    divide(0,0,N);
        System.out.println(sb);
    }
    public static void divide(int y,int x, int size) {
    	
    	 if(!check(y,x,size)) {
    		 divide(y,x,size/2);
    		 divide(y,x+size/2,size/2);
    		 divide(y+size/2,x,size/2);
    		 divide(y+size/2,x+size/2,size/2);
    		 sb.append(")");
    	 }
    	
    	
    	
    	
    }
    public static boolean check(int y,int x, int size) {
    	int standard=arr[y][x]; 
    	 for(int i=y;i<y+size;i++) {
    		 for(int k=x;k<x+size;k++) {
    			 if(arr[i][k]!=standard) {
    				 sb.append("(");
    				 return false;
    			 }
    		 }
    	 }
    	sb.append(standard);
    	return true;
    }
}