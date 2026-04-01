import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int M;
    static int[] dp;
     static int[] arr;
     static List<Integer>[] list;
     static boolean[] visit;
     static int idx;
    static boolean flag;
     static StringBuilder sb;
     static Set<Integer> set;
     static int ans;
 
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        //StringTokenizer st=new StringTokenizer(br.readLine());
       // N=Integer.parseInt(st.nextToken());
        int[] win=new int[6];
        int[] lose=new int[6];
        int[] draw=new int[6];

        Loop:for(int i=0;i<4;i++){
         StringTokenizer  st=new StringTokenizer(br.readLine());
         flag=false;
            for(int k=0;k<6;k++){           
                win[k]=Integer.parseInt(st.nextToken());
                draw[k]=Integer.parseInt(st.nextToken());
                lose[k]=Integer.parseInt(st.nextToken());
                if(win[k]+draw[k]+lose[k]!=5){
                    sb.append(0+" ");
                    continue Loop;
                }
             
            }
            
            BACK(0,1,win,draw,lose);
            if(flag) sb.append(1+" ");
            else sb.append(0+" ");
                
        }
        System.out.println(sb);
    }
    public static void BACK(int cur,int id,int[] win,int[] draw,int[] lose){
        if(flag)return;
        if(cur==6){
            flag=true;
            return;
        }
        if(id==6){
            BACK(cur+1,cur+2,win,draw,lose);
            return;
        }
        
        if(win[cur]>0&&lose[id]>0){
            win[cur]--;
            lose[id]--;
            BACK(cur,id+1,win,draw,lose);
            win[cur]++;
            lose[id]++;
        }
        if(flag)return;
        if(win[id]>0&&lose[cur]>0){
            win[id]--;
            lose[cur]--;
            BACK(cur,id+1,win,draw,lose);
            win[id]++;
            lose[cur]++;
        }
        if(flag)return;
        if(draw[cur]>0&&draw[id]>0){
            draw[cur]--;
            draw[id]--;
            BACK(cur,id+1,win,draw,lose);
            draw[id]++;
            draw[cur]++;
        }
        
    }
    
}