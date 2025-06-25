import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static List<Integer> left;
    public static List<Integer> right;
    public static int M;
    public static int[] w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());;
       M=Integer.parseInt(st.nextToken());

         w=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	w[i]=Integer.parseInt(st.nextToken());
        }
        
       left=new ArrayList<>();
        right=new ArrayList<>();
        
        dfs(0,0,N/2,left);
        dfs(0,N/2+1,N-1,right);

        Collections.sort(left);
        Collections.sort(right);
        
        int result=0;
        int end=right.size()-1;
        
        for(int i=0;i<left.size();i++) {
        	int le=left.get(i);
        	while(end>=0&&le+right.get(end)>M) {
        		end--;
        	}
        	result+=end+1;
        }
        System.out.println(result);
    }
    public static void dfs(int sum,int start,int end,List<Integer> list) {
    	if(sum>M) return;
    	
    	if(start>end) {
    		list.add(sum);
    		return;
    	}
    	
    	dfs(sum,start+1,end,list);
    	dfs(sum+w[start],start+1,end,list);
    	
    }
}
