import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static Set<String> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
         String[] STR=new String[N];
          set=new HashSet<>();
        for(int i=0;i<N;i++){
            STR[i]=br.readLine();
          
        }
        for(int i=0;i<M;i++){
            String S="";
            for(int k=0;k<N;k++){
                S+=STR[k].charAt(i);
            }
            set.add(S);
        }
        int ans=0;
      
        for(int i=1;i<N;i++){
            if(!check(1))break;
            ans++;
        }
        System.out.println(ans);
    }
    
    public static boolean check(int n){
        Set<String> NEWSET=new HashSet<>();
  
        for(String s:set){
           String NEW=s.substring(n); 

           if(NEWSET.contains(NEW))return false;
            NEWSET.add(NEW);
        }
        set=NEWSET;
        return true;
    }
}