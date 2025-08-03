import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;



public class Main {
    static int N;
    static int K;
    static String[] str;
    static class trienode{
    	Map<Character,trienode> map=new HashMap<>();
    	boolean noDelete;
    	boolean yesDelete;
    	
    	trienode(){
    		
    	}
    	
    	public void insert(String str) {
    		trienode t=this;
    		for(int i=0;i<str.length();i++) {
    			char a=str.charAt(i);
    			t.map.putIfAbsent(a, new trienode());
    			t=t.map.get(a);
    			t.noDelete=true;
    		}
    
    	}
    	
    	public void noDeleteCheck(String str) {
    		trienode t=this;
    		for(int i=0;i<str.length();i++) {
    			char a=str.charAt(i);
    			t.map.putIfAbsent(a, new trienode());
    		}
    	}
    	
    	public int check(String str) {
    		trienode t=this;
    		for(int i=0;i<str.length();i++) {
    			char a=str.charAt(i);
    			if(t.yesDelete) 
					return 0;
    			
    			if(t.map.containsKey(a)) {
    				t=t.map.get(a);
    			}else {
    				t.map.put(a, new trienode());
    				t=t.map.get(a);
    				t.yesDelete=true;
    				return 1;
    			}
    		}

    		return 1;
    	}
     }
    
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()) ;
        int T=Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++) {
        	
        	int N1=Integer.parseInt(br.readLine());
        	str=new String[N1];
        	for(int i=0;i<N1;i++) {
        		str[i]=br.readLine();
        	}
         
        	int M=Integer.parseInt(br.readLine());
        	if(M==0) {
        		System.out.println(1);
        		continue;
        	}
        	Arrays.sort(str,new Comparator<String>() {
        		@Override
        		public int compare(String a,String b) {
        			if(a.length()!=b.length()) return a.length()-b.length();
        			else return a.compareTo(b);
        		}
        	});
        	
        	trienode start=new trienode();
        	for(int i=0;i<M;i++) {
        		start.insert(br.readLine());
        	}
        
        	int ret=0;
        
            for(int i=0;i<N1;i++) {
            	int a=start.check(str[i]);
            	ret+=a;
            }
             System.out.println(ret);
        }
    }
  }
 