import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[][] arr;
     static List<int[]> list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static long ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());
        list=new ArrayList<>();
        for(int i=0;i<N;i++){
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st2.nextToken());//계획
            list.add(new int[]{a,b});
        }

        Collections.sort(list,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[1]!=b[1])return a[1]-b[1];
                return a[0]-b[0];
            }
        });


        int planMax=0;
        long MAX=0;
        long PREMAX=0;
        ans=0;
        for(int i=0;i<list.size();i++){
            int[] cur=list.get(i);
            long n=find((long)cur[0],(long)cur[1]);
            if(planMax<cur[1]){
                planMax=cur[1];
                PREMAX=MAX;
            }
            n=find(n,PREMAX);
            MAX=Math.max(MAX,n);
            
        }
        System.out.println(ans);
    }
    public static long find(long c0,long c1){
        if(c1<=c0)return c0;
        
        long n=c1-c0;
        long a=n/30;
        if(n%30>0)a++;
        ans+=a;
        return c0+30*a;
    }
}