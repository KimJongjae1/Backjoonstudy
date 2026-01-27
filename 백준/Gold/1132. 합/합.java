import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int T;
   static int idx;
   static long max;
   static  StringBuilder sb;
   static long[] arr;
   static int[] dp;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<int[]>[] list;
   static TreeSet<Integer> set;  
   static Map<Integer,Integer>[] map;
   static class Alpha implements Comparable<Alpha>{
	   int id;
	   long sum;
	   int ZeroX;
	   
	   Alpha(int id){
		   this.id=id;
	   }
	   
	   public int compareTo(Alpha a) {
		   if(a.sum!=this.sum) return Long.compare(a.sum,this.sum);
		   else return a.ZeroX-this.ZeroX;
	   }
	   
   }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        	sb=new StringBuilder();
     
        	
	        StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			Alpha[] Alpha=new Alpha[26];
			for(int i=0;i<26;i++) 
				Alpha[i]=new Alpha(i);
			
	
			for(int i=0;i<N;i++) {
				String str=br.readLine();
				long level=1;
				Alpha[str.charAt(0)-'A'].ZeroX=1;
				for(int k=str.length()-1;k>=0;k--) {
					Alpha[str.charAt(k)-'A'].sum+=level;
					level*=10;
				}
			}

			Arrays.sort(Alpha);
			int level=9;
			for(int i=9;i>=0;i--) {
				if(Alpha[i].ZeroX==0) {
					Alpha[i].sum=0;
	
					break;
				}
			}

			for(int i=0;i<10;i++) {
				if(Alpha[i].sum==0)continue;
				ans+=Alpha[i].sum*level;
				//System.out.println(Alpha[i].sum*level+" "+level+" "+Alpha[i].sum+" "+Alpha[i].id);
				level--;
			}
			System.out.println(ans);
			
    }
    
}