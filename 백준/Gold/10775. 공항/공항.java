import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N;
    static int[] parent;
    static int find(int a) {
    	if(parent[a]==a) return a;
    	else return parent[a]=find(parent[a]);
    }
    static void unit(int a,int b) {
    	int A=find(a);
    	int B=find(b);
    	
    	parent[A]=B;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
        parent=new int[N+1];
        for(int i=1;i<=N;i++) {
        	parent[i]=i;
        }
        int cnt=0;
       // StringBuilder sb=new StringBuilder();
        int M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
        	int a=Integer.parseInt(br.readLine());
        	
     
        	if(find(a)==0)break;
        	else {
        		unit(a,parent[a]-1);
        	}
        	
        	
        	cnt++;
        }
        System.out.println(cnt);
        
    }
}