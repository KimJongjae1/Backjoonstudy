import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    
    int N=scan.nextInt();
    int K=scan.nextInt();
    int[] boy = new int[7];
    int[] girl = new int[7];
    Arrays.fill(boy,0);
    Arrays.fill(girl,0);
    
    for(int i=0;i<N;i++) {
    	int temp=scan.nextInt();
    	int num=scan.nextInt();
    	if(temp ==1 ) {
    	   boy[num]++;
    	}else {girl[num]++;}
    }// boy[1]=2  boy[2]=1
    int ans=0;
    for(int i=1;i<=6;i++) {
    	ans +=(boy[i]/K + girl[i]/K);
    	if(boy[i]%K!=0) {
    		ans++;
    	}
    	if(girl[i]%K!=0) {
    		ans++;
    	}
    }
		
	System.out.println(ans);
   }
}