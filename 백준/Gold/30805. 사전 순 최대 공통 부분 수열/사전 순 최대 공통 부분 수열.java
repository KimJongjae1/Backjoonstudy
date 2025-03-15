import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visit;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	   
	   int N=Integer.parseInt(br.readLine());
	   int[] arr1=new int[N];
	   PriorityQueue<int[]> qu =new PriorityQueue<>(new Comparator<int[]>() {
		   @Override
		   public int compare(int[] a ,int[] b) {
			   if(a[0]!=b[0]) {
				   return Integer.compare(b[0], a[0]);
			   }else {return Integer.compare(a[1], b[1]);}
		   }
	   });
	   StringTokenizer st =new StringTokenizer(br.readLine());
	   for(int i=0;i<N;i++) {
		   arr1[i]=Integer.parseInt(st.nextToken());
		   qu.offer(new int[] {arr1[i],i});
	   }
	   
	   int M=Integer.parseInt(br.readLine());
	   int[] arr2 = new int[M];
	    
	   st =new StringTokenizer(br.readLine());
	   for(int i=0;i<M;i++) {
		   arr2[i]=Integer.parseInt(st.nextToken());
	   }
		StringBuilder sb =new StringBuilder();
		int cnt=0;
    visit=new boolean[M];
    int maxidx=-1;
	  Loop: for(int i=0;i<N;i++) {
		   int[] temp=qu.poll();
		   if(maxidx>temp[1]) continue;
		   for(int k=0;k<M;k++) {
			   if(arr2[k]==temp[0]&&!visit[k]) {
				   for(int q=0;q<=k;q++) {
					   visit[q]=true;
				   }
				   sb.append(temp[0]).append(" ");
				   cnt++;
				   maxidx=temp[1];
				   continue Loop;
			   }
		   }  
	   }
	   
	   

	System.out.println(cnt);
	System.out.println(sb);
   }

}