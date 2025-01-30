import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static boolean[] check;
	static boolean[] check2;
	static int N;
	static int count=0;
	public static void dfs(int[][] a, int b) {
		if(check2[b]==true) {
		check[b]=true;
		check2[b]=false;
		for(int i=1;i<=N;i++) {
			if(check[i]==false&&a[b][i]==1) {
				dfs(a,i);
			}
		}
	}else {
		count--;
	}
		
	}
     
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    StringTokenizer st =new StringTokenizer(br.readLine());
    
    N= Integer.parseInt(st.nextToken());
    int M= Integer.parseInt(st.nextToken());
    int[][] map = new int[N+1][N+1];
    check = new boolean[N+1];
    check2 = new boolean[N+1];
    
    for(int i=0;i<M;i++) {
    	st =new StringTokenizer(br.readLine());
        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        
        map[a][b]=map[b][a]=1;
    
    }
    Arrays.fill(check2, true);
     
      for(int i=1;i<=N;i++) {
    	  dfs(map,i);
    	      count++;
      }
      System.out.println(count);
   } 
}