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
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            int idx=lowerbound(list,arr[i]);
  
            if(idx==list.size())
                list.add(arr[i]);
            else{
               list.set(idx,arr[i]); 
            }
            
        }
        System.out.println(list.size());
    }
    public static int lowerbound(List<Integer> list,int t){
        int max=list.size();
        int min=0;
        while(min<max){
            int mid=(max+min)/2;

            if(t>list.get(mid)){
                min=mid+1;
            }else{
                max=mid;
            }
        }
        return min;
    }
}