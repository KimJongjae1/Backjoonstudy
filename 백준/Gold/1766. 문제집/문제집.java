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
            int first=Integer.parseInt(st.nextToken());
            int next=Integer.parseInt(st.nextToken());
            temp[next]++;
            list[first].add(next);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            if(temp[i]==0)pq.offer(i);
        }
    StringBuilder sb =new StringBuilder();
        while(!pq.isEmpty()){
            int n=pq.poll();
        sb.append(n+" ");
            for(int i=0;i<list[n].size();i++){
                int next=list[n].get(i);
                temp[next]--;

                if(temp[next]==0)pq.offer(next);
            }
        }
        System.out.println(sb);
    }
}