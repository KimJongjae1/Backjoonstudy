import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static int idx;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


	        sb=new StringBuilder();
	     	N=Integer.parseInt(st.nextToken());
	     	M=Integer.parseInt(st.nextToken());
	     	arr=new int[N];
	
	     	st=new StringTokenizer(br.readLine());
	     	List<Integer> list =new ArrayList<>();
	     	Set<Integer> set=new HashSet<>();
	     	for(int i=0;i<N;i++) {
	     		arr[i]=Integer.parseInt(st.nextToken());
	     		if(!set.contains(arr[i])) set.add(arr[i]);
	     		else {
	     			list.add(arr[i]);
	     		}
	     		
	     	}
	     	Loop:for(int i=1;i<=N;i++) {
	     		
	     		if(set.contains(i))continue;
	     		else {
	     			for(int k=0;k<list.size();k++) {
	     				if(list.get(k)>i)continue;
	     				else if((i-list.get(k))%M==0){
	     					list.remove(k);
	     					continue Loop;
	     				}
	     			}
	     			System.out.println(0);
	     			return;
	     		}
	     		
	     	}
	     	System.out.println(1);
    }
 
}