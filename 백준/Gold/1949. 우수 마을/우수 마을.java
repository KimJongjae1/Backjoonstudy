import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Integer N;
    public static List<List<Integer>> tree;
    public static int[] arr;
    public static int[][] dp;
    public static  StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
       
       arr=new int[N+1]; 
       tree=new ArrayList<>();
       tree.add(new ArrayList<>());
       st=new StringTokenizer(br.readLine());
       for(int i=1;i<=N;i++) {
    	   arr[i]=Integer.parseInt(st.nextToken());
    	   tree.add(new ArrayList<>());
       }
    	
       
       for(int i=1;i<N;i++) {
    	   st=new StringTokenizer(br.readLine());
    	   int a=Integer.parseInt(st.nextToken());
    	   int b=Integer.parseInt(st.nextToken());
    	   tree.get(a).add(b);
    	   tree.get(b).add(a);
       }
       
       dp=new int[N+1][2];
       System.out.println(Math.max(dfs(1,1,1), dfs(1,0,1)));
       
    }
   public static int dfs(int start,int usu,int before) {
	   if(dp[start][usu]!=0) return dp[start][usu];
	   
	   if(usu==1) {
		   dp[start][1]+=arr[start];
		   for(int next:tree.get(start)) {
			   if(next!=before)
			   dp[start][1]+=dfs(next,0,start);
		   }
	   }else {
		   for(int next:tree.get(start)) {
			   if(next!=before)
			   dp[start][0]+=Math.max(dfs(next,1,start),dfs(next,0,start));
		   }
	   }
	   return dp[start][usu];
   }
    
}

