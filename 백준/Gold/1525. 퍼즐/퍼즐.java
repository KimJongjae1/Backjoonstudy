import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static String ans;
    static Map<String,Integer> map;
    static int dist=Integer.MAX_VALUE;
    static int[] dix={-3,3,1,-1};
    static class pair{
        String s;
        int idx;
        int d;
        pair(String s,int idx,int d){
            this.s=s;
            this.idx=idx;
            this.d=d;
        }
    }
    public static void main(String[] args)throws IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

      //StringTokenizer st=new StringTokenizer(br.readLine());
      //int N=Integer.parseInt(st.nextToken());

        map=new HashMap<>();
        ans="123456780";
        
       
        int zero=0;
        String s="";
      for(int i=0;i<=2;i++){
          StringTokenizer st=new StringTokenizer(br.readLine());
          for(int k=0;k<=2;k++){
              int n=Integer.parseInt(st.nextToken());
              s+=n;
              if(n==0){
                  zero=i*3+k;
              }
          }
      }
       
        BFS(s,zero);
        if(dist==Integer.MAX_VALUE)System.out.println(-1);
        else System.out.println(dist);
        
    }
    
    
    public static void BFS(String s,int zero){
        Queue<pair> qu=new LinkedList<>();
        qu.offer(new pair(s,zero,0));
        map.put(s,0);
        
        while(!qu.isEmpty()){
            pair cur=qu.poll();
      
             if(ans.equals(cur.s)){
                 dist= cur.d;
                 return;
             }
            
            char[] temp=cur.s.toCharArray();
            
            int curZeroid=cur.idx;
             
            for(int i=0;i<4;i++){
                int newZeroid=curZeroid+dix[i];
                if(newZeroid<0||newZeroid>=9)continue;
                if(i>=2&&newZeroid/3!=curZeroid/3)continue;
                
                temp[curZeroid]=temp[newZeroid];
                temp[newZeroid]='0';
                
                String NEWs=new String(temp);

                temp[newZeroid]=temp[curZeroid];
                temp[curZeroid]='0';
                if(map.containsKey(NEWs))continue;
                
                map.put(NEWs,cur.d+1);
                qu.offer(new pair(NEWs,newZeroid,cur.d+1));
                
                
            }
        }
        
    }
  
}