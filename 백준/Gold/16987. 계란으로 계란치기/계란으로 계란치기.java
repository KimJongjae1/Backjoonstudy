import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
   static char[][] arr;
   static int[] dp;
   static long[] sum;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[] visit;
   static List<Integer> list;
   static Set<int[]> set;  
   static Queue<int[]> qu;
   static int[] prv;
   static class Egg{
	   int id;
	   int D;
	   int A;
	   Egg(int id,int D,int A){
		   this.id=id;
		   this.D=D;
		   this.A=A;
		   
	   }
   }
   static Egg[] Eggs;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

	       StringTokenizer st=new StringTokenizer(br.readLine());
	       N=Integer.parseInt(st.nextToken());
	       Eggs=new Egg[N];
	        for(int i=0;i<N;i++) {
	        	 st=new StringTokenizer(br.readLine());
	        	int Defence=Integer.parseInt(st.nextToken());
	        	int Attack=Integer.parseInt(st.nextToken());
	        	Eggs[i]=new Egg(i,Defence,Attack);
	        }
	       BACK(0);
	       System.out.println(ans);
    }
    public static void BACK(int cur) {
    	if(cur==N) {
    		int cnt=0;
    		for(int i=0;i<N;i++) {
    			if(Eggs[i].D<=0)cnt++;
    		}
    		ans=Math.max(ans, cnt);
    		return;
    	}
    	
    	if(Eggs[cur].D<=0) {
    		BACK(cur+1);
    		return;
    	}
    	int cnt=0;
    	for(int i=0;i<N;i++) {
    		if(i==cur||Eggs[i].D<=0) {

    			continue;
    		}
    		
    		Eggs[i].D-=Eggs[cur].A;
    		Eggs[cur].D-=Eggs[i].A;
    		BACK(cur+1);
			cnt++;
    		Eggs[i].D+=Eggs[cur].A;
    		Eggs[cur].D+=Eggs[i].A;
    	}
    	if(cnt==0) {
    		BACK(cur+1);
    	}
    	
    }
}