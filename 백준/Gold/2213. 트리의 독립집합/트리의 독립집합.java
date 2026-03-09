import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int[][] dp;
     static int[] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
         StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         dp=new int[N+1][2];
         arr=new int[N+1];
         list=new ArrayList[N+1];
         st=new StringTokenizer(br.readLine());
         for(int i=1;i<=N;i++){
             arr[i]=Integer.parseInt(st.nextToken());
             list[i]=new ArrayList<>();
             dp[i][0]=-1;
             dp[i][1]=-1;
         }
         for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
             int a=Integer.parseInt(st.nextToken());
             int b=Integer.parseInt(st.nextToken());

             list[a].add(b);
             list[b].add(a);
         }
         visit=new boolean[N+1];
           int n1=DP(1,0,1);
           int n2=DP(1,1,1);

            if(n1>=n2) {
            	sb.append(dp[1][0]+"\n");              
            	trace(1,0,1);
            }
            else  {
            	sb.append(dp[1][1]+"\n");
            	trace(1,1,1);
            }
            
            for(int i=1;i<=N;i++) {
            	if(visit[i]) {
            		sb.append(i+" ");
            	}
            }
         System.out.println(sb);
     }
    
     public static int DP(int cur,int status,int before){
        
         if(dp[cur][status]!=-1)
             return dp[cur][status];
        
         dp[cur][status]=0;
         
         if(status==1)
        	 dp[cur][status]=arr[cur];
        
            for(int next:list[cur]){
                if(next==before)continue;
                
                if(status==0){ 
                    int n1=DP(next,0,cur);
                    int n2=DP(next,1,cur);
                    if(n1>=n2) dp[cur][status]+=n1;
                    else {
                    	dp[cur][status]+=n2;                     
                    }
                }
                else {
                    dp[cur][status]+=DP(next,0,cur);
                }
            }

         return dp[cur][status];
     }
     public static void trace(int cur,int status,int parent) {
    	 
    	 if(status ==1) {
    		 visit[cur]=true;
    		 for(int next:list[cur]) {
    			 if(next==parent)continue;
    			 trace(next,0,cur);
    		 }
    		 
    	 }else {
    		 for(int next:list[cur]) {
    			 if(next==parent)continue;
    			 
    			 if(dp[next][1]>dp[next][0])trace(next,1,cur);
    			 else{
    				 trace(next,0,cur);
    			 }
    		 } 
    	 }
    	 
     }
   
    
 }