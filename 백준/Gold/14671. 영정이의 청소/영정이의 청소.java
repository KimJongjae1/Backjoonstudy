import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

   static int N;
   static int M;
   static  StringBuilder sb;
   static int[][] arr;
   static int[] diy= {-1,1,-1,1};
   static int[] dix= {-1,1,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


	        sb=new StringBuilder();
	     	N=Integer.parseInt(st.nextToken());
	     	M=Integer.parseInt(st.nextToken());
	     	int K=Integer.parseInt(st.nextToken());
	     	
	     	arr=new int[N+1][M+1];
	     
	     	Queue<int[]> qu=new LinkedList<>();
	     	for(int i=0;i<K;i++) {
	     		st=new StringTokenizer(br.readLine());
	     		int y=Integer.parseInt(st.nextToken());
	     		int x=Integer.parseInt(st.nextToken());
	     		arr[y][x]=1;
	     		qu.offer(new int[] {y,x});
	     	}
	     	boolean oddeven=false;
	     	boolean oddodd=false;
	     	boolean eveneven=false;
	     	boolean evenodd=false;
	     	while(!qu.isEmpty()) {
	     		int[] cur=qu.poll();
	     		int y=cur[0];
	     		int x=cur[1];
	     		
	     		if(y%2==0&&x%2==0) {
	     			eveneven=true;
	     		}else if(y%2==1&&x%2==0) {
	     			oddeven=true;
	     		}else if(y%2==0&&x%2==1) {
	     			evenodd=true;
	     		}else {
	     			oddodd=true;
	     		}
	     		
	     		if(oddodd&&oddeven&&evenodd&&eveneven) {
	     			System.out.println("YES");
	     			return;
	     		}
	     	}
	   System.out.println("NO");
    }
 

}