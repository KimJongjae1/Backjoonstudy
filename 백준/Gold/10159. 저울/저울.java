import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static long ans;
	static int idx;
	static boolean[] visit;
	static int[] diy= {-1,0,1,0};
	static int[] dix= {0,-1,0,1};
	static StringBuilder sb;
	static BufferedReader br;	
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());	
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(br.readLine());
        
     int[][] big=new int[N+1][N+1];
     int[][] small=new int[N+1][N+1];
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());	
        	int Big=Integer.parseInt(st.nextToken());
        	int Small=Integer.parseInt(st.nextToken());
        	
        	big[Big][Small]=1;
        	small[Small][Big]=1;
        }
//        
//        for(int i=1;i<=N;i++) {
//        	for(int k=1;k<=N;k++) {
//        		System.out.print(big[i][k]+" ");
//        	}
//        	System.out.println();
//        }
//        System.out.println();
        
        
        
        for(int i=1;i<=N;i++) {
        	for(int k=1;k<=N;k++) {
        		for(int q=1;q<=N;q++) {
        			if(big[k][i]==big[i][q]&&big[k][i]==1) {
        				big[k][q]=1;
        			}
        			if(small[k][i]==small[i][q]&&small[k][i]==1) {
        				small[k][q]=1;
        			}
        		}
        	}
        }
        
        for(int i=1;i<=N;i++) {
        	int cnt=0;
        	for(int k=1;k<=N;k++) {
        		if(big[i][k]==1)cnt++;
        		if(small[i][k]==1)cnt++;
        	}
   
        	sb.append((N-cnt-1)+"\n");
        }
        System.out.println(sb);
        
    }
}