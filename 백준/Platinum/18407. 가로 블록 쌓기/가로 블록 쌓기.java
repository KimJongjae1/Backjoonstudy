import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;



public class Main {

    static int N;

    static int[] tree;

    static int[] lazy;

    static Map<Integer,Integer> map;

    static int idx=0;

    static int ans=0;
    static List<Integer> list;
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine()) ;



        N=Integer.parseInt(st.nextToken());
  
        map=new TreeMap<>();
        Queue<int[]> qu=new LinkedList<>();
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<N;i++) {
        	 st=new StringTokenizer(br.readLine()) ;
        	int w=Integer.parseInt(st.nextToken());
        	int s=Integer.parseInt(st.nextToken());
        	qu.offer(new int[] {s,s+w-1});
        	set.add(s);
        	set.add(s+w-1);
        }
       
       
       list=new ArrayList<>(set);
       int size=list.size();
       tree=new int[4*size+1];
       lazy=new int[4*size+1];
        while(!qu.isEmpty()) {
        	int[] now=qu.poll();
        	
        	int sidx=binary(now[0]);
        	int bidx=binary(now[1]);
        	if(sidx>bidx) {
        		int temp=sidx;
        		sidx=bidx;
        		bidx=temp;
        	}
      
        	int n=checkheight(0,size-1,1,sidx,bidx);
        	insert(0,size-1,1,sidx,bidx,n+1);
        
        }
        System.out.println(tree[1]);
    }
    
    public static int binary(int target) {
    	int max=list.size()-1;
    	int min=0;
    	while(min<max) {
    		int mid=(max+min)/2;
    		
    		if(target>list.get(mid)) {
    			min=mid+1;
    		}else {
    			max=mid;
    		}
    				
    	}
    	
    	return min;
    }
    
    
    public static void insert(int start,int end,int idx,int ts,int te,int num) {
      	lazyinsert(start,end,idx);
    	if(te<start||end<ts) return;
    	
    	if(ts<=start&&end<=te) {
    		tree[idx]=num;
    		if(start==end) return;
    		lazy[idx*2]=num;
    		lazy[idx*2+1]=num;
    		return;
    	}
    	

    	int mid=(start+end)/2;
    	insert(start,mid,idx*2,ts,te,num);
    	insert(mid+1,end,idx*2+1,ts,te,num);

    	tree[idx]=Math.max(tree[idx*2], tree[idx*2+1]);
    	
    }
   

    public static void lazyinsert(int start,int end,int idx) {
    	if(lazy[idx]!=0) {
    		tree[idx]= Math.max(tree[idx],lazy[idx]);
    		
    	    if (start != end) {
    		lazy[2*idx] = Math.max(lazy[2*idx], lazy[idx]);
    		lazy[2*idx+1] = Math.max(lazy[2*idx+1], lazy[idx]);
    	    }
    		lazy[idx]=0;
    	}	
    }

    

    public static int checkheight(int start,int end,int idx,int ts,int te) {
    	lazyinsert(start,end,idx);

    	if(te<start||end<ts) return 0;

    	if(ts<=start&&end<=te) {
    		return tree[idx];
    	}
   
    	int mid=(start+end)/2;
    	return Math.max(
    			checkheight(start,mid,idx*2,ts,te),
    			checkheight(mid+1,end,idx*2+1,ts,te)
    	);
    }

}