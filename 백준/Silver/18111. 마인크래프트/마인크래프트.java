import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int[] land = new int[N*M];
    int sum=0;
    for(int i=0;i<N;i++) {
    	st =new StringTokenizer(br.readLine());
    	for(int k=0;k<M;k++) {
    		int temp=Integer.parseInt(st.nextToken());
    		land[k+M*i]=temp;
    		sum+=land[k+M*i];
    		
    	}
    }

    Arrays.sort(land);
	
    sum/=(N*M);
   
    int ans=1000000000;
    int ans2=0;
    while(sum<=land[N*M-1]) {
    	    int dig =0;
    	    int digcount=0;
    	    int invengive=0;
    	    int givecount=0;
    for(int i=0;i<N*M;i++) {
    	if(sum==land[i]) {
    		continue;
    	}else if(land[i]-sum>0){
    		     dig+=land[i]-sum;
    		     digcount+=land[i]-sum;
    	}else {
    		 invengive+=sum-land[i];
    		 givecount+=sum-land[i];
    	}
    }
    if(digcount+B>=givecount&&ans>=dig*2+invengive) {
    	ans=dig*2+invengive;
    	ans2=sum;
    }
    sum++;
    }
    
 System.out.println(ans+" "+ans2);
  
   
   } 
}