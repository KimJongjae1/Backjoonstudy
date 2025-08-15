import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;



public class Main { 
    static int N;
    static List<Integer>[] list;
    static int[] subtree;
    public static void main(String[] args) throws Exception {
    	StringBuilder sb=new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());

        list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++) {
        	 st=new StringTokenizer(br.readLine()) ;
        	 int a=Integer.parseInt(st.nextToken());
        	 int b=Integer.parseInt(st.nextToken());
        	 
        	 list[a].add(b);
        	 list[b].add(a);
        }
        subtree=new int[N+1];
        long ret=0;
        DFS(1,1);
        long temp=N;
        long n=temp*(temp-1)/2;
        for(int i=2;i<=N;i++) {
        	ret+=n-caculate((long)(N-subtree[i]));
        }
        System.out.println(ret);
    }
    public static long caculate(long n) {
    	return n*(n-1)/2;
    }
    
    public static int DFS(int cur,int par) {
    	subtree[cur]=1;
    
    	for(int next:list[cur]) {
    		if(next==par) continue;
    		subtree[cur]+=DFS(next,cur);
    	}
    	return subtree[cur];
    	
    }

    
  }
 