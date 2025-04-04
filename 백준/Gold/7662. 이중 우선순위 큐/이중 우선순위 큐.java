import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	 public static void main(String args[]) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
     int T=Integer.parseInt(br.readLine());
     
     for(int i=0;i<T;i++) {
    	 int K=Integer.parseInt(br.readLine());
    
    	 TreeMap<Integer,Integer>  map = new TreeMap<>(); 
         
    	 for(int k=0;k<K;k++) {
    		 
    	 StringTokenizer st =new StringTokenizer(br.readLine());
         String logic=st.nextToken();
         int num=Integer.parseInt(st.nextToken());
         
         	 if(logic.charAt(0)=='I') {
         		 map.put(num,map.getOrDefault(num, 0)+1);
         	 }
         	 else {
         		 if(map.size()==0) continue;
         		 
         		 if(num==1) {
         			 int key = map.lastKey();
         			 int count=map.get(key);
         			 
         			 if(count==1) map.remove(key);
         			 else {
         				 map.put(key,map.get(key)-1);
         			 }
         			 
         		 }else {
         			 int key = map.firstKey();
         			 int count=map.get(key);
         			 
         			 if(count==1) map.remove(key);
         			 else {
         				 map.put(key,map.get(key)-1);
         			 }
         		 }
         	 }
    	 }
    	 int max=0;int min=0;
    	 if(map.size()==0) {
    		 System.out.println("EMPTY");
    		 continue;
    	 }
    	 else { 
    		 int key = map.lastKey();
 			 int count=map.get(key);
 			 
 			 if(count==1) map.remove(key);
 			 else {
 				 map.put(key,map.get(key)-1);
 			 }
 			 max=key;
 			 
 			 if(map.size()==0)
 				 min=max;
 			 else {
 				 min=map.firstKey();
 			 }
    	 }
    	 System.out.println(max+" "+min);
     }
	}
}