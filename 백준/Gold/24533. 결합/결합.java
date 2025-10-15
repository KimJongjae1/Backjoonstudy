import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static long[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();;
     	N=Integer.parseInt(st.nextToken());//나무 수
     	
	 	st=new StringTokenizer(br.readLine());
	 	long y=Integer.parseInt(st.nextToken());
	 	long x=Integer.parseInt(st.nextToken());
	 	long ans=0;
     	for(int i=2;i<=N;i++) { 
     	 	st=new StringTokenizer(br.readLine());
     		int Y=Integer.parseInt(st.nextToken());
     		int X=Integer.parseInt(st.nextToken());
     		ans+=y*X+x*Y;
     		y+=Y;
     		x+=X;
     	}
 
     	System.out.println(ans);
    }
}