import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
     static int N;
     static boolean[] visit;
     static int[][] score;
     static int maxscore=0;
     static int tempscore=0;
     static ArrayList<Integer> list =new ArrayList<>();
     public static void main(String[] args)throws Exception {
     BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
     
     N=Integer.parseInt(br.readLine());
     

       score=new int[N+1][10];
       visit =new boolean[10];
       visit[0]=true;
	     for(int i=1;i<=N;i++) {
	    	 StringTokenizer st =new StringTokenizer(br.readLine());
	    	 for(int k=1;k<=9;k++) {
	    		 score[i][k]=Integer.parseInt(st.nextToken());
	    	 }
	     }

	     bfs();
	     System.out.println(maxscore);

    }
    
     public static void bfs() {
    	 if(list.size()==8) {
    		 list.add(3,1);
    		 tempscore=0;
    		 game(1,0);
    		if(maxscore<tempscore) {
    			maxscore=tempscore;
    		}
    		 list.remove(3);
    		 return;
    	 }else {
    		 for(int i=2;i<=9;i++) {
    			 if(!visit[i]) {
    				 visit[i]=true;
    				 list.add(i);
    				 bfs();
    				 visit[i]=false;
    				 list.remove(list.size()-1);
    			 }
    		 }
    	 }
    	 
     }
     
     public static void game(int ining,int start) {
    	 if(ining==N+1) return;
    	
    	 int outcnt=0;
    	 boolean[] base=new boolean[4]; 
    	 int nextstart=0;
    	 Loop:while(outcnt<3) {
    			 int temp=score[ining][list.get(start)];
    			
    			 if(temp>=1&&temp<=3) {
    				 for(int k=3;k>=1;k--) {
    					 if(base[k]) {
    						 if(k+temp>=4) {
    							 tempscore++;
    							base[k]=false;
    						 }else {
    							 base[k]=false;
    							 base[k+temp]=true;
    						 }
    					 }
    				 }
    				base[temp]=true;
    			 }
    			 
    			 else if(temp==4) {
    				 for(int k=1;k<=3;k++) {
    					 if(base[k]) {
    						 base[k]=false;
    						 tempscore++;
    					 }
    				 }
    				tempscore++;
    			 }
    			 
    			 else {
    				 outcnt++;
	    				 if(outcnt>=3) {
	    					 nextstart=(start+1)%9;
	    					 break Loop;
	    				 }
    			 }
    		 start++;
    		 start%=9;
    	 }
    	 game(ining+1,nextstart);
    	 
     }
     
}