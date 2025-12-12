import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static  StringBuilder sb;
   static int[] arr;
   static int[][] dp;
   static int ans;
   static int[] diy= {-1,1,0,0};
   static int[] dix= {0,0,-1,1};
   static boolean[] visit;
   static List<Integer>[] list;
   static  Queue<Integer> truck;
   static Queue<Integer> bridge;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N+1];
       truck=new LinkedList<>();
        bridge=new LinkedList<>();
        st=new StringTokenizer(br.readLine());

       for(int i=0;i<N;i++) {
    	   truck.offer(Integer.parseInt(st.nextToken()));
       }
       for(int i=0;i<M;i++) {
    	   bridge.add(0);
       }
       int time=move();
       System.out.println(time);
       
    }
    public static int move() {
    
    	int weight=0;
    	int time=0;
    	while(!bridge.isEmpty()) {
    		time++;
    		weight-=bridge.poll();
    		
    		if(!truck.isEmpty()) {
    			if(truck.peek()+weight<=K) {
    				weight+=truck.peek();
    				bridge.add(truck.poll());
    			}else {
        			bridge.add(0);
        		}
    		}
    		
    		
    	}
    	return time;
    	
    }
    	
    
}