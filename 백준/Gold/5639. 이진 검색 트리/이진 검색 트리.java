import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value=value;
			this.left=null;
			this.right=null;
		}
		
		public void insert(int n) {
			if(n<this.value) {
				if(this.left==null) this.left=new Node(n);
				else {this.left.insert(n);}
			}else {
				if(this.right==null) this.right=new Node(n);
				else {this.right.insert(n);}
			}
		}
	}
	
	
	
     public static void main(String args[]) throws IOException{
     BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
     
      
     
      Node root =new Node(Integer.parseInt(br.readLine()));
     String str="";
  
	     while((str=br.readLine())!=null) {
	    	 if(str==null||str.equals("")) break; 
	         root.insert(Integer.parseInt(str));	    
	     }

	    backflow(root);
	    
     }
    
     public static void backflow(Node a) {
    	 if(a==null) {
    		 return;
    	 }
    	 
    
    		 backflow(a.left);
    		 backflow(a.right);
    	 System.out.println(a.value);
    	 
    	 
     }
}