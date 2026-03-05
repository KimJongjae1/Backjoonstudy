import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st =new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N][M];
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int []b){
                return a[2]-b[2];
            }
        });
        int max=0;
        int idx=0;
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            for(int k=0;k<M;k++){
                arr[i][k]=Integer.parseInt(st.nextToken());
            }
           Arrays.sort(arr[i]);
            pq.offer(new int[]{i,0,arr[i][0]});
            if(max<arr[i][0]){
                idx=i;
                max=arr[i][0];
            }
        }
        int ans=max-pq.peek()[2];

        while(pq.size()>1){
            int[] min=pq.poll();
            
            if(min[0]==idx){
                pq.offer(min);
                continue;
            }
            
            ans=Math.min(ans,max-min[2]);
            if(min[1]<M-1) {
                pq.offer(new int[]{min[0],min[1]+1,arr[min[0]][min[1]+1]});
                if(max<arr[min[0]][min[1]+1]){
                    idx=min[0];
                    max=arr[min[0]][min[1]+1];

                }
            }else break;
            
            
        }
        System.out.println(ans);
    }
}