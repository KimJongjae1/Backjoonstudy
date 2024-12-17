import java.util.Arrays;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    int A=scan.nextInt();
    int B=scan.nextInt();
    int V=scan.nextInt();
    int ans=0;
    
    if(A==V) {ans=1;} // 3 1 5    2/2=1
    
    else if((V-A)/(A-B)>=1&&(V-A)%(A-B)>0) {//5 1 10 
       ans = (V-A)/(A-B)+2;//3/1=3 
    }else if((V-A)/(A-B)>=1&&(V-A)%(A-B)==0){
    	ans = (V-A)/(A-B)+1;
    }else {ans= 2;}
    
    System.out.println(ans);
    
	}
}