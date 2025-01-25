import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T=Integer.parseInt(br.readLine());
    int[] PN =new int[T+1];//구할 N값들 0은 제외
    int max =0;
    for(int i=1;i<=T;i++) {
    	int N=Integer.parseInt(br.readLine());
    	if(max<N) {
    		max=N;//P최종 목표점 P를 여러번 정의하기 싫어서 하는 것
    	}
    	PN[i]=N;
    }

    	  BigInteger[] P = new BigInteger[max+7];//PN값을 넣어서 답이 나올 답지
    	   
          P[1]=new BigInteger("1"); P[2]=new BigInteger("1");P[3]=new BigInteger("1");
          P[4]=new BigInteger("2");P[5]=new BigInteger("2");
          P[6]=new BigInteger("3");//i-5 i-1
    for(int i=7;i<=max;i++) {
    	     P[i]=P[i-5].add(P[i-1]);
    }
    for(int i=1;i<=T;i++) {
    System.out.println(P[PN[i]]);	
    }
    
 }  
}