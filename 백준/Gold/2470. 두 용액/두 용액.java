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
   static int a;
   static int b;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        
        List<Integer> acid=new ArrayList<>();
        List<Integer> hydrolic=new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	int n=Integer.parseInt(st.nextToken());
        	if(n<0)hydrolic.add(n);
        	else acid.add(n);
        }
       
      Collections.sort(acid);
      Collections.sort(hydrolic,Collections.reverseOrder());
      ans=Integer.MAX_VALUE;
      if(hydrolic.size()>=2) {
    	  int diff=Math.abs(hydrolic.get(0)+hydrolic.get(1));
    	  if(ans>diff) {
    		  ans=diff;
    		  a=hydrolic.get(0);
    		  b=hydrolic.get(1);
    	  }
      }
      if(acid.size()>=2) {
    	  int diff=acid.get(1)+acid.get(0);
    	  if(ans>diff) {
    		  ans=diff;
    		  a=acid.get(1);
    		  b=acid.get(0);
    	  }
      }  
    	  
    
      if(acid.size()==0) {
    	  System.out.println(b+" "+a);
    	  return;
      }
      for(int i=0;i<hydrolic.size();i++) {
    	  int n=Math.abs(hydrolic.get(i));
    	  int id=lowerbound(n,acid);

    	  int diff=Math.abs(acid.get(id)-n);
    	  compare(diff,acid.get(id),-n);

    	  if(id>0) {
    		 int diff2=Math.abs(acid.get(id-1)-n);
    		  compare(diff2,acid.get(id-1),-n);
    	  }
    	  

      }
       System.out.println(b+" "+a);
        
    }
    public static void compare(int diff,int A,int B) {
    	  if(ans>diff) {
    		  ans=diff;
    		  a=A;
    		  b=B;
    	  }
    }
    
    public static int lowerbound(int target,List<Integer> acid) {
    	int max=acid.size()-1;
    	int min=0;
    	while(min<max) {
    		int mid=(max+min)/2;
    		
    		if(acid.get(mid)<target) {
    			min=mid+1;
    		}else {
    			max=mid;
    		}
    		
    	}
    	return min;
    }
}