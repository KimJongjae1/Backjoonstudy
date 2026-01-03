import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int H;
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
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	int s=Integer.parseInt(st.nextToken());
        	int e=Integer.parseInt(st.nextToken());
        	list.add(new int[] {s,e});
        }
        Collections.sort(list,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a,int[] b) {
        		if(a[0]!=b[0])return a[0]-b[0];
        		else return b[1]-a[1];
        	}
        });
        int[] diary=new int[367];
        for(int i=0;i<N;i++) {
        	int[] work=list.get(i);

        	for(int k=work[0];k<=work[1];k++) {
        		diary[k]++;
        	}
        	
        }
        int R=0;
        int L=0;
        for(int i=1;i<=366;i++) {
        	if(diary[i]>0) {
        		L=Math.max(L, diary[i]);
        		R++;
        	}else {
        		ans+=L*R;
        		R=0;
        		L=0;
        	}
        }
        System.out.println(ans);
        
    }
}