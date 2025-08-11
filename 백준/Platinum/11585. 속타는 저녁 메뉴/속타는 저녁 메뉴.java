import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;



public class Main { 
    static int N;
    
    public static void main(String[] args) throws Exception {
    	StringBuilder sb=new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine()) ;
       N=Integer.parseInt(st.nextToken());
        	
       String str=br.readLine();
       char[] meat=new char[N];
       int id=0;
       for(int i=0;i<str.length();i++) {
    	   if(str.charAt(i)==' ')continue;
    	   meat[id++]=str.charAt(i);
       }
       
       str=new String(meat,0,id);
       
       String str2=br.readLine();
//       for(int i=0;i<str2.length();i++) {
//    	   if(str2.charAt(i)==' ')continue;
//    	   meat[i]=str2.charAt(i);
//       }
//       str2=meat.toString();
  
       int[] table=new int[str.length()];
       int idx=0;
       for(int i=1;i<str.length();i++) {
    	   if(idx>0&&str.charAt(idx)!=str.charAt(i)) {
    		   idx=table[idx-1];
    	   }
    	   
    	   if(str.charAt(idx)==str.charAt(i)) {
    		   table[i]=++idx;
    	   }
    	   
       }
       	int len=str.length()-table[str.length()-1];
       	if(str.length()%len==0) {
       		int gc=gcd(str.length()/len,str.length());
       		sb.append(str.length()/len/gc).append("/").append(str.length()/gc).append("\n");
       	}
       	else {
       		sb.append(1).append("/").append(str.length()).append("\n");
       	}
       	System.out.println(sb);
     //  	sb.append(1).append("/").append(str.length()).append("\n");
    }
    static int gcd(int a,int b) {
    	return b==0 ? a:gcd(b,a%b);
    }
    
  }
 