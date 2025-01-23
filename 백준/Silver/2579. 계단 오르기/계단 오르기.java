import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N=Integer.parseInt(br.readLine());
    
    int[] stair = new int[N+1]; 
   
    for(int i=1;i<=N;i++) {//목표인 N--N-1의 최대 N-2최대 
    	stair[i]=Integer.parseInt(br.readLine());
    }

   
    
    int[] score=new int[N+1];
    score[0]=0;
    score[1]=stair[1];
    if(N>=2)
    score[2]=stair[1]+stair[2];
    
    
    for(int i=3;i<=N;i++) {//N-3--N-1-N    N-2-N
    	score[i]=Math.max(score[i-3]+stair[i-1],score[i-2])+stair[i];
    }
    System.out.println(score[N]);
    
  }  
}
