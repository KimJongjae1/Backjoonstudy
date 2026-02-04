import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
        int L=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int C=Integer.parseInt(br.readLine());
        Queue<Integer> Attack=new LinkedList<>();
        for(int i=0;i<N;i++){
            int Z=Integer.parseInt(br.readLine());
            while(!Attack.isEmpty()&&i-Attack.peek()>=L){
                Attack.poll();
            }
      
            int D=Attack.size()*K;
           
            if(D+K<=K*L) D+=K;
      
            if(D<Z){
                if(C>0)C--;
                else {
                    System.out.println("NO");
                    return;
                }
            }else{
                Attack.offer(i);
            }
        }
        System.out.println("YES");
    }
}