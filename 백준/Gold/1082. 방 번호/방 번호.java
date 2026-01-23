import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
   static String[] dp;
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
		st=new StringTokenizer(br.readLine());
		arr=new int[N];

		ans=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());

		}
		M=Integer .parseInt(br.readLine());
		dp=new String[51];
		dp[0]="";
		for(int i=1;i<=M;i++) {
			dp[i] = compare(dp[i], dp[i-1]);
			for(int k=N-1;k>=0;k--) {
				if(arr[k]>i) continue;

				
				String temp=dp[i-arr[k]]+k;

				if(temp.length()>1&&temp.charAt(0)=='0') {
					continue;
				}

				 dp[i]=compare(dp[i],temp);
				
			}
		}

		System.out.println(dp[M]);
		
    }
    public static String compare(String a,String b) {
    	if(a==null)return b;
    	if(a.length()!=b.length())return a.length()>b.length()? a:b;
    	else return a.compareTo(b) >=0 ? a:b;
    	
    }
    
}