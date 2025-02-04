import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N;
	//1-3-2 
	//4-5-6
	public static int bfs(int[][] arr,int a) {
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean[] check =new boolean[N+1];
		check[a]=true;
		qu.offer(new int[]{a,1});
		int count=0;
	
		while(!qu.isEmpty()) {
			int[] temp =qu.poll();
		
			for(int i=1;i<=N;i++) {
				
				if(arr[temp[0]][i]==1&&check[i]==false) {
					check[i]=true;
					count+=temp[1];
					qu.offer(new int[]{i,temp[1]+1});
				}
			}
		}
		return count;
	}
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    StringTokenizer st = new StringTokenizer(br.readLine());
    N=Integer.parseInt(st.nextToken());//유저 수
    int M=Integer.parseInt(st.nextToken());//친구 수
    int[][] bacon = new int[N+1][N+1];
   
   for(int i=0;i<M;i++) {
	    st = new StringTokenizer(br.readLine());
	    int a=Integer.parseInt(st.nextToken());
	    int b=Integer.parseInt(st.nextToken());
	    bacon[a][b]=bacon[b][a]=1;
   	}
    int mincount=1000000000;
    int ans=N+1;
    for(int i=N;i>=1;i--) {
    	int num =bfs(bacon,i);
    	if(mincount>=num) {
    		mincount=num;
    		ans=i;
    	}
    }
   System.out.println(ans);

   } 
}