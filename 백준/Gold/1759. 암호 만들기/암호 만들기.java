
import java.io.*;
import java.util.*;

public class Main {
    static char[] word;
    static char[] password;
    static boolean[] visit;
    static int L;
    static int C;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        L=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        word=new char[C];
         st=new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++) {
        	word[i]=st.nextToken().charAt(0);
        }
        Arrays.sort(word);
        password=new char[L];
        visit=new boolean[C];
        sb=new StringBuilder();
        combine(0,0);
        System.out.println(sb);
    }
    public static void combine(int depth,int a) {
    	if(depth==L) {
    		check();
    	}else {
    		for(int i=a;i<C;i++) {
    			if(!visit[i]) {
    				visit[i]=true;
    				password[depth]=word[i];
    				combine(depth+1,i+1);
    				visit[i]=false;
    			}
    		}
    	}
    }
    public static void check() {
    	boolean check1=false; int check2=0;
    	
    	for(int i=0;i<L;i++) {
    		if(password[i]=='a'||password[i]=='e'||password[i]=='i'||password[i]=='o'||password[i]=='u') {
    			check1=true;
    		}else {
    			check2++;
    		}
    	}
    	if(check2>=2&&check1) {
    		for(int i=0;i<L;i++) {
    			sb.append(password[i]);
    		}sb.append("\n");
    	}
    	
    }
}