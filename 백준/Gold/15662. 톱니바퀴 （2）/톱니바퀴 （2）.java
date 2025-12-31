import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


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
   static List<Integer>[] list;
   static Set<int[]> set;
   static Deque<Integer>[] dq;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
       
        list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	String str=br.readLine();
        	list[i]=new ArrayList<>();
        	for(int k=0;k<8;k++) {
        		list[i].add(str.charAt(k)-'0');
        	}
        }
        M=Integer.parseInt(br.readLine());
        set=new HashSet<>();
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	int n=Integer.parseInt(st.nextToken());
        	int dir=Integer.parseInt(st.nextToken());
        	set.clear();
        	set.add(new int[] {n,dir});
        	DFS(n,n+1,dir,list[n].get(2));
        	DFS(n,n-1,dir,list[n].get(6));
        	for(int[] cur:set) {
        		Lotate(cur);
        	}
        }
        
        for(int i=1;i<=N;i++) {
        	if(list[i].get(0)==1)ans++;
        }
        System.out.println(ans);
        
    }
    public static void DFS(int startN,int n,int dir,int status) {
    	if(n>N||n<1)return;
    	int curStatus,NextStatus;
    	int Nextn;
    	if(startN<n) {
    		 curStatus=list[n].get(6);
    		if(curStatus==status)return;
    		NextStatus=list[n].get(2);
    		Nextn=n+1;
    	}else {
    		curStatus=list[n].get(2);
    		if(curStatus==status)return;
    		NextStatus=list[n].get(6);
    		Nextn=n-1;
    	}
    	int NextDir;
    	if(dir==-1) NextDir=1;
    	else NextDir=-1;
    	
    	set.add(new int[] {n,NextDir});
    	
    	DFS(startN,Nextn,NextDir,NextStatus);
    	
    	
    }
    public static void Lotate(int[] cur) {
    	
    	if(cur[1]==1) {
    		int temp=list[cur[0]].get(7);
    		list[cur[0]].remove(7);
    		list[cur[0]].add(0,temp);
    	
    	}else {
    		int temp=list[cur[0]].get(0);
    		list[cur[0]].remove(0);
    		list[cur[0]].add(temp);
    	}
    	
    }
}