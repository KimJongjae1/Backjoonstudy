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
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	N=Integer.parseInt(st.nextToken());
     	
     	if(N%2==0) {
     		System.out.println(N*N/2);
     	}else if(N==1){
    		System.out.println(0);
     	}else {
 
     		System.out.println(N*(N/2)+N/2+1);
     	}
     	
     	
     	
     	
    }
    
}