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
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
    
      str=br.readLine();
           N=str.length();
        list=new ArrayList[str.length()];
        for(int i=0;i<str.length();i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<str.length()-1;i++){
            char a=str.charAt(i);
            for(int k=i+1;k<str.length();k++){
                if(a==str.charAt(k)){
                    if(pel(i,k))
                        list[i].add(k);
                }
            }
        }
        BFS();
    }
    public static boolean pel(int i,int k){
        int left=i+1;
        int right=k-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right))return false;
            left++;
            right--;
        }

        return true;
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