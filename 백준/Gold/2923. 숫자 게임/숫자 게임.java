import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int T;
   static int idx;
   static int max;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<Integer> list;
   static TreeSet<Integer> set;  
   static TreeMap<Integer,Integer> map;
   static int first;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	
	   StringTokenizer st=new StringTokenizer(br.readLine());
	   N=Integer.parseInt(st.nextToken());

	   int[] L=new int[101];
	   int[] R=new int[101];
	   
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	L[a]++;
        	R[b]++;
        	int l=1;
        	int r=100;
        	int NL=L[l];
        	int RL=R[r];
        	int max=0;
        	while(true) {
        		while(l<=100&&NL==0) {
        			l++;
        			if(l<=100)NL=L[l];
        		}
        		while(r>=1&&RL==0) {
        			r--;
        			if(r>=1)RL=R[r];
        		}
        		if(r<1||l>100)break;
        		max=Math.max(max, l+r);
        		if(NL>RL) {
        			NL-=RL;
        			RL=0;
        		}else  {
        			RL-=NL;
        			NL=0;
        		}
        	}
        	
        	sb.append(max+"\n");
        	
        }
        System.out.println(sb);
        
	   
    }
}