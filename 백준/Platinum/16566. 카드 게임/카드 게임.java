import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parent;
	static int findparent(int x) {
		if(parent[x]==x) return x;
		else return parent[x]=findparent(parent[x]);
	}
	static void union(int a,int b) {
		a=findparent(a);
		b=findparent(b);
		
		parent[a]=b;
	}
	static int[] arr;
	static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
       N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
       int K=Integer.parseInt(st.nextToken());
       StringBuilder sb=new StringBuilder();
       parent=new int[N+2];
       for(int i=0;i<=N+1;i++) {
    	   parent[i]=i;
       }
       st=new StringTokenizer(br.readLine());
       arr=new int[M];
       for(int i=0;i<M;i++) {
    	   arr[i]=Integer.parseInt(st.nextToken());
       }
       Arrays.sort(arr);
       
       st=new StringTokenizer(br.readLine());
       for(int i=0;i<K;i++) {
    	   int a=Integer.parseInt(st.nextToken());
    	   int idx=upperbound(a);
    	   int n=arr[idx];
    	   parent[n]=findparent(n);
    	   if(parent[n]==n) {
    		   sb.append(n+"\n");
    	   }else {
    		   sb.append(parent[n]+"\n");
    	   }
    	    
    	    int newunion=upperbound(parent[n]);
    	    if(newunion!=M)
    	   union(parent[n],arr[newunion]);
    	   
       }
       
       System.out.println(sb);
    }
    public static int upperbound(int target) {
    	int max=M;
    	int min=0;
    	while(min<max) {
    		 int mid=(max+min)/2;
    		 
    		 if(arr[mid]<=target) {
    			 min=mid+1;
    		 }else {
    			 max=mid;
    		 }
    		 
    	}
    	return min;
    }
}