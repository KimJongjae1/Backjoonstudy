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
	     	

	     	st=new StringTokenizer(br.readLine());
	     	list=new ArrayList[N];
	     	for(int i=0;i<N;i++) 
	     		list[i]=new ArrayList<>();
	     	
	     	int root=0;
	     	for(int i=0;i<N;i++) {
	     		int parent=Integer.parseInt(st.nextToken());
	     		if(parent==-1) {
	     			root=i;
	     			continue;
	     		}
	     		list[parent].add(i);
	     	}
	      
	     	int remove=Integer.parseInt(br.readLine());	
	     	DFS(root,remove);
	     	System.out.println(ans);

    }
    public static void DFS(int cur,int remove) {
    	if(cur==remove)return;
    	
    
    	int cnt=0;
    	for(int next:list[cur]) {
    		if(next!=remove) {
    			DFS(next,remove);
    			cnt++;
    		}
    	}
    	if(cnt==0)ans++;
    }
    
   
}