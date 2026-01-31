import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


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
   static int[] arr;
   static int[] dp;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<int[]>[] list;
   static Set<Integer> set;  
   static Map<Integer,Integer> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	
	   StringTokenizer st=new StringTokenizer(br.readLine());
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
			
		arr=new int[M];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		

		set=new HashSet<>();
		idx=0;
		for(int i=0;i<M;i++) {
			if(set.size()<N) {
				idx=i;
				set.add(arr[i]);
			}
		
		}

		Loop:for(int i=idx;i<M;i++) {
			if(set.contains(arr[i]))continue;
			int id=-1;
			
				for(int n:set) {
					for(int k=i;k<=M;k++) {
						 if(k==M) {
								change(n,arr[i]);
						
								continue Loop;
							}
						if(n==arr[k]) {
							if(id<k) id=k;
							break;
						}
						
						
					}
				}
				change(arr[id],arr[i]);
			
		}
		System.out.println(ans);
    }
    public static void change(int remove,int add) {
    	set.remove(remove);
    	set.add(add);
    	ans++;
    	
    }
}