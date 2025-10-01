import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static int[] lis;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	N=Integer.parseInt(st.nextToken());
     	
     	arr=new int[N+2];
     	st=new StringTokenizer(br.readLine());
     	for(int i=1;i<=N;i++) {
     		arr[i]=Integer.parseInt(st.nextToken());
     	}
     	arr[N+1]=2000000000;
     	arr[0]=-2000000000;
     	int breakPlace=0;
     	int ans=0;
     	for(int i=1;i<=N-1;i++) {
     		if(arr[i]>arr[i+1]) {	
     			if(breakPlace==0) {
     				if(arr[i]<=arr[i+2]) {
         				ans=1;
     					if(arr[i+1]>=arr[i-1])
     						ans++;
     				}else {
     					if(arr[i+1]>=arr[i-1])
     						ans++;
     				}
     			}else {
     				System.out.println(0);
     				return;
     			}
     			breakPlace++;
     		}
     	}
     	if(breakPlace>0) System.out.println(ans);
     	else System.out.println(N);
    }
 
}