import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static  StringBuilder sb;
   static int[] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<int[]> list;
   static Set<int[]> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        
        
       int[] down=new int[H+1];
       int[] up=new int[H+1];
       for(int i=0;i<N;i++) {
    	   int n=Integer.parseInt(br.readLine());
    	   if(i%2==0) {
    		  down[n]++;
    	   }else {
    		   up[n]++;
    	   }
       }
       
       for(int i=H-1;i>0;i--) {
    	   down[i]+=down[i+1];
    	   up[i]+=up[i+1];
       }
       
       
       int Max=Integer.MAX_VALUE;
       int cnt=0;
       for(int i=1;i<=H;i++) {
    	   if(Max>down[i]+up[H-i+1]) {
    		   Max=down[i]+up[H-i+1];
    		   cnt=1;
    	   }else if(Max==down[i]+up[H-i+1]) {
    		   cnt++;
    	   }
       }
        System.out.println(Max+" "+cnt);
    }
}