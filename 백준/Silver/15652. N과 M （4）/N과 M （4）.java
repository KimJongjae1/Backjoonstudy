import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list;
	static boolean[] visited;
    public static void back(int a) {
      
    	if(list.size()==M) {
    		for(int i=0;i<M;i++) {
    			sb.append(list.get(i)).append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i=a;i<=N;i++) {
    		list.add(i);
    		back(i);
    		list.remove(list.size()-1);
    	}
    
    	
    }
	
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	    StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		 M=Integer.parseInt(st.nextToken());
		
		list =new ArrayList<>();
		visited=new boolean[N+1];
		back(1);
		System.out.println(sb);
		
	}
  }