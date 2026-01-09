import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
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
   static int[][] arr;
   static int[][] dp;
   static int sum;
   static int cnt;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1,1,1,-1,-1};
   static int[] dix= {-1,0,1,0,1,-1,1,-1};
   static boolean[][] visit;
   static List<Integer>[] list;
   static Set<Integer> set;  
   static Queue<int[]> qu;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    K=Integer.parseInt(st.nextToken());
	    idx=-1;
    	list=new ArrayList[N+1];
	    for(int i=1;i<=N;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	list[i]=new ArrayList<>();
	    	for(int k=0;k<M;k++) {
	    		list[i].add(Integer.parseInt(st.nextToken()));
	    		sum+=list[i].get(k);
	    		
	    	}
	    }
	    cnt=N*M;
	    for(int i=0;i<K;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(st.nextToken());
	    	int d=Integer.parseInt(st.nextToken());
	    	int k=Integer.parseInt(st.nextToken());
	    	if(cnt==0) continue;
	    	if(d==0)rotateClock(x,k);
	    	else rotateReverse(x,k);
	
	    	
	    	Erase();
	    	
	
	      
	    }
	    System.out.println(sum);
	
	    
    }
    public static void rotateClock(int x,int k) {
   
    	for(int i=x;i<=N;i+=x) {
    	 	List<Integer> temp=new ArrayList<>();

    		for(int q=list[i].size()-k;q<list[i].size();q++) {
    			temp.add(list[i].get(q));
    		}
    		for(int q=0;q<list[i].size()-k;q++) {
    			temp.add(list[i].get(q));
    		}
    		list[i]=temp;
    
    	}
    	
    }
  public static void rotateReverse(int x,int k) {
    	
	
    	for(int i=x;i<=N;i+=x) {
    		 List<Integer> temp=new ArrayList<>();
   
    		for(int q=k;q<list[i].size();q++) {
    			temp.add(list[i].get(q));
    		}
    		for(int q=0;q<k;q++) {
    			temp.add(list[i].get(q));
    		}
    		list[i]=temp;

    	}
    	
    }
  
  public static void Erase() {
	  set=new HashSet<>();
	  
	  for(int i=1;i<=N;i++) {
		  for(int k=0;k<M;k++) {
			  if(list[i].get(k)==null)continue;
			  for(int q=0;q<4;q++) {
				  int Y=i+diy[q];
				  int X=k+dix[q];
				  if(Y<1||Y>N)continue;
				  if(X<0)X+=M;
				  if(X>=M)X%=M;
				  if(list[Y].get(X)==null)continue;
				  if(list[i].get(k).equals(list[Y].get(X))) {
					  set.add(i*M+k);
					  set.add(Y*M+X);
				  }
				  
			  }
			  

		  }
		
	  }
	  
	  if(set.size()==0) {
		  Average();
	  }else {
		  for(int loca:set) {
			  int y=loca/M;
			  int x=loca%M;
			  sum-=list[y].get(x);
			  cnt--;
			  list[y].set(x, null);
		  }
	  }
	  
  }	  
  
  public static void Average() {
	  
	  double Sum=(double)sum/(double)cnt;

	  for(int i=1;i<=N;i++) {
		  for(int k=0;k<M;k++) {
			  if(list[i].get(k)==null)continue;
			  else {
				 int n=list[i].get(k);
				  if(n>Sum) {
					  list[i].set(k, n-1);
					  sum--;
				  }
				  else  if(n<Sum){
					  sum++;
					  list[i].set(k, n+1);
				  }
				  
			  }
			
		  }
	  }
	  
  }
}