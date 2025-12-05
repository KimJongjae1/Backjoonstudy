import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int ans;
   static int[] diy= {0,1,1,1,0,0,0,-1,-1,-1};
   static int[] dix= {0,-1,0,1,-1,0,1,-1,0,1};
   static boolean[] check;
  static List<int[]> list;
   static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        list=new ArrayList<>();
       arr=new int[N][N];
       for(int i=0;i<N;i++) {
    	   Arrays.fill(arr[i],1);
       }
        
       for(int i=0;i<M;i++) {
    	   st=new StringTokenizer(br.readLine());
    	   int one=Integer.parseInt(st.nextToken());
    	   int two=Integer.parseInt(st.nextToken());
    	   int three=Integer.parseInt(st.nextToken());
    	   list.add(new int[] {one,two,three});
       }
        Start();
        for(int i=0;i<N;i++) {
        	for(int k=0;k<N;k++) {
        		sb.append(arr[i][k]+" ");
        	}sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void Start() {
    	int len=list.size();
    	int[] LazyGrow=new int[N];
    	for(int i=0;i<len;i++) {
    		int[] grow=list.get(i);
    		int zero=grow[0];
    		int one=grow[1];
    		int two=grow[2];
    		for(int k=N-1;k>=0;k--) {
    			if(zero>0) {
    				zero--;
    			}else if(one>0){
    				arr[k][0]+=1;
    				one--;
    			}else {
    				arr[k][0]+=2;
    				two--;
    			}
    		}
    		
    		for(int k=1;k<N;k++) {
    			if(zero>0) {
    				zero--;
    			}else if(one>0){
    				LazyGrow[k]+=1;
    				arr[0][k]+=1;
    				one--;
    			}else {
    				LazyGrow[k]+=2;
    				arr[0][k]+=2;
    				two--;
    			}
    		}
    		
    	}
    	Lazy(LazyGrow);
    	
    }
    public static void Lazy(int[] LazyGrow) {
    	for(int i=1;i<N;i++) {
    		for(int k=1;k<N;k++) {
    			arr[k][i]+=LazyGrow[i];
    		}
    	}
    }
}