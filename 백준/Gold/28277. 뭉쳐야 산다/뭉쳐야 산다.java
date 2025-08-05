import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N;
    static  int[] idx;
 
    static void union(int a,int b) {
    	int A=idx[a];
    	int B=idx[b];
    	if(set[A].size()<set[B].size()) {
    		set[B].addAll(set[A]);
    		idx[a]=B;
    		set[A].clear();
    	}else {
    		set[A].addAll(set[B]);
    		set[B].clear();
    	}
    	idx[b]=0;
    }
    static  HashSet<Integer>[] set; 
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        set=new HashSet[N+1];
        set[0]=new HashSet<>();
        idx=new int[N+1];
        for(int i=1;i<=N;i++) {
        	idx[i]=i;
        	st=new StringTokenizer(br.readLine()) ;
        	set[i]=new HashSet<>();
        	int n=Integer.parseInt(st.nextToken());
        	for(int k=0;k<n;k++) {
        		set[i].add(Integer.parseInt(st.nextToken()));
        	}
        }
    
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine()) ;
        	int order=Integer.parseInt(st.nextToken());
        	if(order==1) {
        		int a=Integer.parseInt(st.nextToken());
        		int b=Integer.parseInt(st.nextToken());
        		union(a,b);
        	}else {
        		int n=Integer.parseInt(st.nextToken());
        		sb.append(set[idx[n]].size()).append("\n");
        	}
        }
        System.out.println(sb);
    }
}