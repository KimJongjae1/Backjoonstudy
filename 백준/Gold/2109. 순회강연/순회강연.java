import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
   static int N;
   static int M;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<int[]> list;
   static Set<int[]> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        list=new ArrayList<>();
        
        int D=0;
       for(int i=0;i<N;i++) {
    	   st=new StringTokenizer(br.readLine());
    	  int n=Integer.parseInt(st.nextToken());
    	  int day=Integer.parseInt(st.nextToken());
    	  list.add(new int[] {n,day});
  
       }
       Collections.sort(list, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a,int[] b) {
        		if(a[0]!=b[0])return b[0]-a[0];
        		else return a[1]-b[1];
        	}
        });
       
       int[] day=new int[10001];
       for(int i=0;i<N;i++) {
    	   int[] lecture=list.get(i);
    	   for(int k=lecture[1];k>=1;k--) {
			   if(day[k]==0) {
				   day[k]=1;
				   ans+=lecture[0];
				   break;
			   }
		   }
    	   
    	
       }
        System.out.println(ans);
    }
}