import java.util.*;
import java.io.*;
public class Main {
	

	public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int N =Integer.parseInt(br.readLine());
    
    String[] a = new String[N];
    
    
    for(int i=0;i<N;i++) {
    	a[i]=br.readLine();
  
    }
    
    Arrays.sort(a,new Comparator<String>() {
    	public int compare(String c, String d) {
    	if(c.length()==d.length()) {
    		return c.compareTo(d);
    	}else {
         return Integer.compare(c.length(),d.length());
           }
       }
    });
    sb.append(a[0]).append("\n");
    for(int i=1;i<N;i++) {
    	if(!a[i].equals(a[i-1]))
    	sb.append(a[i]).append("\n");

	}System.out.println(sb);
}}