import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N;
    static int[] dp;
     static char[][] arr;
     static List<int[]> list;
     static int idx;
     static StringBuilder sb;
     static Set<Integer> set;
     static int[] sum;
    static int[] ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        String str=br.readLine();
        arr=new char[N+1][N+1];
        ans=new int[N+1];
        sum=new int[N+1];
        idx=0;
        for(int i=1;i<=N;i++){
            for(int k=i;k<=N;k++){
                arr[i][k]=str.charAt(idx++);
            }
           
        }

        if(arr[1][1]=='0'){
            ans[1]=0;
            BACK(2);
            return;
        }
        
        BACK(1);

        
    }
    public static void BACK(int level){

        if(level==N+1){
            for(int i=1;i<=N;i++){
                sb.append(ans[i]+" ");
            }
            System.out.println(sb);
            System.exit(0);
        }
        
        boolean plus=false;
        if(arr[level][level]=='+')plus=true;
        
    Loop:for(int i=0;i<=10;i++){

            int n=i;
            if(!plus)n=-i;
            sum[level]=sum[level-1]+n;
            
            for(int k=level;k>=1;k--){
                int s=sum[level]-sum[k-1];
 
                if(arr[k][level]=='+'){
                    if(s<=0)continue Loop;
                    
                }else if(arr[k][level]=='0'){
                    if(s!=0) continue Loop;
                    
                }else {
                    if(s>=0) continue Loop;
                }
            }

            ans[level]=n;
            BACK(level+1);

       
        }
        
    }
}