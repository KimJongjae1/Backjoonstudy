import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


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
   static int[] arr;
   static int[] dp;
   static long[]sum;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[][][] visit;
   static List<Integer> list;
   static Set<Integer> set;  
   static Map<Integer,Integer>[] map;
   static int[] L;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer .parseInt(st.nextToken());
		 M=Integer .parseInt(st.nextToken());
		 K=Integer .parseInt(st.nextToken());
		 arr=new int[3];
		 arr[0]=N;
		 arr[1]=M;
		 arr[2]=K;
		 int max=Math.max(N, Math.max(M, K));
		 visit=new boolean[max+1][max+1][max+1];
		 L=new int[3];
		 L[2]=K;
		 set=new HashSet<>();
		 DFS();
		 list=new ArrayList<>();
		 for(int a:set) {
			 list.add(a);
		 }
		 Collections.sort(list);
		 for(int a:list) {
			 sb.append(a+" ");
		 }
		 System.out.println(sb);
    }
    public static void DFS() {
    	if(visit[L[0]][L[1]][L[2]])return;
    	visit[L[0]][L[1]][L[2]]=true;
    	if(L[0]==0)set.add(L[2]);
    	
    	for(int i=0;i<3;i++) {
    		if(L[i]==0)continue;
    		for(int k=0;k<3;k++) {
    			if(i==k)continue;
    			if(arr[k]-L[k]==0)continue;
    			int next=give(L[i],arr[k]-L[k]);
    			L[k]+=next;
    			L[i]-=next;
    			DFS();
    			L[k]-=next;
    			L[i]+=next;
    		}
    	}
    	
    }
    public static int give(int g,int dleft) {
    	if(g<=dleft) {
    		return g;
    	}else {
    		return dleft;
    	}
    	
    }
}