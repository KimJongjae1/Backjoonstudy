import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static char[][] carr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       // StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	while(true) {
     		String str=br.readLine();
     		if(str.equals("end")) return;
     		carr=new char[3][3];
     		int X=0;
     		int O=0;
     		for(int i=0;i<str.length();i++){
     			char a=str.charAt(i);
     			carr[i/3][i%3]=a;
     					
     			if(a=='X')X++;
     			else if(a=='O')O++;
     		}
     		//System.out.println(X+" "+O);
     		int[] ans=check();
			int o=ans[0];int x=ans[1];
			//System.out.println(str+" "+o+" "+x);
     		if(X==5&&O==4) {
     			if(o==0)System.out.println("valid");
     			else System.out.println("invalid");
     		}
     		else if(X<3) {
     			System.out.println("invalid");
     		}
     		else if(X==O||X==O+1) {
     				
     				if(o>0&&x==0&&X==O)System.out.println("valid");
     				else if(o==0&&x>0&&X==O+1)System.out.println("valid");
     				else System.out.println("invalid");
     		}
     		else System.out.println("invalid");

     	}
    }
    public static int[] check() {
    	int[] ans=new int[2];
    	for(int i=0;i<3;i++) {
    		if(carr[i][0]==carr[i][1]&&carr[i][0]==carr[i][2]&&carr[i][0]!='.') {
    			if(carr[i][0]=='O')ans[0]++;
    			else ans[1]++;
    		}
    		if(carr[0][i]==carr[1][i]&&carr[0][i]==carr[2][i]&&carr[0][i]!='.') {
    			if(carr[0][i]=='O')ans[0]++;
    			else ans[1]++;
    		}
    	}
    	if(carr[0][0]==carr[1][1]&&carr[0][0]==carr[2][2]&&carr[0][0]!='.'){
			if(carr[0][0]=='O')ans[0]++;
			else ans[1]++;
		}
    	if(carr[0][2]==carr[1][1]&&carr[0][2]==carr[2][0]&&carr[0][2]!='.') {
			if(carr[0][2]=='O')ans[0]++;
			else ans[1]++;
		}
    	
    	return ans;
    	
    }
}