import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static String str;
    static int N;
    static int idx;
    static int p;
    public static void main(String[] args)throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        str=br.readLine();

        p=0;
        N=str.length();
        idx=0;
        while(idx<N){
             char a=str.charAt(idx);
            if(a=='P'){
               if(!ppap()){
                   idx++;
                   p++;
               }
            }else{
                if(!checkA()){
                    System.out.println("NP");
                    return;
                }
            }
        }
        if(p==1) System.out.println("PPAP");
        else System.out.println("NP");
        
    }
    public static boolean ppap(){
        if(idx>=N-2)return false;
        
        if(p>0){
            if(str.charAt(idx+1)=='A'&&str.charAt(idx+2)=='P'){
                idx+=3;
                return true;  
             }
        }
        
        if(idx>=N-3)return false;
        if(str.charAt(idx+1)=='P'&&str.charAt(idx+2)=='A'&&str.charAt(idx+3)=='P'){
            idx+=4;
            p++;
            return true;
        }
        
       
       
        
        return false;
        
    }
        public static boolean checkA(){

            if(idx==N-1)return false;
            if(p>=2&&str.charAt(idx+1)=='P'){
                p--;
                idx+=2;
                return true;
            }

            return false;
        }
}