import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main { 
    static int N;
    static int M;
    static StringBuilder sb;
   
    public static void main(String[] args) throws Exception {
    	 sb=new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        String[] arr=new String[101];
        int[] dp= {0,0,1,7,4,2,0,8};
         arr[2]="1";
         arr[3]="7";
         arr[4]="11";
         arr[5]="71";
         arr[6]="111";
        arr[7]="711";
        arr[8]="1111";
        long[] min=new long[101];
        Arrays.fill(min,Long.MAX_VALUE);
        min[2]=1; min[3]=7; min[4]=4;
        min[5]=2; min[6]=6; min[7]=8;
        min[8]=10;
     
        for(int i=9;i<=100;i++) {
      	
        	if(i%2!=0) {
        		arr[i]="7"+arr[i-3];
        	}else {
        		arr[i]=arr[i-2]+"1";
        	}
    
        	
        	for(int k=2;k<=7;k++) {
        		min[i]=Math.min(Long.parseLong(String.valueOf(min[i-k])+String.valueOf(dp[k])), min[i]);
        	}
      
        	
        	
        	
        	
        }
        
        for(int t=0;t<T;t++) {
	        StringTokenizer st=new StringTokenizer(br.readLine()) ;
	        
	        N=Integer.parseInt(st.nextToken());
	        //1 2 3 4 5 6 7 8 9 0
	        //2 5 5 4 5 6 3 7 6 6
	        sb.append(min[N]+" "+arr[N]).append("\n");
	        
        
        
        }
        System.out.println(sb);
    }
  }
 