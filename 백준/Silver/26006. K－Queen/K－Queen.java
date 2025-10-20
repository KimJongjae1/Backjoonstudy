import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static int[] diy= {0,-1,1,-1,1,1,-1,0,0};
   static int[] dix= {0,1,-1,-1,1,0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	N=Integer.parseInt(st.nextToken());
     	int K=Integer.parseInt(st.nextToken());
     	
     	st=new StringTokenizer(br.readLine());
     	int R=Integer.parseInt(st.nextToken());
     	int C=Integer.parseInt(st.nextToken());
     	
     	List<int[]> list=new ArrayList<>();

     	for(int i=0;i<K;i++) {
     	  	st=new StringTokenizer(br.readLine());
     		int a=Integer.parseInt(st.nextToken());
   			int b=Integer.parseInt(st.nextToken());
     		
     		list.add(new int[] {a,b});
     	}

     		int cnt=0;
     		boolean check=false;
     		Loop:for(int i=0;i<9;i++) {
     			for(int[] k:list) {

     				int Y=R+diy[i];
     				int X=C+dix[i];
     				if(Y<1||Y>N||X<1||X>N) {
     					cnt++;
     					continue Loop;
     				}
     				Y-=k[0];
     				X-=k[1];
     				if(Y==0||X==0) {
     					if(i==0) check=true;
     					else cnt++;
     					continue Loop;
     				}else if(Math.abs(Y)==Math.abs(X)) {
     					if(i==0) check=true;
     					else cnt++;
     					continue Loop;
     				}
     				
     			}
     			if(i>0)break;
     		}
     	
     		if(cnt==8&&check) {
     			System.out.println("CHECKMATE");
     		}else if(cnt==8&&!check) {
     			System.out.println("STALEMATE");
     		}else if(cnt<8&&check) {
     			System.out.println("CHECK");
     		}else {
     			System.out.println("NONE");
     		}
     	
     	
    }
    
}