import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
     	int T=Integer.parseInt(st.nextToken());
     for(int t=0;t<T;t++) {
     		st=new StringTokenizer(br.readLine());
     		int a=Integer.parseInt(st.nextToken());
     		int b=Integer.parseInt(st.nextToken());
     		System.out.println("yes");
     	}
    }
  
}