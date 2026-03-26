import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int K;
    static int[][] dp;
     static int[] arr;
     static List<int[]> list;
     static boolean[] visit;
     static int idx;
    static int max;
     static StringBuilder sb;
     static TreeSet<int[]> set;
     static int ans;
    static boolean flag;
     static Map<Integer,TreeSet<int[]>> BCmap;
    static TreeMap<int[],TreeSet<int[]>> ADmap;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         sb=new StringBuilder();

         StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         M=Integer.parseInt(st.nextToken());
         String str=br.readLine();
        BCmap=new HashMap<>();
        ADmap=new TreeMap<>(new Comparator<int[]>(){
             @Override
                    public int compare(int[] a,int[] b){
                        if(a[0]!=b[0]) return a[0]-b[0];
                        else return a[1]-b[1];
                    }
        });
  
         st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        
        for(int i=1;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int sum=a+b;
            if(!BCmap.containsKey(sum)){
                TreeSet<int[]> temp=new TreeSet<>(new Comparator<int[]>(){
                    @Override
                    public int compare(int[] a,int[] b){
                        return a[0]-b[0];
                    }
                });
                temp.add(new int[] {a,b});
                BCmap.put(sum,temp);
            }else BCmap.get(sum).add(new int[] {a,b});
  
       
            int min=Math.min(a,b);
            int[] next=new int[]{a-min,b-min};
            if(!ADmap.containsKey(next)){
                TreeSet<int[]> temp=new TreeSet<>(new Comparator<int[]>(){
                    @Override
                    public int compare(int[] a,int[] b){
                        return a[0]-b[0];
                    }
                });
                temp.add(new int[] {a,b});
                ADmap.put(next,temp);
            }
            else ADmap.get(next).add(new int[] {a,b});

        }
       
        set=new TreeSet<>(new Comparator<int[]>(){
                    @Override
                    public int compare(int[] a,int[] b){
                        if(a[0]!=b[0]) return a[0]-b[0];
                        else return a[1]-b[1];
                    }
         });

         Loop:for(int i=0;i<M;i++){
              
            char order=str.charAt(i);
            int sum=y+x;
            TreeSet<int[]> temp;
            if(order=='A'||order=='D') {
                int min=Math.min(y,x);
                temp=ADmap.get(new int[]{x-min,y-min});
            }else{
                temp=BCmap.get(sum);
            }
              if(temp==null)continue;
            
            
             int[] next=new int[]{x,y};
            while(true){
                 if(order=='C'||order=='D') next=temp.lower(next);
                 else next=temp.higher(next);
                 
                 if(next==null)continue Loop;
                 if(set.contains(next)){
                      temp.remove(next);
                     continue;
                 }else break;
            }
             temp.remove(next);
             set.add(next);
             x=next[0];
             y=next[1];
               
         }
        System.out.println(x+" "+y);
    }

 
}