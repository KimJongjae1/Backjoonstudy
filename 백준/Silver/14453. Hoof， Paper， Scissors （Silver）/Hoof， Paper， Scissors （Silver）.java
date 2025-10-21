import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	N=Integer.parseInt(st.nextToken());
     	arr=new int[N][3];

     	char[] a=new char[N];
     	int P=0;int H=0; int S=0;

     	for(int i=0;i<N;i++) {
     		a[i]=br.readLine().charAt(0);
     		if(a[i]=='P') {
     			P++;
     		}else if(a[i]=='H') {
     			H++;
     		}else {
     			S++;
     		}
     		
     		arr[i][0]=P;
     		arr[i][1]=H;
     		arr[i][2]=S;
     		
     	}
   
     	int ans=0;
     	for(int i=0;i<N;i++) {
     		
     		ans=Math.max(ans,Math.max(arr[i][0]+arr[N-1][1]-arr[i][1], arr[i][0]+arr[N-1][2]-arr[i][2]));
     		ans=Math.max(ans,Math.max(arr[i][1]+arr[N-1][0]-arr[i][0], arr[i][1]+arr[N-1][2]-arr[i][2]));
     		ans=Math.max(ans,Math.max(arr[i][2]+arr[N-1][1]-arr[i][1], arr[i][2]+arr[N-1][0]-arr[i][0]));
     		
     	}
     	System.out.println(ans);
    }
    
}