import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static char[][] arr;
   static int[][] ans;
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	N=Integer.parseInt(st.nextToken());
     	M=Integer.parseInt(st.nextToken());
     	
     	arr=new char[N][M];
     
     	for(int i=0;i<N;i++) {
     		String str=br.readLine();
     		for(int k=0;k<M;k++)
     		arr[i][k]=str.charAt(k);
     	}
     	
     	ans=new int[N][M];
     	
     	for(int i=0;i<N;i++) {
     		for(int k=0;k<M;k++) {
     			changeTwo(i,k);
     		}
     	}
   
     	for(int i=0;i<N;i++) {
     		for(int k=0;k<M;k++) {
     			if(arr[i][k]=='B') {
     				sb.append(3);
     			}else sb.append(2);
     		}
     		sb.append("\n");
     	}

     	System.out.println(1);
     	System.out.println(sb);
     	
     	
    }
    public static void changeTwo(int y,int x) {
    	
    	for(int i=0;i<4;i++) {
    		int Y=y+diy[i];
    		int X=x+dix[i];
    		if(Y<0||Y>=N||X<0||X>=M) continue;
    		if(arr[Y][X]=='B')arr[Y][X]='W';
    		else arr[Y][X]='B';
    	}
    	
    }
}