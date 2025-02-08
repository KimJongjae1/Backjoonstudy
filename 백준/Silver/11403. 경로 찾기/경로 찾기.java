import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Stack;
public class Main {
	static int N;
	static int[][] ans;
	public static void dfs(int[][] a,int b) {//a는 경로 표시 b는 check c는 check될 행
		Stack<Integer> stack = new Stack<>();
		boolean[] check = new boolean[N];
		stack.push(b);
		
        while(!stack.isEmpty()) {
        	int temp=stack.pop();
        	if(check[temp]==false) {
        	for(int i=0;i<N;i++) {
        		if(a[temp][i]==1) {
        			ans[b][i]=1;
        			stack.push(i);
        			
        		 }
        	   }
        	}
        	check[temp]=true;
        	
        }

	}
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb =new StringBuilder();
    N = Integer.parseInt(br.readLine());
   
    int[][] arr=new int[N][N];
    
    for(int i=0;i<N;i++) {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int k=0;k<N;k++) {
    	arr[i][k]=Integer.parseInt(st.nextToken());
    	}
    }
    ans=new int[N][N];
    for(int i=0;i<N;i++) {
    	dfs(arr,i);
    	for(int k=0;k<N;k++) {
    	sb.append(ans[i][k]).append(" ");
    	}
    	sb.append("\n");
    }
    System.out.println(sb);
   } 
}