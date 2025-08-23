import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
    static int N;
    static int x;
    static int y;
    static int X;
    static int Y;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine()) ;

        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<K;i++) {
        	st=new StringTokenizer(br.readLine()) ;
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	list.add(new int[] {b,a});
        }
        
        int max=0;
        for(int i=0;i<K;i++) {
        	for(int k=0;k<K;k++) {
           	 y=list.get(i)[0];
           	 Y=y+L;
           	 x=list.get(k)[1];
           	 X=x+L;


        
        		int cnt=0;
        		for(int q=0;q<K;q++) {
        			int[] temp=list.get(q);
        			if(y>temp[0]||temp[0]>Y||x>temp[1]||temp[1]>X) continue;
        			
        			cnt++;
        		}
        		max=Math.max(max, cnt);
        		
        	}
        	
        }
        System.out.println(K-max);
    }
  
}