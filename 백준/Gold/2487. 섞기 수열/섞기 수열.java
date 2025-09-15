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
   static int[] arr;
   static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
     	N=Integer.parseInt(st.nextToken());
     	
    	arr=new int[N+1];
    	visit=new boolean[N+1];
    	st=new StringTokenizer(br.readLine());
    	for(int i=1;i<=N;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
     	List<Integer> list=new ArrayList<>();
    	for(int i=1;i<=N;i++) {
    		if(!visit[i])
    		list.add(check(i));
    	}
     	Collections.sort(list);
     	int ans=list.get(0);
     	
     	for(int i=1;i<list.size();i++) {
     		ans=lcm(ans,list.get(i));
     	}
     	System.out.println(ans);
     	
    }
    public static int check(int a) {
    	int idx=a;
    	int cnt=0;
    	visit[idx]=true;
    	while(true) {
    		idx=arr[idx];
    		cnt++;
    		if(a==idx)break;
    		visit[idx]=true;
    	}
    	return cnt;
    }
    public static int gcd(int a,int b) {
    	while(b!=0) {
    		int temp=a%b;
    		a=b;
    		b=temp;
    	}
    	return a;
    }
    public static int lcm(int a,int b) {
    	if(a==0||b==0) return 0; 
    	return(a/gcd(a,b))*b;
    }
    
}