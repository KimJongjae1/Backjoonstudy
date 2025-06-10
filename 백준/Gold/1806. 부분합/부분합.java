import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] tree;
	public static StringBuilder sb;
	public static int N;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
			StringTokenizer st=new StringTokenizer(br.readLine());  		 
			 sb=new StringBuilder();
			 N=Integer.parseInt(st.nextToken());
			 int L=Integer.parseInt(st.nextToken());
			 
			 st=new StringTokenizer(br.readLine());
			 tree=new int[N+1];
			 for(int i=0;i<N;i++) {
				 tree[i]=Integer.parseInt(st.nextToken());
			 }
			 
			 int start=0;
			 int end=0;
			 int len=N+1000;
			 int sum=0;
			 while(start<=end&&end<=N) {
				 if(sum<L) {
					 sum+=tree[end++];
				 }else {
					 len=Math.min(len, end-start);
					 sum-=tree[start++];
				 }
				 
				
			 }
					 
					 
			 if(len==N+1000) System.out.println(0);
			 else System.out.println(len); 
					 
					 
			 
			 
	 }
	 
 }