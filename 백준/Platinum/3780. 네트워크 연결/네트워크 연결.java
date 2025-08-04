import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;



public class Main {
    static int N;
    static int[] parent;
    static int[] link;
    static int find(int x) {
    	if(parent[x]==x) return x;
    	else{
    		
    		int temp=find(parent[x]);
    		 dp[x]+=dp[parent[x]];
    		 parent[x]=temp;
    		 return temp;
    	}
    }
    static void unit(int a,int b) {
    	
    	dp[a]+=Math.abs(a-b)%1000;
    	parent[a]=b;
    
    }
    static int[] dp;
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;
        int T=Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++) {
        	
        	int N=Integer.parseInt(br.readLine());
        	parent=new int[N+1];
        	dp=new int[N+1];
        	for(int i=1;i<=N;i++) {
        		parent[i]=i;
        	}
        	
        	StringBuilder sb=new StringBuilder();
 
        	while(true) {
        		st=new StringTokenizer(br.readLine()) ;
        		char a=st.nextToken().charAt(0);
        		if(a=='E') {
        			int n=Integer.parseInt(st.nextToken());
        			find(n);
        			sb.append(dp[n]).append("\n");
        		}else if(a=='I') {
        			int n=Integer.parseInt(st.nextToken());
        			int n2=Integer.parseInt(st.nextToken());
        			unit(n,n2);
        		}else {
        			break;
        		}
        	}
        	
        	System.out.print(sb);
        }
    }
  }
 