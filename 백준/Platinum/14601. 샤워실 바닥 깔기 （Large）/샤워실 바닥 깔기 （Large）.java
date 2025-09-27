import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

   static int N;
   static int M;
   static  StringBuilder sb;
   static int[][] arr;
   static int len;
   static int num;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


	        sb=new StringBuilder();
	     	N=Integer.parseInt(st.nextToken());
	     	len=(int)Math.pow(2, N);
	     	arr=new int[len+1][len+1];
	
	     	st=new StringTokenizer(br.readLine());
	     	int y=Integer.parseInt(st.nextToken());
	     	int x=Integer.parseInt(st.nextToken());
	     	arr[x][y]=-1;
	     	
	     	divide(1,1,len);
	     	
	     	for(int i=len;i>=1;i--) {
	     		for(int k=1;k<=len;k++) {
	     			System.out.print(arr[i][k]+" ");
	     		}System.out.println();
	     	}
	     	
	     	
    }
    public static void divide(int x,int y,int n) {
    	
    	num++;
    	
    	int ns=n/2;
    	if(check(x+ns,y,ns)) arr[x+ns][y+ns-1]=num;
    	if(check(x,y+ns,ns)) arr[x+ns-1][y+ns]=num;
    	 if(check(x+ns,y+ns,ns)) arr[x+ns][y+ns]=num;
    	 if(check(x,y,ns)) arr[x+ns-1][y+ns-1]=num;
    	
    	if(ns==1) return;
    	divide(x+ns,y,ns);
    	divide(x+ns,y+ns,ns);
    	divide(x,y+ns,ns);
    	divide(x,y,ns);
    	
    }
    public static boolean check(int x,int y,int ns) {
    	
    	for(int i=x;i<x+ns;i++) {
    		for(int k=y;k<y+ns;k++) {
    			if(arr[i][k]!=0) return false;
    		}
    	}
    	return true;
    }
}