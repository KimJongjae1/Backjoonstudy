import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int N;
	static long result;
	static TreeMap<Integer,Integer> tree;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());  
			StringBuilder sb=new StringBuilder();
		 

			  N=Integer.parseInt(st.nextToken());
			
			  int[] num=new int[N+2];
			  tree=new TreeMap<>();
			  int root=Integer.parseInt(br.readLine());
			  tree.put(root,1);
			  result=1;
			  for(int i=1;i<N;i++) {
				  int a=Integer.parseInt(br.readLine());
				  Integer high=tree.higherKey(a);
				  Integer low=tree.lowerKey(a);
				  if(high==null) {
					  int ret=tree.get(low)+1;
					  tree.put(a, ret);
					  result+=ret;
				  }else if(low==null){
					  int ret=tree.get(high)+1;
					  tree.put(a, ret);
					  result+=ret;
				  }else {
					  int ret=Math.max(tree.get(high),tree.get(low) )+1;
					  tree.put(a, ret);
					  result+=ret;
				  }
			  }
			  
			  System.out.println(result);
			  
			
	 }
	 

 }
