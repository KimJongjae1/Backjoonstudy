import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
   static int[] arr;
   static int[][] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,1,-1};
   static boolean[][][] visit;
   static List<Integer>[] list;
   static TreeSet<Integer> set;  
   static TreeMap<Long,Long> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     
	        
	     	StringTokenizer st=new StringTokenizer(br.readLine());

	     	N=Integer.parseInt(st.nextToken());
	     	M=Integer.parseInt(st.nextToken());
	     
	     	String W=br.readLine();
	     	String g=br.readLine();
	     	
	     	int[] ws=new int[26];
	     	int[] wS=new int[26];
	     	int[] gs=new int[26];
	     	int[] gS=new int[26];
	     	for(int i=0;i<N;i++) {
	     		char a=W.charAt(i);
	     		if(a<='Z') wS[a-'A']++;	
	     		else ws[a-'a']++;
	     		a=g.charAt(i);
	     		if(a<='Z') gS[a-'A']++;	
	     		else gs[a-'a']++;
	     		
	     	}
	     	check(ws,wS,gs,gS);
	     	idx=N;
	     	while(idx<M) {
	     		char a=g.charAt(idx-N);
	     		if(a<='Z') gS[a-'A']--;	
	     		else gs[a-'a']--;
	     		
	     		a=g.charAt(idx);
	     		if(a<='Z') gS[a-'A']++;	
	     		else gs[a-'a']++;
	     		check(ws,wS,gs,gS);
	     		idx++;
	     	}
	     	System.out.println(ans);
	     	
    }
    public static void check(int[] ws,int[] wS,int[] gs,int[] gS) {
    	for(int i=0;i<26;i++) {
    		if(ws[i]!=gs[i])return;
    		if(wS[i]!=gS[i])return;
    	}
    	ans++;
    }
   
}