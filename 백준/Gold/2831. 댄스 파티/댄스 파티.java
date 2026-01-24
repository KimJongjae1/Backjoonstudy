import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static long max;
   static  StringBuilder sb;
   static int[][] arr;
   static String[] dp;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[][][] visit;
   static List<int[]> list;
   static TreeSet<Integer> set;  
   static Map<Integer,Integer>[] map;
   static List<Integer> manLower;
   static List<Integer> manHigher;
   static List<Integer> womanLower;
   static List<Integer> womanHigher;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer .parseInt(st.nextToken());
		
		manLower=new ArrayList<>();
		manHigher=new ArrayList<>();
		womanLower=new ArrayList<>();
		womanHigher=new ArrayList<>();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int h=Integer.parseInt(st.nextToken());
			if(h>0)manHigher.add(h);
			else manLower.add(-h);
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int h=Integer.parseInt(st.nextToken());
			if(h>0)womanHigher.add(h);
			else womanLower.add(-h);
		}
    	Collections.sort(manHigher);
    	Collections.sort(manLower);
    	Collections.sort(womanHigher);
    	Collections.sort(womanLower);
    	int Widx=0;
    	for(int i=0;i<manHigher.size();i++) {
    		int h=manHigher.get(i);
    		while(Widx<womanLower.size()) {
    			if(h<womanLower.get(Widx++)) {
    				ans++;
    				break;
    			}
    		}
    	}
    	Widx=0;
    	for(int i=0;i<womanHigher.size();i++) {
    		int h=womanHigher.get(i);
    		while(Widx<manLower.size()) {
    			if(h<manLower.get(Widx++)) {
    				ans++;
    				break;
    			}
    		}
    	}
    	System.out.println(ans);
    	
    }
    
}