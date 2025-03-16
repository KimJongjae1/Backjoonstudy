
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<List<int[]>> road;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	   int TC=Integer.parseInt(br.readLine());
	   
	   Loop:for(int i=1;i<=TC;i++) {
		   StringTokenizer st =new StringTokenizer(br.readLine());

		   N=Integer.parseInt(st.nextToken());
		   int M=Integer.parseInt(st.nextToken());
		   int W=Integer.parseInt(st.nextToken());
		  road=new ArrayList<>();
		   for(int j=0;j<=N;j++) {
			   road.add(new ArrayList<>());
		   }
		
	       for(int j=0;j<M;j++) {
	    	   st =new StringTokenizer(br.readLine());
	    	   int start=Integer.parseInt(st.nextToken());
	    	   int end=Integer.parseInt(st.nextToken());
	    	   int cost=Integer.parseInt(st.nextToken());
	    	   road.get(start).add(new int[] {end,cost});
	    	   road.get(end).add(new int[] {start,cost});
	       }
	 
	       for(int j=0;j<W;j++) {
	    	   st =new StringTokenizer(br.readLine());
	    	   int start=Integer.parseInt(st.nextToken());
	    	   int end=Integer.parseInt(st.nextToken());
	    	   int cost=Integer.parseInt(st.nextToken());
	    	   road.get(start).add(new int[] {end,-cost});
	       }
	      
	       if(timewarp()) {
	    	   System.out.println("YES");
	       }else {
	    	   System.out.println("NO");
	       }
	       
	   } 
  }
   public static boolean timewarp() {
	  
	   int[] dist=new int[N+1];
	   boolean update=false;
	   for(int i=1;i<=N;i++) {
		update=false;
		   for(int j=1;j<=N;j++) {
			   
			   for(int[] a:road.get(j)) {
				   if(dist[a[0]]>dist[j]+a[1]) {
					   dist[a[0]]=dist[j]+a[1];
					   update=true;
				   }
			   }
			  
		   }
		   if(!update) break;
	   }
	   
	   return update;
	 
	
	   
   }
}