import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main {
    static int N;
    static int M;
    static int K;
    static int[][][] dp;
     static int[] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
     static int[] diy= {-1,1,0,0};
     static int[] dix= {0,0,-1,1};
     static boolean flag;
     static int[] indegree;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();
  
	       StringTokenizer st=new StringTokenizer(br.readLine());
	       N=Integer.parseInt(st.nextToken());
	       M=Integer.parseInt(st.nextToken());
	       K=Integer.parseInt(st.nextToken());
	       indegree=new int[N+1];
	       arr=new int[N+1];
	       list=new ArrayList[N+1];
	       for(int i=1;i<=N;i++)
	    	   list[i]=new ArrayList<>();
	       
	       for(int i=0;i<M;i++) {
	    	   st=new StringTokenizer(br.readLine());
	    	   int a=Integer.parseInt(st.nextToken());
	    	   int b=Integer.parseInt(st.nextToken());
	    	   
	    	   indegree[b]++;
	    	   list[a].add(b);
	       }
	       
	       for(int i=0;i<K;i++) {
	    	   st=new StringTokenizer(br.readLine());
	    	   int order=Integer.parseInt(st.nextToken());
	    	   int a=Integer.parseInt(st.nextToken());
	    	   
	    	   if(order==1) {
	    		   if(!construct(a)) {
	    			   System.out.println("Lier!");
	    			   return;
	    		   }
	    	   }else {
	    		   if(!destroy(a)) {
	    			   System.out.println("Lier!");
	    			   return;
	    		   }
	    	   }
	       }
	       System.out.println("King-God-Emperor");
	       
    }
    
    public static boolean construct(int a) {
    	 	
    	if(indegree[a]>0)return false;
    	else {
    		arr[a]++;
    		if(arr[a]>1)return true;
    		for(int b:list[a]) {
    			indegree[b]--;
    		}
    		return true;
    	}
    }
    
    public static boolean destroy(int a) {
    	if(arr[a]==0)return false;
    	arr[a]--;
    	if(arr[a]>0)return true;
    	
    	for(int b:list[a]) {
    		indegree[b]++;
    	}
    	return true;
    }
 }