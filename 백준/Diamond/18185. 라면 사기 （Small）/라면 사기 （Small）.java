import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        long ans=0;
        for(int i=0;i<N-2;i++){
            if(arr[i+1]>arr[i+2]){
                int diff=arr[i+1]-arr[i+2];
                int min=Math.min(diff,arr[i]);
                arr[i]-=min;
                arr[i+1]-=min;
                ans+=5*min;
            }
            
            int min=arr[i];
             min=Math.min(min,Math.min(arr[i+1],arr[i+2]));
               ans+=7*min;
               for(int k=i;k<=i+2;k++){
                arr[k]-=min;

           }
        }
         for(int i=0;i<N-1;i++){
            int min=Math.min(arr[i],arr[i+1]);

               ans+=5*min;

           for(int k=i;k<=i+1;k++){
                arr[k]-=min;
            
           }
        }
         for(int i=0;i<N;i++){
            ans+=3*arr[i];
        }
        System.out.println(ans);
    }
}