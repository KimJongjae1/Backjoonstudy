import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int[] arr = new int[21];
    int[] full = new int[21];
    arr[0]=-1;
   for(int i=1;i<=20;i++) {
	   full[i]=1;
   }
    int M=Integer.parseInt(br.readLine());
    
   
    for(int i=0;i<M;i++) {
    	 int temp=0;
    	String str = br.readLine();
    	
    	if(str.charAt(1)!='l'&&str.charAt(0)!='e') {
    	StringTokenizer st =new StringTokenizer(str);	
    	str = st.nextToken();
    	temp = Integer.parseInt(st.nextToken());
    	}
 	    
    	if(str.equals("add")&&arr[temp]==0) {
    		arr[temp]++;
    	}
    	else if(str.equals("remove")&&arr[temp]==1) {
    		arr[temp]=0;
    	}
    	else if(str.equals("check")) {
    		if(arr[temp]==1)
    		sb.append(1).append("\n");
    		else {
        	sb.append(0).append("\n");}
    	}
    	else if(str.equals("toggle")) {
    		if(arr[temp]==1)
    			arr[temp]=0;
        		else {
        			arr[temp]=1;}
    	}
    	else if(str.equals("all")) {
    	arr=Arrays.copyOf(full,full.length);
    	
    	}
    	else if(str.equals("empty")){Arrays.fill(arr,0);}
    }
    
    System.out.println(sb);
    
   }
}