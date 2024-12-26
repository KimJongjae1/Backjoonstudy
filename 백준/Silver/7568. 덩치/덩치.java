import java.util.*;
import java.io.*;
public class Main {
	

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    
    int N = scan.nextInt();
    int[][] a = new int[N][2];
    
	for(int i=0;i<N;i++) {
		for(int k=0;k<2;k++) {
			a[i][k]=scan.nextInt();
		}
	}
	int[] cnt = new int[N];
	Arrays.fill(cnt,1);
	
	for(int i=0;i<N;i++) {
		for(int k=0;k<N;k++) {
			if(a[i][0]<a[k][0]&&a[i][1]<a[k][1])
				cnt[i]++;
		}
	}

	for(int i=0; i<N;i++) {
		System.out.print(cnt[i]+" ");
	}
	
   }
}