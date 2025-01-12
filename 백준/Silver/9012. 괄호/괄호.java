import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
	
   public static void main(String[] args) throws IOException {
   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
   
   int N=Integer.parseInt(br.readLine());
   
   Loop:for(int i=0;i<N;i++) {
	   String str=br.readLine();
	   ArrayList<Character> list = new ArrayList<>();
	   int count=0;
	   
	   for(int k=0;k<str.length();k++) {
		   if(str.charAt(k)=='(') {
			   list.add('(');
			   count++;  
		   }
		   
		   if(str.charAt(k)==')'&&count==0) {
			   System.out.println("NO");
			   continue Loop;
		   }
		   
		   if(str.charAt(k)==')'&&count>0) {
			   if(list.get(count-1)=='(') {
				   list.remove(count-1);
				   count--;
			   }
		   }
	   }
	   list.add(null);
	   if(list.get(0)==null) {
		   System.out.println("YES");
	   }else {System.out.println("NO");}
   }
    	
    	

  }    
}   