import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<Integer> list;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

         int N=Integer.parseInt(st.nextToken());
         arr=new int[N];
         st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int id=0;
        int[] temp=new int[N];
        list=new ArrayList<>();
        for(int i=0;i<N;i++){
            int idx=lowerbound(arr[i]);
        
            if(id==idx){
                id++;
                list.add(arr[i]);
            }else{
                list.set(idx,arr[i]);
            }
            temp[i]=idx;
           
        }
        int[] lis=new int[id];
        int idx=id-1;
        for(int i=N-1;i>=0;i--){
            if(idx==temp[i]){
                lis[idx]=arr[i];
                idx--;
                if(idx<0)break;
            }
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(lis[i]+" ");
        }
        System.out.println(id);
        System.out.println(sb);
        
        
    }
    public static int lowerbound(int t){
        int max=list.size();
        int min=0;
        while(min<max){
            int mid=(min+max)/2;

            if(list.get(mid)<t)  min=mid+1;
            else max=mid;
            
        }
        return min;
    }
}