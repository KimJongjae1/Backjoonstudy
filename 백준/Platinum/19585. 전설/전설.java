import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	static int N;
	static StringBuilder sb;
	static TreeSet<String> set;
	static class trie{
		Map<Character,trie> child=new TreeMap<>();
		boolean terminal;
		
		trie(){
			
		}
		
		 void insert(String str) {
			trie t=this;
			for(int i=0;i<str.length();i++) {
				t.child.putIfAbsent(str.charAt(i),new trie());
				t=t.child.get(str.charAt(i));
			}
			t.terminal=true;
		}
		 
		void check(String str) {
			 trie t=this;
			 for(int i=0;i<str.length();i++) {
				
				 if(t.terminal) {
					if(checkleftover(str,i)) {
						sb.append("Yes"+"\n");
						return;
					}
				 }
				 if(t.child.containsKey(str.charAt(i))) {
					 t=t.child.get(str.charAt(i));
				 }else {
					 sb.append("No"+"\n");
					 return;
				 }
			 }
			 sb.append("No"+"\n");
		 }
		 
	}
	public static boolean checkleftover(String str,int a) {
		 String s=str.substring(a,str.length());
	    	
		 if(set.contains(s)) return true; 
		 else return false; 
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;
      
    	  N=Integer.parseInt(st.nextToken());
    	 int M=Integer.parseInt(st.nextToken());
    	 trie color=new trie();
    	 trie name=new trie();
    	 for(int i=0;i<N;i++) {
    		 String str=br.readLine();
    		 color.insert(str);
    	 }
    	set=new TreeSet<>();
    	 for(int i=0;i<M;i++) {
    		 String str=br.readLine();
    		 set.add(str);
    	 }

    	 int K=Integer.parseInt(br.readLine());
    	sb=new StringBuilder();
    	 for(int i=0;i<K;i++) {
    		 String str=br.readLine();
    		 color.check(str);

    	 }
    	 System.out.println(sb);
    }
}
