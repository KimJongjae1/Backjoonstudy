import java.io.*;
import java.util.*;

public class Main {
     static int V;
     static int E;
     static List<List<Integer>> list;
     static int[] color;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
       Loop: for(int t=0;t<T;t++) {
        	
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	 V=Integer.parseInt(st.nextToken());
        	 E=Integer.parseInt(st.nextToken());
        	list=new ArrayList<>();
        	 for(int i=0;i<=V;i++) {
        		 list.add(new ArrayList<>());
        	 }
        	 
        	 for(int i=0;i<E;i++) {
        		 st=new StringTokenizer(br.readLine());
        		 int a=Integer.parseInt(st.nextToken());
        		 int b=Integer.parseInt(st.nextToken());
        		 list.get(a).add(b);       		 
        		 list.get(b).add(a);       		 
        	 }
        	 color=new int[V+1];
        	 int cnt=0;
        	 for(int i=1;i<=V;i++) {
        		 if(color[i]==0) {
        			 if(!bfs(i)) {
        				 System.out.println("NO");
        				 continue Loop;
        			 }
        		 }
        	 }
        	 System.out.println("YES");
        	
        }
    }
    public static boolean bfs(int start) {
    	Queue<Integer> qu=new LinkedList<>();
    	qu.offer(start);
    	color[start]=1;
    	while(!qu.isEmpty()) {
    		int now=qu.poll();
    		
    		for(int next:list.get(now)) {
    			if(color[next]==0) {
    				color[next]=-color[now];
    				qu.offer(next);
    			}else if(color[next]==color[now]){
    				return false;
    			}
    		}
    	
    		
    	}
    	
    	return true;
    	
    }
}