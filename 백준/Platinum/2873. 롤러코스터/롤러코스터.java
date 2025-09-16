import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

   static int N;
   static int M;
   static  StringBuilder sb;
   static int[][] arr;
   static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        sb=new StringBuilder();
     	N=Integer.parseInt(st.nextToken());
     	M=Integer.parseInt(st.nextToken());
     	arr=new int[N][M];

     	int min=Integer.MAX_VALUE;
     	int y=0;
     	int x=0;

     	for(int i=0;i<N;i++) {
     		st=new StringTokenizer(br.readLine());
     		for(int k=0;k<M;k++) {
     			arr[i][k]=Integer.parseInt(st.nextToken());
     			if((i+k)%2!=0) {
     				if(min>arr[i][k]) {
     					min=arr[i][k];
     					y=i;x=k;
     				}
     			}
     		}
     	}   	

    	if(N%2==1) {
    		for(int k=0;k<N/2;k++) {	
	    		for(int i=0;i<M-1;i++) sb.append('R');
	    		 sb.append('D');
	    		 for(int i=0;i<M-1;i++) sb.append('L');
	    		 sb.append('D');
    		}
    		for(int i=0;i<M-1;i++) sb.append('R');
    	}else if(M%2==1) {
    		for(int k=0;k<M/2;k++) {	
	    		for(int i=0;i<N-1;i++) sb.append('D');
	    		 sb.append('R');
	    		 for(int i=0;i<N-1;i++) sb.append('U');
	    		 sb.append('R');

    		}

    		for(int i=0;i<N-1;i++) sb.append('D');

    	}else {
    
    		go(y,x);
    	}

     	System.out.println(sb);

    }  

    public static void go(int y,int x) {

    	int Y=y/2;

    	for(int i=0;i<Y;i++) {

    		for(int k=0;k<M-1;k++) sb.append('R');
    		sb.append('D');
    		for(int k=0;k<M-1;k++) sb.append('L');
    		sb.append('D');
    	}
    	
    	int b=0;                        
    	while(true) {            
    		if(b<x) { 	
    			if(b%2==1) {
   				 sb.append('U');
   			 }else sb.append('D');   
    		}
    		else if(b>x){                  
    			 if(b%2==1) {
    				 sb.append('D');
    			 }else sb.append('U');                                                                                                                    
    		}   		                                  
    		b++;
    		if(b==M)break;
    		sb.append('R');
    		
    	
    	}
    	
    	if(Y==(N-1)/2) return;
    	sb.append('D');

    	for(int i=Y+1;i<=(N-1)/2;i++) {

    		for(int k=0;k<M-1;k++) sb.append('L');
    		sb.append('D');
    		for(int k=0;k<M-1;k++) sb.append('R');
    		if(i!=(N-1)/2)
    		sb.append('D');
    	}
    	
    }

}