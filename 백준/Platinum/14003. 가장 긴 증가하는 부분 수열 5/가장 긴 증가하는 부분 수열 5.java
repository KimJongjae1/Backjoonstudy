import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[] arr;
     static List<int[]> list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static long ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static Queue<int[]> hu;
    static Queue<int[]> fire;
    static boolean flag;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
      
        List<Integer> temp=new ArrayList<>();
        int[] INDEX=new int[N];

        for(int i=0;i<N;i++) {
        	int id=lowerbound(arr[i],temp);
        	
        	if(id==temp.size()) temp.add(arr[i]);
        	else temp.set(id, arr[i]);
        	INDEX[i]=id;
        	
        }
        System.out.println(temp.size());
        idx=temp.size()-1;
        for(int i=N-1;i>=0;i--) {
        	if(INDEX[i]==idx) {
        		temp.set(idx, arr[i]);
        		idx--;
        	}
        }
        for(int i=0;i<temp.size();i++) {
        	sb.append(temp.get(i)+" ");
        }
        System.out.println(sb);
    }
    public static int lowerbound(int t,List<Integer> temp) {
    	int max=temp.size();
    	int min=0;
    	while(min<max) {
    		int mid=(max+min)/2;
    		
    		if(temp.get(mid)<t) {
    			min=mid+1;	
    		}else {
    			max=mid;
    		}
    	}
    	return min;
    }
}