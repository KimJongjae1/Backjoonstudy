import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	 static int N;
	 static PriorityQueue<Integer> pq;
	 static int tempmax=0;
	 static int realmax=0;
	 static class Node {
		 List<Node> child=new ArrayList<>();
		 int dist;
		
		 Node(){}
		 
		 Node(int dist){
			 this.dist=dist;
		 }
	 }
	 
     public static void main(String[] args)throws Exception {
	 BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
       
	    N=Integer.parseInt(br.readLine());
	    if(N==1) {
	    	System.out.println(0);
	    	return;
	    }
        Node[] tree=new Node[N+1];
    
	    for(int i=1;i<N;i++) {
	    	 StringTokenizer st =new StringTokenizer(br.readLine()); 
	    	 int startnode =Integer.parseInt(st.nextToken());
	    	 int tonode =Integer.parseInt(st.nextToken());
	    	 int dist =Integer.parseInt(st.nextToken());
	    	 
	    	 if(tree[startnode]==null)  tree[startnode]=new Node();
	    	 
	    	 if(tree[tonode]==null)  tree[tonode]=new Node(dist);
	    	 
	    	 tree[startnode].child.add(tree[tonode]);
	    	 tree[tonode].dist=dist;
	    }
	   
	   for(int i=1;i<=N;i++) {
		   pq=new PriorityQueue<>(Collections.reverseOrder());
		  if(tree[i].child.size()==0) continue;
			  for(Node a:tree[i].child) {
				  tempmax=0;
				  findlong(a,a.dist);
				  pq.offer(tempmax);
			  }
			  
			  
		  if(tree[i].child.size()==1) {
			  realmax=Math.max(realmax, pq.poll());
			  continue;
		  }
		  
		  realmax=Math.max(realmax, pq.poll()+pq.poll());
	   }
	    
	   System.out.println(realmax);
     }
     public static void findlong(Node a,int sum) {//1==left 2==right
    	 if(a.child.size()==0) {
    		 tempmax=Math.max(tempmax, sum);
    		 return;
    	 }
    	 
    	 for(Node next:a.child) {
    		 findlong(next,sum+next.dist);
    	 }
    	 
     }
     public static void back() {
    	 
     }
     
 }
 