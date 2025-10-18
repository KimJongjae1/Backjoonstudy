import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
        N=Integer.parseInt(st.nextToken());
        List<Integer> list=new ArrayList<>();
        arr=new int[N];
        int[] type=new int[N];
        for(int i=0;i<N;i++){
          st=new StringTokenizer(br.readLine());

            char a=st.nextToken().charAt(0);
            int n=Integer.parseInt(st.nextToken());
            if(a=='G') type[i]=1;
            else type[i]=-1;
            arr[i]=n;	
            list.add(n);	
        }
        
        int ans=Integer.MAX_VALUE;
        for(int n:list) {
        	int cnt=0;
        	for(int i=0;i<N;i++) {
        		if(type[i]==1) {
        			if(n<arr[i]) cnt++;
        		}else {
        			if(n>arr[i])cnt++;
        		}
        	}
        	ans=Math.min(ans, cnt);
        	
        }
        System.out.println(ans);
    }
}