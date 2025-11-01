import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static int max;
   static class team implements Comparable<team>{
	   int id;
	   int cnt;
	   int last;
	   int score;
	   Map<Integer,Integer> map=new HashMap<>();
	   team(int id){
		   this.id=id;
	   }
	   
	   @Override
	   public int compareTo(team a) {
		   if(a.score!=this.score) return a.score-this.score;
		   else if(a.cnt!=this.cnt) return this.cnt-a.cnt;
		   else return this.last-a.last;
	   }
   }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
        int T=Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++) {
        	
        	st=new StringTokenizer(br.readLine());
        	N=Integer.parseInt(st.nextToken());
        	int K=Integer.parseInt(st.nextToken());
        	int ID=Integer.parseInt(st.nextToken());
        	int m=Integer.parseInt(st.nextToken());
        	team[] array=new team[N];
        	for(int i=0;i<N;i++) {
        		array[i]=new team(i);
        	}
        	
        	for(int i=0;i<m;i++) {
        	 	st=new StringTokenizer(br.readLine());
        	 	int id=Integer.parseInt(st.nextToken());
        	 	int problemID=Integer.parseInt(st.nextToken());
        	 	int score=Integer.parseInt(st.nextToken());
        	 	id--;
        	 	Map<Integer,Integer> map=array[id].map;
        	 	if(map.containsKey(problemID)) {
        	 		int BeforeScore=map.get(problemID);
        	 		 if(BeforeScore<score) {
        	 			 map.put(problemID, score);
        	 			 array[id].score+=score-BeforeScore;
        	 		 }
        	 	}
        	 	else {
        	 		map.put(problemID, score);
        	 		array[id].score+=score;
        	 	}
        	 	array[id].cnt++;
        	 	array[id].last=i;
        	 	
        	}
        	Arrays.sort(array);
        	for(int i=0;i<N;i++) {
        		if(array[i].id+1==ID) {
        			System.out.println(++i);
        			break;
        		}
        	}
        }
       
        
        
    }
    
}