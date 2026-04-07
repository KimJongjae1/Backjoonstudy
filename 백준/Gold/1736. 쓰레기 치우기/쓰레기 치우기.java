import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[][] dp;
     static int[][] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
     static StringBuilder sb;
     static int ans;
    static TreeSet<Integer>[] set;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        set=new TreeSet[N+1];
      
        for(int i=1;i<=N;i++){
            set[i]=new TreeSet<>();
            st=new StringTokenizer(br.readLine());
            for(int k=1;k<=M;k++){
                int n=Integer.parseInt(st.nextToken());
                if(n==1)set[i].add(k);
            }
        }

        ans=0;
         TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i=1;i<=N;i++){
           for(int k:set[i]){
               Integer prev=tm.floorKey(k);

               if(prev==null){
                   ans++;
               }else{
                   int cnt = tm.get(prev);
                    if (cnt == 1) tm.remove(prev);
                    else tm.put(prev, cnt - 1);
                }

                tm.put(k, tm.getOrDefault(k, 0) + 1);
           }
            
            
        }
       
        System.out.println(ans);
        
    }
    
}