import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
      static ArrayList<Integer> num = new ArrayList<>();
      static ArrayList<Character> cal = new ArrayList<>();
      static ArrayList<Character> temp = new ArrayList<>();
      static int max=Integer.MIN_VALUE;
      static int N;
      static int M;
     public static void main(String[] args)throws Exception {
     BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
     N=Integer.parseInt(br.readLine());	 
     
     StringTokenizer st =new StringTokenizer(br.readLine(),"-+*",true);
      
     	for(int i=0;i<N/2;i++) {
    	    num.add(Integer.parseInt(st.nextToken()));
    	    cal.add(st.nextToken().charAt(0));
     	}
     	 num.add(Integer.parseInt(st.nextToken()));
        M=cal.size();
        
        dfs(0,num.get(0));
        System.out.println(max);
     
    }
    public static void dfs(int calidx,int sum) {
    	
    	if(calidx==M) {
    		max=Math.max(max, sum);
    		return;
    	}
    	else {
    		int firstcal=calculate(cal.get(calidx),sum,num.get(calidx+1));
    		dfs(calidx+1,firstcal);
    		
    		if(calidx+1<M) {
    			int secondcal=calculate(cal.get(calidx+1),num.get(calidx+1),num.get(calidx+2));
    			sum=calculate(cal.get(calidx),sum,secondcal);
    			dfs(calidx+2,sum);
    		}	
    	}
    	
    }
    
    public static int calculate(char cal, int a,int b) {
    	
    	switch(cal) {
    	case '-':
    		return a-b;
    	case '+':
    		return a+b;
    	case '*':
    		return a*b;
    	}
    	
    	return 1;
    }
    
}
