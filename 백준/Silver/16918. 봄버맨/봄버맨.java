import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static int K;
   static  StringBuilder sb;
   static char[][] arr;
   static int[][] dp;
   static int ans;
   static boolean flag;
   static int[] diy= {-1,0,1,0};
   static int[] dix= {0,1,0,-1};
   static boolean[] visit;
   static List<Integer> list;
   static int idx;
   static Set<Integer>[] set;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int T=Integer.parseInt(st.nextToken());
        
        arr=new char[N][M];
        set=new HashSet[4];
        for(int i=0;i<4;i++)set[i]=new HashSet<>();
   
        for(int i=0;i<N;i++) {
        	String str=br.readLine();
        	for(int k=0;k<M;k++) {
        		arr[i][k]=str.charAt(k);
        		if(arr[i][k]=='O') {
        			set[0].add(i*M+k);
        		}
        	}
        }
  
        BoomGame(T);
        for(int i=0;i<N;i++) {
        	for(int k=0;k<M;k++) {
        		sb.append(arr[i][k]);
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
        
    }
    public static void BoomGame(int T) {
    	idx=2;
    	boolean install=false;
    	while(idx<=T) {
    		int bombset=idx%3;
    		
    		if(!install) {
    			InstallBoom(bombset);
    			install=true;
    		}else {
    			Boom(bombset);
    			install=false;
    		}
    		idx++;
    		
    	}
    	
    	
    	
    }
    public static void InstallBoom(int bombset) {
    	
    	for(int i=0;i<N;i++) {
    		for(int k=0;k<M;k++) {
    			if(arr[i][k]=='.') {
    				arr[i][k]='O';
    				set[bombset].add(i*M+k);
    			}
    		}
    	}
 
    }
    public static void Boom(int bombset) {

    	for(int loca:set[bombset]) {
    		int y=loca/M;
    		int x=loca%M;
    		if(arr[y][x]=='.')continue;
    		arr[y][x]='.';
    	Loop:for(int i=0;i<4;i++) {
    			int Y=y+diy[i];
    			int X=x+dix[i];
    			if(Y<0||Y>=N||X<0||X>=M)continue;
    			for(int k=0;k<3;k++) {
    				if(set[k].contains(Y*M+X)) {
    					if(k==bombset)continue Loop;
    					else {
    						set[k].remove(Y*M+X);
    						break;
    					}
    				}
    			}
    			arr[Y][X]='.';
    		}
    	}
    	set[bombset].clear();
    }
}