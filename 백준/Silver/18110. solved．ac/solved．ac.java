import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> list= new ArrayList<>();
    
    	
    double n =Integer.parseInt(br.readLine());
    
    double temp =n*0.15;
 
    if(temp%1>=0.5) {
    	temp-=temp%1;
    	temp+=1;
    }else {temp-=temp%1;}//10---2 5--1
    int N= (int)temp;
    int all = (int)n;
    
    double sum=0;
    for(int i=0;i<all;i++) {
    	list.add(Integer.parseInt(br.readLine()));
    	sum+=list.get(i);
    }
 
    	Collections.sort(list);
    	 
    	for(int i=0;i<temp;i++) {//01     89    10개 4
    		sum-=(list.get(i)+list.get(all-1-i));
    	}
    	
    	 sum/=(all-2*N);
    	 if(sum%1>=0.5) {
    		 sum-=sum%1;
    	    	sum+=1;
    	    }else {sum-=sum%1;}
    	 int ans =(int)sum;
    	System.out.println(ans);
  }
}