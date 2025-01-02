import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main {
	
	static int maxX=0;
    static int maxY=0; 
    static int x;
    static int y;
    static ArrayList<Integer> h0= new ArrayList<>(); // 배열 크기 동적으로 할당
    static ArrayList<Integer> v1= new ArrayList<>(); // 배열 크기 동적으로 할당
 
        
	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st= new StringTokenizer(br.readLine());
    
    x=Integer.parseInt(st.nextToken());
    y=Integer.parseInt(st.nextToken());
    int N=Integer.parseInt(br.readLine());
     
    
    h0.add(0);
    h0.add(y);
    v1.add(0);
    v1.add(x);
    for(int i=0;i<N;i++) {
    	st = new StringTokenizer(br.readLine());
    	int type = Integer.parseInt(st.nextToken());
    	
    	if(type==0) {
    		h0.add(Integer.parseInt(st.nextToken()));
    	}else {v1.add(Integer.parseInt(st.nextToken()));}
    }
    
   Collections.sort(h0);
   Collections.sort(v1);
   
   h0sort();
   v1sort();

   System.out.println(maxX * maxY);
   
}
   public static void h0sort() {
	   for(int i=0;i<h0.size()-1;i++) {
		   int dis = h0.get(i+1)-h0.get(i);
		   maxY=Math.max(maxY, dis);
	   }
   }
   public static void v1sort() {
	   for(int i=0;i<v1.size()-1;i++) {
		   int dis = v1.get(i+1)-v1.get(i);
		   maxX=Math.max(maxX, dis);
	   }
   }
   
}