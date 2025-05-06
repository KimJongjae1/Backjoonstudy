import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N;
	static int M;
	
   public static class pair{
	   int p;
	   int l;
	   
	   public pair(int p,int l) {
		   this.p=p;
		   this.l=l;
	   }
   }
     public static void main (String[] args) throws IOException {
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	 StringBuilder sb=new StringBuilder();
    	 N=Integer.parseInt(br.readLine());
    	 
    	    TreeSet<pair> tree=new TreeSet<>(new Comparator<pair>() {
    	    	@Override
    	    	public int compare(pair a,pair b) {
    	    		if(a.l==b.l) {
    	    			return Integer.compare(a.p, b.p);
    	    		}else {
    	    			return Integer.compare(a.l, b.l);
    	    		}
    	    	}
    	    });
    	    Map<Integer,Integer> exist=new HashMap<>();
        
    	    for(int i=0;i<N;i++) {
	    	   	 StringTokenizer st=new StringTokenizer(br.readLine());
	    	   	int problemnum=Integer.parseInt(st.nextToken());
	    	   	int level=Integer.parseInt(st.nextToken());
	    	   	
	    	   	exist.put(problemnum,level);
	    	   	tree.add(new pair(problemnum,level));
    	   	     
    	    }
    
    		 M=Integer.parseInt(br.readLine());
    	     
    		 for(int i=0;i<M;i++) {
    			 StringTokenizer st=new StringTokenizer(br.readLine());
    			 String order=st.nextToken();
    			 switch(order) {
    			    
    			 case "add":
    				 int problemnum=Integer.parseInt(st.nextToken());
    	    	   	 int level=Integer.parseInt(st.nextToken());
    	    	   	
    	    	   	exist.put(problemnum,level);
    	    	   	tree.add(new pair(problemnum,level));
    	    	   	break;
    			 case "recommend":
    				 int x=Integer.parseInt(st.nextToken());
    				
    				 if(x==1) {
    					 System.out.println(tree.last().p);
    				 }else {
    					 System.out.println(tree.first().p);
    				 }
    				 
    				 break;
    				 
    			 case "solved":
    				 problemnum=Integer.parseInt(st.nextToken());
    				 level=exist.get(problemnum);
    				 
    				 exist.remove(problemnum);
    				 tree.remove(new pair(problemnum,level));
    				 
    				 break;
    				 
    			 }
    			 
    			 
    		 }
    	     
    	    
    	 
    }
     
}
