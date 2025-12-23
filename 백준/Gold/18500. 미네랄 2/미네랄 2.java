import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
   static char[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {0,-1,0,1};
   static int[] dix= {-1,0,1,0};
   static boolean[][] visit;
   static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
      
        arr=new char[N][M];
        for(int i=0;i<N;i++) {
        	String str=br.readLine();
        	for(int k=0;k<M;k++) {
        		arr[i][k]=str.charAt(k);
        	}
        }
        
        K=Integer.parseInt(br.readLine());

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++) {
        	int n=Integer.parseInt(st.nextToken());
        	int level=N-n;
        	//print();
        	game(level);

        }
  	  for(int j=0;j<N;j++) {
      	for(int k=0;k<M;k++) {
      		sb.append(arr[j][k]);
      	}sb.append("\n");
      }
  	System.out.println(sb);
    }
    public static void print() {
  	  for(int j=0;j<N;j++) {
        	for(int k=0;k<M;k++) {
        		sb.append(arr[j][k]);
        	}sb.append("\n");
        }
    	System.out.println(sb);
    	sb=new StringBuilder();
    	System.out.println(idx);
    }
    
    public static void game(int level) {
    	
    	if(idx%2==0) {
    		for(int i=0;i<M;i++) {
    			if(arr[level][i]=='x') {
    				arr[level][i]='.';
    				check(level,i);
    				break;
    			}
    		}
    	}else {
    		for(int i=M-1;i>=0;i--) {
    			if(arr[level][i]=='x') {
    				arr[level][i]='.';
    				check(level,i);
    		
    				break;
    			}
    		}
    	}
    
    	idx++;
    	//print();
    }
    public static void check(int level,int x) {
    	List<List<int[]>> L=new ArrayList<>();

    	boolean[][] v=new boolean[N][M];
    	for(int i=0;i<4;i++) {
    	
    		int Y=level+diy[i];
    		int X=x+dix[i];
    		if(Y<0||Y>=N||X<0||X>=M||arr[Y][X]=='.'||v[Y][X]) {
    			continue;
    		}
    		List<int[]> l=new ArrayList<>();

    		BFS(l,Y,X,v);
    		L.add(l);
    	
    	}
    	goDown(L);
    	//print();
    }
    
    public static void BFS(List<int[]> l,int Y,int X,boolean[][] v) {
    	Queue<int[]> qu=new LinkedList<>();
    	qu.offer(new int[] {Y,X});
    	l.add(new int[] {Y,X});
    	arr[Y][X]='.';
    	v[Y][X]=true;
    	while(!qu.isEmpty()) {
    		int[] cur=qu.poll();
    		
    		for(int i=0;i<4;i++) {
    			int Y1=cur[0]+diy[i];
    			int X1=cur[1]+dix[i];
    	
    			if(Y1<0||Y1>=N||X1<0||X1>=M)continue;
    			if(arr[Y1][X1]=='.')continue;
 
    			l.add(new int[] {Y1,X1});
    			arr[Y1][X1]='.';
    		//	System.out.println(Y1+" "+X1+"BFS ");
    			v[Y1][X1]=true;
    			qu.offer(new int[] {Y1,X1});	
    		}	
    	}
    	
    }
    
    public static void goDown(List<List<int[]>> L) {
	   int size=L.size();
	  // System.out.println(size+" "+2222);
	   boolean[] done=new boolean[size];
    	int level=1;

	Loop: while(true) {
		   
		   for(int i=0;i<size;i++) {
			   if(done[i])continue;
			   for(int[] loca:L.get(i)) {
				   int Y=loca[0]+level;
				   int X=loca[1];
				 //  System.out.println(Y+" "+X+" "+"232323"+" "+L.get(i).size());  
				   if(Y<0||Y>=N||X<0||X>=M||arr[Y][X]=='x') {
					   done[i]=true;
					   
					   for(int[] l:L.get(i)) {
						   int y=l[0]+level-1;
						   int x=l[1];
						   //System.out.println(y+" "+x+" "+level+" "+L.get(i).size());
						   arr[y][x]='x';
					   }	
					   continue Loop;
				   }
				   
			   }
			  
		   }
		   level++;
		   int cnt=0;
		   for(int i=0;i<size;i++) {
			   if(!done[i])break;
			   cnt++;
		   }
		   if(cnt==size)break;
	   }

    }
    
    
    
}