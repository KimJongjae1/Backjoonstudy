import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
    static int C;
	static int[] arr;
    static int[] dp;
    static List<int[]>[] list;
    static int ans;
    static StringBuilder sb;
     public static void main (String[] args) throws IOException {
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           int T=Integer.parseInt(br.readLine());
          sb=new StringBuilder();
         for(int t=0;t<T;t++){
              StringTokenizer st=new StringTokenizer(br.readLine());
           
    		  N=Integer.parseInt(st.nextToken());
    	      M=Integer.parseInt(st.nextToken());
              C=Integer.parseInt(st.nextToken());
             list=new ArrayList[N+1];
            dp=new int[N+1];
             for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
         
              for(int i=0;i<M;i++){
                  st=new StringTokenizer(br.readLine());
                  int NotInfect=Integer.parseInt(st.nextToken());
                  int infect=Integer.parseInt(st.nextToken());
                  int time=Integer.parseInt(st.nextToken());

                  list[infect].add(new int[]{NotInfect,time});
                  
              }
             Arrays.fill(dp,Integer.MAX_VALUE);
             dp[C]=0;
             BFS(); 
             
         }
         System.out.println(sb);
    }
    public static void BFS(){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{C,0});
         ans=0;
        int cnt=0;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            if(cur[1]>dp[cur[0]])continue;

            for(int[] next:list[cur[0]]){
                if(next[1]+cur[1]>=dp[next[0]])continue;
                dp[next[0]]=next[1]+cur[1];
                
                qu.offer(new int[]{next[0],dp[next[0]]});
            }
            
        }
        for(int i=1;i<=N;i++){
            if(dp[i]==Integer.MAX_VALUE)continue;
            ans=Math.max(dp[i],ans);
            cnt++;
        }
        sb.append(cnt+" "+ans).append("\n");
    }
}