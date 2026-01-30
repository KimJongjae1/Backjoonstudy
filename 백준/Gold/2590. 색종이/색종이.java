import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int T;
   static int idx;
   static long max;
   static  StringBuilder sb;
   static int[] arr;
   static int[] dp;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<int[]>[] list;
   static TreeSet<Integer> set;  
   static Map<Integer,Integer>[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	
	   // StringTokenizer st=new StringTokenizer(br.readLine());
	    //N=Integer.parseInt(st.nextToken());
			
		arr=new int[7];
		for(int i=1;i<=6;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		ans+=arr[6];
	
		five();
		//System.out.println(ans);
		four();
		//System.out.println(ans);
		three();
		//System.out.println(ans);
		two();
		//System.out.println(ans);
		one();
		System.out.println(ans);
			
    }
    
    public static void five() {
    	if(arr[5]<=0)return;
    	
    	ans+=arr[5];
    	arr[1]-=arr[5]*11;
    }
    public static void four() {
    	if(arr[4]<=0)return;
    	
    	ans+=arr[4];
    	if(arr[2]>=arr[4]*5) {
    		arr[2]-=arr[4]*5;
    	}else {
    		
    		int left=(arr[4]*5-arr[2])*4;
    		arr[2]=0;
    		if(arr[1]<=0)return;
    		arr[1]-=left;
    		
    	}
    	
    }
    public static void three() {
    	if(arr[3]<=0)return;
    	ans+=arr[3]/4;
    	int left=arr[3]%4;
    	if(left>0)ans++;
    	else return;
    	
    	int L=27;
    	if(left==1) {
    		
    		if(arr[2]>=5) {
    			arr[2]-=5;
    			L=7;
    		}
    		else if(arr[2]<5) {
    			L-=arr[2]*4;
    			arr[2]=0;
    		}
    	}
    	else if(left==2) {
    		L=18;
    		if(arr[2]>=3) {
    			arr[2]-=3;
    			L=6;
    		}
    		else if(arr[2]<3) {
    			L-=arr[2]*4;
    			arr[2]=0;
    		}
    	}
    	else if(left==3) {
    		L=9;
    		if(arr[2]>=1) {
    			arr[2]-=1;
    			L=5;
    		}
    	}
    	
    	arr[1]-=L;
    	
    }
    public static void two() {
    	if(arr[2]<=0)return;
    	
    	ans+=arr[2]/9;
    	int left=arr[2]%9;
    	if(left>0)ans++;
    	else return;
    	
    	arr[1]-=(36-left*4);
    	
    }
    public static void one() {
    	if(arr[1]<=0)return;
    	
    	ans+=arr[1]/36;
    	if(arr[1]%36>0)ans++;
    
    }
    
}