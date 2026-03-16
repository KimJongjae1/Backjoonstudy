import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
   static int N;
   static int M;
   static int H;
   static int K;
   static int G;       
   static int R;
   static int idx;
   static int idxB;
   static  StringBuilder sb;
   static int[] arr;
   static int[] dp;
   static long[]sum;
   static int cnt;
   static boolean flag;
   static int[] diy= {0,-1,1,0,0};
   static int[] dix= {0,0,0,1,-1};
   static boolean[][] visit;
   static List<Integer> list;
   static Set<Integer>[] set;  
   static Map<Integer,Integer>[] map;
    static List<Integer> acid;
    static List<Integer> basic;
    static int[] ans;
    static long min;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
        ans=new int[3];
        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
            acid=new ArrayList<>();
            basic=new ArrayList<>();
        for(int i=0;i<N;i++){
            int n=Integer.parseInt(st.nextToken());
            if(n<0)basic.add(n);
            else acid.add(n);
        }
        min=Long.MAX_VALUE;
           Collections.sort(acid);
           Collections.sort(basic);
             ONLY();
            if(basic.size()>=1) sum(acid,basic);
             if(acid.size()>=1) sum(basic,acid);
            
     
        Arrays.sort(ans);
        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
    }
    public static void sum(List<Integer> l,List<Integer> l2){
       
        for(int i=0;i<l.size();i++){
            int a=l.get(i);
            for(int k=i+1;k<l.size();k++){
                int b=l.get(k);
                long T=a+b;
                 int diff=lowerbound(l2,-T);
                 long m=Math.abs(l2.get(diff)+T);
                  if(diff>0) {
                        if(m>Math.abs(l2.get(diff-1)+T)){
                           m=Math.abs(l2.get(diff-1)+T);
                           diff--;
                        }
                    }

                if(m<min){
                    min=m;
                    ans[0]=a;
                    ans[1]=b;
                    ans[2]=l2.get(diff);
                }
               
            }
        }
        
            
      }
      
    
    public static int lowerbound(List<Integer> S,long T){
        int max=S.size()-1;
        int min=0;
        while(min<max){
            int mid=(max+min)/2;

            if(S.get(mid)>=T) max=mid;
            else min=mid+1;
            
        }
        return min;
    }
    public static void ONLY(){

       
       if(acid.size()>=3){
        
           long m=Math.abs((long)acid.get(0)+acid.get(1)+acid.get(2));
           if(m<min){
               min=m;
               ans[0]=acid.get(0);
               ans[1]=acid.get(1);
               ans[2]=acid.get(2);
           }
       }

         if(basic.size()>=3){
            int n=basic.size();
            long m=Math.abs((long)basic.get(n-1)+basic.get(n-2)+basic.get(n-3));
           if(m<min){
               min=m;          
               ans[0]=basic.get(n-1);
               ans[1]=basic.get(n-2);
               ans[2]=basic.get(n-3);
           }
       }
    }
}