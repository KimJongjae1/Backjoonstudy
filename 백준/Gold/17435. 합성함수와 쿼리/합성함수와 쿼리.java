import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static final int log=(int)(Math.log(500000)/Math.log(2));
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
	
			StringTokenizer st=new StringTokenizer(br.readLine());  		 
			 
			 N=Integer.parseInt(st.nextToken());
			 
			 int[][] parent=new int[log+1][N+1];
			 
			 st=new StringTokenizer(br.readLine());  	
			 for(int i=1;i<=N;i++) {
				 parent[0][i]=Integer.parseInt(st.nextToken());
			 }
			
			 for(int i=1;i<=log;i++) {
				 for(int k=1;k<=N;k++) {
					 parent[i][k]=parent[i-1][parent[i-1][k]];
				 }
			 }
			 
			
			 	StringBuilder sb=new StringBuilder();
			   int T=Integer.parseInt(br.readLine());
			   for(int t=0;t<T;t++) {
				   st=new StringTokenizer(br.readLine());  
				   int a=Integer.parseInt(st.nextToken());
				   int b=Integer.parseInt(st.nextToken());
				   while(a!=0) {
					   
					   int loga=(int)(Math.log(a)/Math.log(2));
					   a-=(int)Math.pow(2, loga);
					   b=parent[loga][b];
			
				   }
		
				   sb.append(b).append("\n");
			   }
			 
		   System.out.println(sb);
	 }
	 
 }