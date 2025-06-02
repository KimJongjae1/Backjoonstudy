import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int N;
	static int[] sumAB;
	static int[] sumCD;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());  
			StringBuilder sb=new StringBuilder();
		 

			  N=Integer.parseInt(st.nextToken());
			  int[] A=new int[N];
			  int[] B=new int[N];
			  int[] C=new int[N];
			  int[] D=new int[N];
			  
			  for(int i=0;i<N;i++) {
				  st=new StringTokenizer(br.readLine());  
				  A[i]=Integer.parseInt(st.nextToken());
				  B[i]=Integer.parseInt(st.nextToken());
				  C[i]=Integer.parseInt(st.nextToken());
				  D[i]=Integer.parseInt(st.nextToken());
			  }
			  sumAB=new int[N*N];
			  sumCD=new int[N*N];
			  int idx=0;
			  for(int i=0;i<N;i++) {
				  for(int k=0;k<N;k++) {
					  sumAB[idx]=A[i]+B[k];  
					  sumCD[idx++]=C[i]+D[k];  
				  }
				  
			  }
			  
			 Arrays.sort(sumCD);
			 long result=0;
			 for(int i=0;i<N*N;i++) {
			
				 int low=lowerbound(-sumAB[i]);	
				 
				 if(sumCD[low]+sumAB[i]!=0) continue;
				 
				int high=upperbound(-sumAB[i]);
				result+=high-low;
			
				 
			 }
			 System.out.println(result);
		   }
		 public static int upperbound(int target) {
			 int max=sumCD.length;
			 int min=0;
			 while(min<max) {
				 int mid=(max+min)/2;
				 
				 if(target>=sumCD[mid]) {
					 min=mid+1;
				 }else {
					 max=mid;
				 }
				 
			 }
			 return min;
			 
		 }
		 public static int lowerbound(int target) {
			 int max=sumCD.length-1;
			 int min=0;
			 while(min<max) {
				 int mid=(max+min)/2;
				 
				 if(target>sumCD[mid]) {
					 min=mid+1;
				 }else {
					 max=mid;
				 }
				 
			 }
			 return min;	 
		 }
	 }
