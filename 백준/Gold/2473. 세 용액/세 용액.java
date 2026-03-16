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
    static int[] ans;
    static long min;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
        sb=new StringBuilder();
        ans=new int[3];
        StringTokenizer st=new StringTokenizer(br.readLine());
		 N=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        list=new ArrayList<>();
        
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(st.nextToken()));
            
        }
        min=Long.MAX_VALUE;
           Collections.sort(list);
            for(int i=0;i<N-2;i++){
                long a=list.get(i);
                    int left=i+1;
                    int right=N-1;
                    while(left<right){
                        long m=a+list.get(left)+list.get(right);

                        if(Math.abs(m)<min){
                            min=Math.abs(m);
                            ans[0]=(int)a;
                            ans[1]=list.get(left);
                            ans[2]=list.get(right);
                        }

                        if(m<0){
                            left++;
                        }else if(m>0){
                            right--;
                        }else {
                            System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
                            return;
                        }
                    }
                
            }

        Arrays.sort(ans);
        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
    }
 
}