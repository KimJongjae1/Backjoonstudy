import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<int[]> list;
   static Set<int[]> set;  
   static int[] parent;
   public static int find(int x) {
	   if(parent[x]==x)return x;
	   return parent[x]=find(parent[x]);
   }
   public static boolean union(int a,int b){
	   
	   int A=find(a);
	   int B=find(b);
	   
	   if(A==B)return false;
	   else {
		   parent[B]=A;
		   return true;
	   }
   }
   
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parent=new int[N];
        for(int i=0;i<N;i++) {
        	parent[i]=i;
        }
        
        for(int i=0;i<M;i++) {
        	 st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	
        	if(!union(a,b)) {
        		System.out.println(i+1);
        		return;
        	}
        }
        
        System.out.println(0);
    }
}