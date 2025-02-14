import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; 
    static int M; 
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();
	static void back(int[] arr) {
		
		if(list.size()==M) {
			for(int i=0;i<M;i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
			for(int i=0;i<N;i++) {
				if(!list.contains(arr[i])) {
			    list.add(arr[i]);
				back(arr);
			     list.remove(list.size()-1);}
			}
		
		
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
         StringTokenizer st = new StringTokenizer(br.readLine());	    
		 N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
	    int[] arr= new int[N];
	    st = new StringTokenizer(br.readLine());	 
	    
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
	   
		Arrays.sort(arr);
		back(arr);
		System.out.println(sb);
		
	}
  }

