import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static long[] arr;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		   StringBuilder sb=new StringBuilder();
		   String str;
		   
		   while((str = br.readLine()) != null && !str.equals("")){
			   int x =Integer.parseInt(str);//센티미터 1cm ==10000000
			  
			   N=Integer.parseInt(br.readLine());
			   
			   int[] arr=new int[N];
			    
			   for(int i=0;i<N;i++) {
				   arr[i]=Integer.parseInt(br.readLine());
			   }
			   if(N==0||N==1) {
				   System.out.println("danger");
				   continue;
			   }
			    
			   Arrays.sort(arr);
			   int idx=0;
			   int num=0;;
			   for(int i=0;i<N;i++) {
				   num=binary(arr,i,x*10000000);
				   if(num!=-1) {
					   idx=i;
					   break;
				   }
				  
			   }
			   
			   if(num==-1) System.out.println("danger");
			   else System.out.println("yes"+" "+arr[idx]+" "+arr[num]);
		   }  
		    
   }
	 public static int binary(int[] arr,int m,int x) {
		 int max=arr.length-1;
		 int min =m+1;
		 int len=x-arr[m];
		 
		 while(min<=max) {
			 int mid=(max+min)/2;
			 
			 if(arr[mid]<len) {
				 min=mid+1;
			 }else if(arr[mid]>len){
				 max=mid-1;
			 }else {
				 return mid;
			 }
			 
		 }
		 return -1;
	 }
	 
}