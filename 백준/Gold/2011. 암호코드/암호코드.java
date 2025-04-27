import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args)throws IOException {
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   
	   String str=br.readLine();
	   
	   int size=str.length();
	   int[] dp=new int[size+1];
	   dp[0]=1;
	   for(int i=1;i<=size;i++) {
		   int now =str.charAt(i-1)-'0';
		   if(now>=1&&now<=9) {
			   dp[i]+=dp[i-1];
			   dp[i]%=1000000;
		   }
		   
		   if(i==1) continue;
		   
		   int prev=str.charAt(i-2)-'0';
		   if(prev==0) continue;
		   
		   int sum=prev*10+now;
		   if(sum<=26&&sum>=10) {
			   dp[i]+=dp[i-2];
			   dp[i]%=1000000;
		   }
		   
	   }
	   System.out.println(dp[size]);
   }
}
