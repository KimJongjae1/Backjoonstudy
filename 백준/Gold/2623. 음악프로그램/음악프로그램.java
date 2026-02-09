import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] temp=new int[N+1];
        List<Integer>[] list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int first=Integer.parseInt(st.nextToken());
             for(int k=1;k<n;k++){
                 int next=Integer.parseInt(st.nextToken());
      
                 temp[next]++;
                 list[first].add(next);
                 first=next;
             }
        }

        StringBuilder sb=new StringBuilder();
        Queue<Integer> qu=new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(temp[i]==0)qu.offer(i);
        }
        while(!qu.isEmpty()){
            int cur=qu.poll();
            sb.append(cur+"\n");
            for(int i=0;i<list[cur].size();i++){
                int next=list[cur].get(i);
                temp[next]--;
                if(temp[next]==0){
                    qu.offer(next);
                }
            }
        }
         for(int i=1;i<=N;i++){
            if(temp[i]>0){
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb);
    }
}