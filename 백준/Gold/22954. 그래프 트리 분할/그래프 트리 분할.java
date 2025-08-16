import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;



public class Main { 
    static int N;
    static List<int[]>[] list;
    static StringBuilder sb;
    static StringBuilder sb2;
    static StringBuilder sb3;
    static StringBuilder sb4;
    static StringBuilder sb5;
    static List<Integer> node;
    static List<Integer> way;
    static int N1;
    static int N2;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
    	 sb=new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
      int M=Integer.parseInt(st.nextToken());
    
        list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
        	 st=new StringTokenizer(br.readLine()) ;
        	 int a=Integer.parseInt(st.nextToken());
        	 int b=Integer.parseInt(st.nextToken());
        	 
        	 list[a].add(new int[] {i+1,b});
        	 list[b].add(new int[] {i+1,a});
        }
        
        if(N<=2) {
      	  System.out.println(-1);
      	  return;
        }
        sb2=new StringBuilder();
     	 sb3=new StringBuilder();
     	 sb4=new StringBuilder();
     	 sb5=new StringBuilder();
 	 	node=new ArrayList<>();
   	 	way=new ArrayList<>();
       boolean[] checkvisit=new boolean[N+1];
       int treecnt=0;
       for(int i=1;i<=N;i++) {
    	   if(!checkvisit[i]) {
    		   treecnt++;
    		   if(treecnt==1) {
    		   checkTree(i,checkvisit,sb2,sb3);
    		   if(node.size()==N-node.size()) {
    			   System.out.println(-1);
    			   return;
    		   }
    		   sb.append(node.size()).append(" ").append(N-node.size());
    		   }
    		   else checkTree(i,checkvisit,sb4,sb5);
    	
    	   }
    	   if(treecnt==2) {
    		   for(int k=1;k<=N;k++) {
    			   if(!checkvisit[k]) {
    				   System.out.println(-1);
    				   return;
    			   }
    		   }
    		
    		   System.out.println(sb);
    		   System.out.println(sb2);
    		   System.out.println(sb3);
    		   System.out.println(sb4);
    		   System.out.println(sb5);
    		   return;
    	   }
       }
 
       
       sb=new StringBuilder();
       sb2=new StringBuilder();
       sb3=new StringBuilder();
   	 	sb4=new StringBuilder();
   	 	sb5=new StringBuilder();
   
   	 	visit=new boolean[N+1];
   	 	
   	 	
   	 	sb.append(N-1).append(" ").append(1);
   	 	for(int i=0;i<node.size()-1;i++) {
   	 		sb2.append(node.get(i)).append(" ");
   	 	}
   	 	for(int i=0;i<way.size()-1;i++) {
   	 		sb3.append(way.get(i)).append(" ");
   	 	}
   	 	sb4.append(node.get(node.size()-1));

   	 	System.out.println(sb);
   	 	System.out.println(sb2);
   	 	System.out.println(sb3);
   	 	System.out.println(sb4);
   	 	System.out.println(sb5);
       
       
    }
    public static void checkTree(int start,boolean[] check,StringBuilder sb1,StringBuilder sb2) {
    	 Queue<Integer> qu=new LinkedList<>();
    	 qu.offer(start);
    	 check[start]=true;
    	 sb1.append(start).append(" ");
    	 node.add(start);
    	 while(!qu.isEmpty()) {
    		 int cur=qu.poll();
    	
    		 for(int[] next:list[cur]) {
    			 if(check[next[1]]) continue;
    			 check[next[1]]=true;
    			 qu.offer(next[1]);

    			 node.add(next[1]);
    			 way.add(next[0]);
    			 sb1.append(next[1]).append(" ");
    			 sb2.append(next[0]).append(" ");
    		 }
    	 }
  
    }

    
  }
 