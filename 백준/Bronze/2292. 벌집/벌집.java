import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {//1 6 7 12 19 18  37
	Scanner scan = new Scanner(System.in);
	
	int N =scan.nextInt();
	int ans=0;
	for(int i=1;;i++) {
		int temp=1+(i*(i-1))*3;//1 7
		int temp2=1+(i*(i+1))*3;//7 19
		
		if(N==1) {
			System.out.println("1");
			break;
		}else if(N>temp&&N<=temp2) {
			ans=i+1;
			System.out.println(ans);//ans를 왜 아래에 두냐..굳이..break가 있는데
			break;
		}
	}
		
	}
}