import java.io.*;
import java.util.*;

public class Main {
    static int N;   
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=0; int idxa=0;
        int b=0; int idxb=0;
        Map<Integer,Integer> map =new HashMap<>();
        N=Integer.parseInt(br.readLine());
        arr=new int[8][2];
        for(int i=1;i<=6;i++) {
        	StringTokenizer st= new StringTokenizer(br.readLine());
        	arr[i][0]=Integer.parseInt(st.nextToken());
        	arr[i][1]=Integer.parseInt(st.nextToken());
        	if(!map.containsKey(arr[i][0])) map.put(arr[i][0],i);
        	else map.remove(arr[i][0]);
        }
        
        for(int key:map.keySet()) {
        	if(a==0) {
        	a=key; idxa=map.get(a);}
        	else {
        		b=key; idxb=map.get(b);
        	}
        }
        arr[0][0]=arr[6][0]; arr[0][1]=arr[6][1];
        arr[7][0]=arr[1][0]; arr[7][1]=arr[1][1];
        int idx1=0; int idx2=0;//1--b 2--a
        if(arr[idxa-1][0]!=arr[idxb][0]) idx1=idxa-1;
        else idx1=idxa+1;
        if(arr[idxb-1][0]!=arr[idxa][0]) idx2=idxb-1;
        else idx2=idxb+1;

        int range=arr[idxa][1]*arr[idxb][1]-(arr[idxa][1]-arr[idx2][1])*(arr[idxb][1]-arr[idx1][1]);
     
        System.out.println(range*N);
    }
    
  }