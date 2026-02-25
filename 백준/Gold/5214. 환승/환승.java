import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class node{
        int idx;
        Set<Integer> set;

        node(int idx){
            this.idx=idx;
            set=new HashSet<>();
        }
    }
    static class tube{
        int idx;
        List<Integer> set;

         tube(int idx){
            this.idx=idx;
            set=new ArrayList<>();
        }
    }
    static node[] Node;
    static tube[] Tube;
    static int N;
    static int K;
    static int ans;
    public static void main(String[] args)throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

         StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         int M=Integer.parseInt(st.nextToken());
         K=Integer.parseInt(st.nextToken());
        
        Node=new node[N+1];
        for(int i=1;i<=N;i++){
            Node[i]=new node(i);
        }
        
        Tube=new tube[K+1];
        for(int i=0;i<K;i++){
             st=new StringTokenizer(br.readLine());
            Tube[i]=new tube(i);
            for(int k=0;k<M;k++){
                int n=Integer.parseInt(st.nextToken());
                Tube[i].set.add(n);
                Node[n].set.add(i);
            }
        }
        ans=-1;
        BFS();
        System.out.println(ans);

    }
    public static void BFS(){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{1,0});
        boolean[] visitNode=new boolean[N+1];
        boolean[] visitTube=new boolean[K+1];
        visitNode[1]=true;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
            if(cur[0]==N){
                ans=cur[1]+1;
                break;
            }
            
            for(int nextTube:Node[cur[0]].set){
                    if(visitTube[nextTube])continue;
                    visitTube[nextTube]=true;
                    for(int next:Tube[nextTube].set){
                        if(visitNode[next])continue;
                          visitNode[next]=true;
                          qu.offer(new int[]{next,cur[1]+1}); 
                    }
            }

            
        }
    }
}