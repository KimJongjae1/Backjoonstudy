import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static List<Integer>[] list;
	static int ans;
	static int idx;
	static boolean[][] visit;
	static int[] diy= {-1,1,0,0};
	static int[] dix= {0,0,-1,1};
	static StringBuilder sb;
	static BufferedReader br;
	static boolean flag;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
     
        while(true) {
        	   StringTokenizer st = new StringTokenizer(br.readLine());
        	N= Integer.parseInt(st.nextToken());
        	if(N==0)break;
        	int[] cost=new int[N+1];
        	arr=new int[N+1];
        	Arrays.fill(arr, -1);
        	flag=false;
        	list=new ArrayList[N+1];
        	for(int i=1;i<=N;i++) {
        		list[i]=new ArrayList<>();
        		 st = new StringTokenizer(br.readLine());
        		 char order=st.nextToken().charAt(0);
        		 int c=Integer.parseInt(st.nextToken());
        		 
        		 if(order=='L')  cost[i]=c;
        		 else cost[i]=-c;
        		 
        		 while(true) {
        			 int n=Integer.parseInt(st.nextToken());
        			 if(n==0)break;
        			 list[i].add(n);
        			 
        		 }
        	}
        	if(cost[1]>=0)	DFS(1,cost,cost[1]);
        	
        	if(flag)System.out.println("Yes");
        	else System.out.println("No");
        	
        	
        	
        }
    }
    public static void DFS(int cur,int[] cost,int sum) {
    	if(flag) return;
    	if(cur==N) {
    		flag=true;
    	}else {
    		for(int next:list[cur]) {
    			int NewSum=sum;
    	
    			if(cost[next]>0) {
    				if(cost[next]>NewSum)NewSum=cost[next];
    			}else {
    				if(cost[next]+NewSum<0)continue;
    				else NewSum+=cost[next];
    			}
    		
    			if(arr[next]>=NewSum)continue;
    			
    			arr[next]=NewSum;
    			DFS(next,cost,NewSum);
    			if(flag)return;
    		}
    	}
    	
    }
}