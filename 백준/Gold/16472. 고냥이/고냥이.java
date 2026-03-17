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

        String str=br.readLine();
            
         arr=new int[26]; 
         int type=0;
         int cnt=0;
         ans=0;
         int right=0;
         int left=0;
         while(right<str.length()){
             char a=str.charAt(right++);
             
             if(arr[a-'a']==0){ 
                type++;
                while(type>N){
                    char b=str.charAt(left++);
                    arr[b-'a']--;
                    cnt--;
                    if(arr[b-'a']==0)type--;
                } 
             }

             arr[a-'a']++;
             cnt++;
             ans=Math.max(cnt,ans);

             
         }

        
        System.out.println(ans);
    }
}