import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
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
   static List<Integer> list;
   static int diff=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        
        
        arr=new int[11];
        if(M>0)
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
        	int n=Integer.parseInt(st.nextToken());
        	arr[n]=1;
        }
        ans=Math.abs(100-N);
        DFS(0,0);
       
        System.out.println(ans);
    }
    public static void DFS(int sum,int level) {
    	if(level==7) return;
    	
    	if(level>0) {
    		ans=Math.min(ans, level+Math.abs(N-sum));
    	}
    	
    	for(int i=0;i<10;i++) {
    		if(arr[i]==1)continue;
    		DFS(sum*10+i,level+1);
    	}
    	
    	
    }
    
}