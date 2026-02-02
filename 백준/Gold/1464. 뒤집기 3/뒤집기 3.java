import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
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
   static int max;
   static  StringBuilder sb;
   static int[][] arr;
   static int[][] dp;
   static int cnt;
   static long ans;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[] visit;
   static List<Integer> list;
   static TreeSet<Integer> set;  
   static TreeMap<Integer,Integer> map;
   static int first;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
     	
	   //StringTokenizer st=new StringTokenizer(br.readLine());
	    //N=Integer.parseInt(st.nextToken());
	   
        
        String str=br.readLine();
        Deque<Character> dq=new LinkedList<>();
        dq.add(str.charAt(0));
        
        for(int i=1;i<str.length();i++){
        	if(dq.peek()<str.charAt(i)) {
        		dq.offerLast(str.charAt(i));
        	}else dq.offerFirst(str.charAt(i));
        }
        
        while(!dq.isEmpty()) {
        	sb.append(dq.pollFirst());
        }
        System.out.println(sb);
	   
    }
}