import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static List<Integer>[] list;
	static long ans;
	static int idx;
	static boolean[] visit;
	static int[] diy= {-1,0,1,0};
	static int[] dix= {0,-1,0,1};
	static StringBuilder sb;
	static BufferedReader br;
	static class node{
		int idx=0;
		node left,right;
		node parent;
		node(int idx){
			this.idx=idx;
		}
	}
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
     
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
        
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	N= Integer.parseInt(st.nextToken());
        	int[] first=new int[N+1];
  
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<N;i++) {
        		first[i]=Integer.parseInt(st.nextToken());
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	Map<Integer,Integer> middle=new HashMap<>();
        	int[] mid=new int[N+1];
        	for(int i=0;i<N;i++) {
        	 	mid[i]=Integer.parseInt(st.nextToken());
        	 	middle.put(mid[i], i);
        	}
        	
 
        	node[] tree=new node[N+1];
        	for(int i=1;i<=N;i++) {
        		tree[i]=new node(i);
        	}
        	tree[first[0]].parent=new node(0);
        	int idx=0;

        	while(idx<N-1) {
        	
        		int node=first[idx];//3
        		int MiddleIdx=middle.get(node);//4
        		int rightNodeCnt=findrightIdx(tree,mid,MiddleIdx);
        		
        		
        		if(MiddleIdx>0) {
        			int leftNode=first[idx+1];
        			int leftNodeMiddleIdx=middle.get(leftNode);
        			if(tree[leftNode].parent==null&&leftNodeMiddleIdx<MiddleIdx) {
        				tree[node].left=tree[leftNode];
        				//System.out.println(leftNode+" "+node+" "+N);
        				tree[leftNode].parent=tree[node];
        			}
        		}
        		
        		if(MiddleIdx<N-1) { 
        		
        			int rightNode=first[idx+1+rightNodeCnt];
        			//System.out.println(idx+1+rightNodeCnt+" "+idx+" "+rightNodeCnt);
        			if(tree[rightNode].parent==null) {
        				tree[node].right=tree[rightNode];
        				//System.out.println(rightNode+" "+node+" "+N+"right ");
        				tree[rightNode].parent=tree[node];
        			}
    			}
        		
        	
        		idx++;
        		
        	}
        	post(tree[first[0]]);
        	sb.append("\n");
        	
        	
        }
        System.out.println(sb);
        	
    }
    public static void post(node cur) {
    	if(cur==null) return;
    	
    	post(cur.left);
    	post(cur.right);
    	sb.append(cur.idx+" ");
    	
    }
    public static int findrightIdx(node[] tree,int[] mid,int cur) {
    	int cnt=0;
    	for(int i=0;i<cur;i++) {
    		if(tree[mid[i]].parent==null)cnt++;
    	}
    	return cnt;
    }
}