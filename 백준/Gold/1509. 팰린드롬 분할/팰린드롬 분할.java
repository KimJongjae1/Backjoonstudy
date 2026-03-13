import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static char[][] arr;
   static int[][][] dp;
   static int ans;
   static int[] diy= {1,-1,0,0};
   static int[] dix= {0,0,1,-1};
   static boolean[] check;
    static String str;
    static List<Integer>[] list;
    static boolean[][] dp1;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
    
      str=br.readLine();
           N=str.length();
        list=new ArrayList[str.length()];
        for(int i=0;i<str.length();i++){
            list[i]=new ArrayList<>();
        }
        dp1=new boolean[N][N];
        for(int len=1;len<=str.length();len++){
            for(int i=0;i+len-1<str.length();i++){
                if(len==1){
                    dp1[i][i]=true;
                      list[i].add(i);
                }
                else if(len==2){
                    if(str.charAt(i)==str.charAt(i+1)){
                        dp1[i][i+1]=true;
                        list[i].add(i+1);
                    }
                }
                else{
                    if(str.charAt(i)==str.charAt(i+len-1)&&dp1[i+1][i+len-2]){
                        dp1[i][i+len-1]=true;
                        list[i].add(i+len-1);
                    }
                    
                    
                }
            }
        }
        BFS();
    }
 

    public static void BFS(){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{0,0});
        int[] dp=new int[N];
        Arrays.fill(dp,1000000);
        dp[0]=0;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            if(cur[0]==N){
                System.out.println(cur[1]);
                break;
            }

            for(int next:list[cur[0]]){
                if(dp[next]<=cur[1]+1)continue;
                dp[next]=cur[1]+1;
                qu.offer(new int[]{next+1,dp[next]});
            }
            qu.offer(new int[]{cur[0]+1,cur[1]+1});
        }
    }
}