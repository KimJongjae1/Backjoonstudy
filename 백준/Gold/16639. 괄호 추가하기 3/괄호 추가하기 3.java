import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static String str;
    public static void main(String[] args) throws Exception {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
       
        str=br.readLine();
         if(N==1){
            System.out.println(str.charAt(0));
             return;
        }
        int[][] min=new int[N][N];
        int[][] max=new int[N][N];
 
        for(int i=0;i<N;i+=2){
            Arrays.fill(max[i],Integer.MIN_VALUE);
            Arrays.fill(min[i],Integer.MAX_VALUE);
            max[i][i]=str.charAt(i)-'0';
            min[i][i]=str.charAt(i)-'0';
        }

        for(int k=2;k<N;k+=2){
            for(int i=0;i+k<N;i+=2){
                 int[] temp=new int[4];
                for(int q=i+2;q<=i+k;q+=2){
                    char sign=str.charAt(q-1);
                    temp[0]=calculate(max[i][q-2],sign,max[q][i+k]);
                    temp[1]=calculate(max[i][q-2],sign,min[q][i+k]);
                    temp[2]=calculate(min[i][q-2],sign,max[q][i+k]);
                    temp[3]=calculate(min[i][q-2],sign,min[q][i+k]);
                    Arrays.sort(temp);
                    max[i][i+k]=Math.max(max[i][i+k],temp[3]);
                    min[i][i+k]=Math.min(min[i][i+k],temp[0]);
                }
            }
        }
  
        
        System.out.println(max[0][N-1]);

   
    }

    public static int calculate(int sum,char sign,int nextNum){

        if(sign=='-'){
            return sum-nextNum;
        }else if(sign=='+'){
            return sum+nextNum;
        }else{
            return sum*nextNum;
        }
        
    } 
}