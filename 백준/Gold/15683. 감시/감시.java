
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
static int N;
static int M;
static int depth;
static int[][] arr;
static int[][] cctvlocation;
static int[] diy= {-1,0,1,0};
static int[] dix= {0,1,0,-1};
static int min=10000;
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		 M=Integer.parseInt(st.nextToken());
		
		//1--4가지
		//2--2가지
		//3--4가지
		//4--4가지/
		//5--0
		 arr=new int[N][M];
		 cctvlocation=new int[8][2];
		depth=0;
		for(int i=0;i<N;i++){
			st =new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
	    	    arr[i][k]=Integer.parseInt(st.nextToken());		
	    	    if(1<=arr[i][k]&&arr[i][k]<=5) {
	    	    	cctvlocation[depth][0]=i;
	    	    	cctvlocation[depth][1]=k;
	    	    	depth++;
	    	    }
	    	    	
	    	 }
		}
		
		back(0);
		System.out.println(min);
		
   }
   public static void back(int cnt) {
	   if(cnt==depth) {
		   min=Math.min(min, check());
	   }else {
	      int[] cctv=cctvlocation[cnt];
		  int status=arr[cctv[0]][cctv[1]];
		  int change=(cnt+1)*10;     
    		  if(status==1) {
    			  for(int i=0;i<4;i++) {
    				  CCTVmove(cctv,i,0,change);
    				  back(cnt+1);
    				  CCTVmove(cctv,i,1,change);
    			  }
    		  }
    		  else if(status==2) {
    			  for(int i=0;i<2;i++) {
    				CCTV2(cctv,i,0,change);
				  	back(cnt+1);
				  	CCTV2(cctv,i,1,change);
    			  }
				 
			 }
    		  else if(status==3) {
				 for(int i=0;i<4;i++) {
					 CCTV3(cctv,i,0,change);
					 back(cnt+1);
   				  	CCTV3(cctv,i,1,change);
				 } 
			 }
			 else if(status==4) {
				 for(int i=0;i<4;i++) {
					 CCTV4(cctv,i,0,change);
					 back(cnt+1);
   				  	CCTV4(cctv,i,1,change);
				 }
			 }
			 else {
				 CCTV5(cctv,0,change);
				 back(cnt+1);
				 CCTV5(cctv,1,change);
			 }
			
	   }
	   
   }
   public static void CCTVmove(int[] a,int direct, int clean,int change) {
	
	   	int Y=a[0]+diy[direct];
		int X=a[1]+dix[direct];
	    while(0<=Y&&Y<N&&0<=X&&X<M) {
	    	if(arr[Y][X]==6)break;
	    	else if(arr[Y][X]!=change&&arr[Y][X]!=0) {
	    		Y+=diy[direct];
				X+=dix[direct];
	    		continue;
	    	}
	    	
	    	if(clean==0)arr[Y][X]=change;
	    	else arr[Y][X]=0;
	    	
			 Y+=diy[direct];
			 X+=dix[direct];
		}  
   }

   	public static void CCTV2(int[] a,int direct,int clean,int change) {
         
   		CCTVmove(a, direct, clean,change);
	    direct+=2;
	    direct%=4;
	    CCTVmove(a, direct, clean,change);
   }
   
   public static void CCTV3(int[] a,int direct,int clean,int change) {

	   CCTVmove(a, direct, clean,change);
	    direct+=1;
	    direct%=4;
	    CCTVmove(a, direct, clean,change);
   }
   
   public static void CCTV4(int[] a,int direct,int clean,int change) {

	   CCTVmove(a, direct, clean,change);
	    direct+=1;
	    direct%=4;
	    CCTVmove(a, direct, clean,change);
	    direct+=1;
	    direct%=4;
	    CCTVmove(a, direct, clean,change);
   }
   public static void CCTV5(int[] a,int clean,int change) {
        for(int direct=0;direct<4;direct++) {
        	CCTVmove(a, direct, clean,change);
        } 
   }

   public static int check() {
	   int sum=0;
	   for(int i=0;i<N;i++) {
		   for(int k=0;k<M;k++) {
			
			   if(arr[i][k]==0) sum++;
		   }
	   }
	 
	   return sum;
   }
}