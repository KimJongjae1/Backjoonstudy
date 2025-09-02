import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
   static int N;
   static int M;
   static int[] arr;
   static String[] str;
   static String[] origin;
   static Map<String,Integer> map;
   static int n;
   static String maxstr;
   static class pair implements Comparable<pair>{
	   int a;
	   int b;
	   
	   pair(int a,int b){
		   if(b>a) {
			   this.a=a;
			   this.b=b;
		   }else {
			  this.a=b;
			  this.b=a;
		   }
	   }
	   
	   public int compareTo(pair P) {
		   if(P.a!=this.a) return this.a-P.a;
		   return this.b-P.b;
	   }
   }
 static   StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
     	  N=Integer.parseInt(st.nextToken());
     	  str=new String[N];
     	  for(int i=0;i<N;i++) {
     		str[i]=br.readLine(); 
     		
     	  }
     	 int max=0;
     	 pair ans=new pair(0,1);
     	 for(int i=0;i<N-1;i++) {
     		 String a=str[i];
     		 for(int k=i+1;k<N;k++) {
     			 String b=str[k];
     			 int ret=check(a,b);
     			
     			 if(ret>max) {
     				 max=ret;
     	
     				 ans=new pair(i,k);
     			 }
     			 
     		 }
     	 }
     	
     	System.out.println(str[ans.a]);
     	System.out.println(str[ans.b]);
     	  
    }
    public static int check(String a,String b) {
    	int ret=0;
    	int idx=0;
    	while(idx<a.length()&&idx<b.length()) {
    		if(a.charAt(idx)!=b.charAt(idx)) break;
    		idx++;
    		ret++;
    	}
    	return ret;
    }
  
}