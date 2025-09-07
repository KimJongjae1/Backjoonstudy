import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
	static int N;
	static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
      int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        
       int n=N/2;
       int m=M;
       int team=0;
       if(n>m) team=m;
       else team=n;
       
       int leftover=0;
       leftover+=N-team*3+M;
       
       if(leftover<K) {
    	   K-=leftover;
    	   int k=K/3;
    	   if(K%3>0)k++;
    	   team-=k;
       }
       System.out.println(team);
    }
}