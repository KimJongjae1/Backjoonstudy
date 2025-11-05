import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static int[] arr;
   static char[][] carr;
   static class country implements Comparable<country>{
	   int idx;
	   int gold;
	   int silver;
	   int bronze;
	   
	   country(int idx,int gold,int silver,int bronze){
		   this.idx=idx;
		   this.gold=gold;
		   this.silver=silver;
		   this.bronze=bronze;
	   }
	   
	   public int compareTo(country a) {
		   if(a.gold!=this.gold) return a.gold-this.gold;
		   else if(a.silver!=this.silver) return a.silver-this.silver;
		   else return a.bronze-this.bronze;
	   }
   }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        List<country> list=new ArrayList<>();
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	int idx=Integer.parseInt(st.nextToken());
        	int gold=Integer.parseInt(st.nextToken());
        	int silver=Integer.parseInt(st.nextToken());
        	int bronze=Integer.parseInt(st.nextToken());
        	list.add(new country(idx,gold,silver,bronze));
        }
        Collections.sort(list);
        int ans=0;
        for(int i=0;i<list.size();i++) {
        	if(list.get(i).idx==M) {
        		ans=i;
        		break;
        	}
        }
        country th=list.get(ans);
        for(int i=ans-1;i>=0;i--) {
        	if(th.compareTo(list.get(i))==0) {
        		ans--;
        	}else break; 
        }
        ans++;
        System.out.println(ans);
    }
}