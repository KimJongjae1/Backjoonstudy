import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static long a;
    static long b;
    static long A;
    static long B;
    static Set<Long> set;
    static long prime=1000000;
    static long ans;
    public static void main(String[] args)throws IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

          StringTokenizer st=new StringTokenizer(br.readLine());
          a=Integer.parseInt(st.nextToken());
          b=Integer.parseInt(st.nextToken());
          A=Integer.parseInt(st.nextToken());  
           B=Integer.parseInt(st.nextToken());
            set=new HashSet<>();
            ans=A*prime+B;
            bfs();
     
      }
    public static void bfs(){
        Queue<long[]> qu=new LinkedList<>();
        qu.offer(new long[] {0L,0L,0L});
        set.add(0L);
        while(!qu.isEmpty()){
            long[] cur=qu.poll();
            long cura =cur[0];
            long curb=cur[1];
            if(cura*prime+curb == ans){
                System.out.println(cur[2]);
                return;
            }
            
            if(!set.contains(a*prime+curb)){
                qu.offer(new long[]{a,curb,cur[2]+1});
                set.add(a*prime+curb);
    
            } 
            if(!set.contains(cura*prime+b)){
                qu.offer(new long[]{cura,b,cur[2]+1});
                set.add(cura*prime+b);
            }
            if(!set.contains(cura*prime)){
                qu.offer(new long[]{cura,0,cur[2]+1});
                set.add(cura*prime);
            }
             if(!set.contains(curb)){
                qu.offer(new long[]{0,curb,cur[2]+1});
                set.add(curb);
            }
            long temp=give('b',cura,curb);
            long ca=temp/prime;
            long cb=temp%prime;
            if(!set.contains(ca*prime+cb)){
                qu.offer(new long[]{ca,cb,cur[2]+1});
                set.add(ca*prime+cb);
            }
            temp=give('a',cura,curb);
            ca=temp/prime;
            cb=temp%prime;
             if(!set.contains(ca*prime+cb)){
                qu.offer(new long[]{ca,cb,cur[2]+1});
                set.add(ca*prime+cb);
            }
            
        }
        System.out.println(-1);
    }
    
    public static long give(char giveto,long ca,long cb){
        long cura=ca;
        long curb=cb;
        
        if(giveto=='b'){
            curb+=cura;
            cura=0;
            if(curb>b){
                cura=curb-b;
                curb=b;
            }
        }else{
            cura+=curb;
            curb=0;
            if(cura>a){
                curb=cura-a;
                cura=a;
            }
        }
        return cura*prime+curb;
    }
  
}