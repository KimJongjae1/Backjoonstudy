import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static int N;
	static int R;
	static class trienode{
		Map<Character, trienode> child =new HashMap<>();
		boolean terminal;
		
		public trienode(){
			
		}
		
		public void insert(String str) {
			int len=str.length();
			trienode trie=this;
			for(int i=0;i<len;i++) {
				char a=str.charAt(i);
				
				trie.child.putIfAbsent(a, new trienode());
				trie=trie.child.get(a);
				
				if(i==len-1) {
					trie.terminal=true;
				}
				
			}
			
		}
		
		public boolean contain(String str) {
			int len=str.length();
			trienode trie=this;
			for(int i=0;i<len;i++) {
				char a=str.charAt(i);
				
				trie=trie.child.get(a);
				if(trie==null) {
					return false;
				}
				
				
			}
			
			if(trie.terminal) {
				if(trie.child.isEmpty()) {
					return false;
				}
			}
			
			return true;
		}
		
		
	}
	
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		   StringBuilder sb=new StringBuilder();
		   int T =Integer.parseInt(br.readLine());
		Loop:  for(int t=0;t<T;t++) {
			  N=Integer.parseInt(br.readLine());
			  //50*10000*10
			  trienode trie=new trienode();
			  List<String> list=new ArrayList<>();

              for(int i=0;i<N;i++) {
            	  String str=br.readLine();
            	  trie.insert(str);
            	  list.add(str);
              }
			  
              for(int i=0;i<N;i++) {
            	  String str=list.get(i);
            	  if(trie.contain(str)) {
            		  System.out.println("NO");
            		  continue Loop;
            	  }
              }
              System.out.println("YES");
              
		  }

    }

}