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
     	long A=Long.parseLong(st.nextToken());
     	long B=Long.parseLong(st.nextToken());
     	
     	long CA=check(A-1);
     	long CB=check(B);

     	System.out.println(CB-CA);
     	
     	
    }
    
  public static long check(long A) {
	  long cnt=0;
	  long a=A;	//10																								//
	  for(int i=0;i<=50;i++) {
		  long Pow=1L<<i;
		  if(a%2==0)
		  cnt+=(a/2)*Pow;
		  else cnt+=((a/2)+1)*Pow;
		  a/=2;
		  if(a==0)break;
	  }
	  return cnt;
  }
  
}