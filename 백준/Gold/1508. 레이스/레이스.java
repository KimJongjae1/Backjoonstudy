import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static long max;
   static  StringBuilder sb;
   static int[] arr;
   static int[] dp;
   static int[] judge;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[][][] visit;
   static List<int[]> list;
   static TreeSet<Integer> set;  
   static Map<Integer,Integer>[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer .parseInt(st.nextToken());
		M=Integer .parseInt(st.nextToken());
		K=Integer .parseInt(st.nextToken());

		st=new StringTokenizer(br.readLine());
		judge=new int[K];
		for(int i=0;i<K;i++) {
			judge[i]=Integer.parseInt(st.nextToken());
		}
		int MAX=upperbound();
		int id=1;
		int c=1;
		int before=0;

		sb.append(1);
		while(id<K) {
			if(Math.abs(judge[id]-judge[before])>=MAX&&c<M) {
				before=id;
				sb.append(1);
				c++;
			}else {
				sb.append(0);
			}
			id++;
			
		}
		System.out.println(sb);
		
    }
    public static int upperbound() {
    	int max=N+1;
    	int min=0;
    	while(min<max) {
    		int mid=(max+min)/2;
    	
    		if(exist(mid)) {
    			min=mid+1;
    		}else {
    			max=mid;
    		}
    	}
    	return min-1;
    }
    public static boolean exist(int m) {

    	int c=1;
    	int before=0;
    	int id=1;
    	while(id<K&&c<M) {
			if(Math.abs(judge[id]-judge[before])>=m) {
				before=id;
				c++;
			}
			id++;
			
		}

    	if(c==M)return true;
    	else return false;
    }
}