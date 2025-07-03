import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static Integer N;
    public static int[] tree;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
          tree=new int[4*2000001];
          int max=2000001;
          StringBuilder sb=new StringBuilder();
          for(int i=0;i<N;i++) {
        	  st=new StringTokenizer(br.readLine());
        	  int order=Integer.parseInt(st.nextToken());
        	  int num=Integer.parseInt(st.nextToken());
        	  
        	  if(order==1) {
        		  update(1,max,1,num);
        	  }else {
        		  sb.append(delete(1,max,1,num)).append("\n");
        	  }
        	  
          }
          System.out.println(sb);
          
        
    }
    public static void update(int start,int end,int idx,int num) {
    	if(num<start||end<num) return;
    	tree[idx]++;
    	if(start==end) return;
    	
    	int mid=(start+end)/2;
    	
    	update(start,mid,idx*2,num);
    	update(mid+1,end,idx*2+1,num);
    	
    }
    
    public static int delete(int start,int end,int idx,int q) {
    	if(start==end) {
    		tree[idx]--;
    		return start;
    	}
    	
    	tree[idx]--;
    	int mid=(start+end)/2;
    	if(tree[2*idx]>=q) {
    		return delete(start,mid,idx*2,q);
    	}else {
    		return delete(mid+1,end,idx*2+1,q-tree[idx*2]);
    	}
    	
    }
    
}

