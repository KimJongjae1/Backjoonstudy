import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Main {
	

	public static void main(String[] args) throws IOException{
    BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter b = new BufferedWriter(new OutputStreamWriter(System.out));
		
	int N = Integer.parseInt(a.readLine());
	int[] arr = new int[N];
	int[] ans = new int[10001];
	
	for(int i=0;i<N;i++) {
		arr[i]=Integer.parseInt(a.readLine());
		ans[arr[i]]++;
	}
	
	for(int i=0;i<10001;i++) {
		while(ans[i]>0){
			b.write(i+"\n");
			ans[i]--;
		}
	}
	b.flush();
	b.close();
	a.close();
	
	}
}