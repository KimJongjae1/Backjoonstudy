import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] ans;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
       
        st=new StringTokenizer(br.readLine());
        arr=new int[N];
   
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        ans=new int[M];
        visit=new boolean[N];
        sb=new StringBuilder();
        back(0);
        System.out.println(sb);
   }
   public static void back(int depth) {
	   if(depth==M) {
		   for(int a:ans) {
			   sb.append(a).append(" ");
		   }
		   sb.append("\n");
	   }else {
		   int before=0;
		   for(int i=0;i<N;i++) {

			   if(!visit[i]) { 
				   if(before!=arr[i]) {
				   visit[i]=true;
				   before=arr[i];
				   ans[depth]=arr[i];
				   back(depth+1);
				   visit[i]=false;
				   }
			   }  
		   }
	   }
	   
	   
   }
}