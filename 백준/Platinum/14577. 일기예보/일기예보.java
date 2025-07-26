import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;



public class Main {
    static int N;
    static long[] arr;
    static long[] copy;
    static int[] tree;
    static int[] lazy;
    static  List<Long> list;
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        arr=new long[N+1];
        copy=new long[N+1];
        TreeSet<Long> set=new TreeSet<>();
        st=new StringTokenizer(br.readLine()) ;
        for(int i=1;i<=N;i++) {
        	copy[i]=arr[i]=Long.parseLong(st.nextToken());
        	set.add(arr[i]);
        }
        
        Queue<long[]> qu=new LinkedList<>();
     
         long a;long b;
        for(int i=0;i<M;i++) {
        	 st=new StringTokenizer(br.readLine()) ;
        	long order=Integer.parseInt(st.nextToken());
        	if(order==1) {
        		a=Long.parseLong(st.nextToken());
        		b=Long.parseLong(st.nextToken());
        		qu.offer(new long[] {order,a,b});
        		set.add(copy[(int)a]+b);
        		copy[(int)a]+=b;
        	}else if(order==2) {
        		 a=Long.parseLong(st.nextToken());
        		 b=Long.parseLong(st.nextToken());
        		 qu.offer(new long[] {order,a,b});
        		 set.add(copy[(int)a]-b);
        		 copy[(int)a]-=b;
        	}else if(order==3) {
        		long L=Long.parseLong(st.nextToken());
        		long R=Long.parseLong(st.nextToken());
        		qu.offer(new long[] {order,L,R});
        		set.add(L);
        		set.add(R);
        	}else {
        	   a=Long.parseLong(st.nextToken());
        	   qu.offer(new long[] {order,a});
        
        	}
        	
        }
        list=new ArrayList<>(set);
        int size=list.size();
        tree=new int[size*4+1];
        lazy=new int[size*4+1];
        for(int i=1;i<=N;i++) {
        	int n=find(arr[i]);
        	insert(0,size-1,1,n);
        }
        StringBuilder sb=new StringBuilder();
        while(!qu.isEmpty()) {
        	long[] q=qu.poll();
        	long order=q[0];
        
        	if(order==1) {
        		int idx=(int)q[1];//2
        		long diff=q[2];//2
        		int deleten=find(arr[idx]);
        		int n=find(arr[idx]+diff);
        		arr[idx]+=diff;
        		delete(0,size-1,1,deleten);
        		insert(0,size-1,1,n);
        		
        	}else if(order==2) {
        		int idx=(int)q[1];
        		long diff=q[2];
        		int deleten=find(arr[idx]);
        		int n=find(arr[idx]-diff);
        		arr[idx]-=diff;
        		delete(0,size-1,1,deleten);
        		insert(0,size-1,1,n);      		
        		
        	}else if(order==3) {
        		long L=q[1];
        		long R=q[2];
        		int idxL=find(L);
        		int idxR=find(R);
 
        		sb.append(three(0,size-1,1,idxL,idxR)).append("\n");
        	}else {
        		int T=(int)q[1];
        		sb.append(list.get(four(0,size-1,1,N-T+1))).append("\n");
        	}
   
        }
        System.out.println(sb);
    }
    public static int find(long target) {
    	int max=list.size()-1;
    	int min=0;
    	while(min<max) {
    		int mid=(max+min)/2;
    		long n=list.get(mid);
    		if(n>=target) {
    			max=mid;	
    		}else  {
    			min=mid+1;
    		}
    	}
    	return min;
    }
    
    public static void insert(int start,int end,int idx,int n) {//
    	if(n<start||end<n) return;
    	
    	tree[idx]++;
    	if(start==end) return;
    	
    	int mid=(start+end)/2;
    	insert(start,mid,idx*2,n);
    	insert(mid+1,end,idx*2+1,n);
    	
    }
    
    public static void lazyinsert(int start,int end,int idx) {
    	if(lazy[idx]!=0) {
    		tree[idx]+=lazy[idx];
    		if(start!=end) {
    			lazy[idx*2]=lazy[idx];
    			lazy[idx*2+1]=lazy[idx];
    		}
    		lazy[idx]=0;
    	}
    }
    
    public static void delete(int start,int end,int idx,int n) {
    	if(n<start||end<n) return;
    	
    	tree[idx]--;
    	if(start==end) return;
    	
    	int mid=(start+end)/2;
    	delete(start,mid,idx*2,n);
    	delete(mid+1,end,idx*2+1,n);
    }
    
    public static int three(int start,int end,int idx,int ts,int te) {
    	if(te<start||end<ts) return 0;
    	
    	if(ts<=start&&end<=te) return tree[idx];
    	
    	int mid=(start+end)/2;
    	return three(start,mid,idx*2,ts,te)+three(mid+1,end,idx*2+1,ts,te);
    	
    }
    
    public static int four(int start,int end,int idx,int T) {
    	if(start==end) return start;
    	
    	int mid=(start+end)/2;
    	
    	if(tree[idx*2]>=T) {
    		return four(start,mid,idx*2,T);
    	}else {
    		return four(mid+1,end,idx*2+1,T-tree[idx*2]);
    	}
    }
    
}