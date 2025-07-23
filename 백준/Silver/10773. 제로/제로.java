import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	
   public static void main(String[] args) throws IOException {
      Scanner scan = new Scanner(System.in);
	  int K = scan.nextInt();
	  ArrayList<Integer> list =new ArrayList<>();
	  int sum=0;
	  int count=0;
	  for(int i=0;i<K;i++) {
		  int temp =scan.nextInt();
		  
		  if(temp!=0) {	  
		  list.add(temp);
		  count++;
		  }else if(temp==0) {
			  list.remove(count-1);
			  count--;
		  } 
	  }
	  for(int i=0;i<list.size();i++) {
		  sum+=list.get(i);
	  }
    System.out.println(sum);
  }    
}