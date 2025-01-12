import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	
   Loop:while(true) {
    	String str =br.readLine();
    	if(str.equals(".")) break;
    	
    	ArrayList<Character> list = new ArrayList<>();
    	ArrayList<Character> list2 = new ArrayList<>();
    	int count=0;
    	for(int i=0; i<str.length()-1;i++) {
    		char temp = str.charAt(i);
    	    if(temp=='('||temp=='[') {
    	    	list.add(temp);
    	    	count++;
    	    }
    		if(temp==')'&&count>0) {
    	    	if(list.get(count-1) == '(')
    	    	list.remove(count-1);
    	    	count--;
    	    }else if(temp==')'&&count==0) {
    	    	System.out.println("no");
    	    	continue Loop;
    	    }
    		if(temp==']'&&count>0) {
    	    	if(list.get(count-1) == '[')
    	    	list.remove(count-1);
    	    	count--;
    		}else if(temp==']'&&count==0) {
    	    	System.out.println("no");
    	    	continue Loop;
    	    }
    		
    	}
    	list.add(null);
    	if(list.get(0)==null) {
    		System.out.println("yes");
    	}else {System.out.println("no");}
    	
    	
    	
    }

  }    
}  