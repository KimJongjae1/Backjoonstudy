import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
   static int N;
   static int M;
   static  StringBuilder sb;
   static people[][] arr;
   static int[] lis;
   static class people{
	   int id;
	   int[] arr=new int[5];
	   int use;
	   people(int id) {
		   this.id=id;
		   this.use=-1;
	   }
	   
   }
   static int ans;
   static PriorityQueue<people>[] pq;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();;
     	N=Integer.parseInt(st.nextToken());
     	
     	arr=new people[5][5];
     	pq=new PriorityQueue[5];
   
     	for(int i=0;i<5;i++) {
     		final int idx=i;
     	 	pq[i]=new PriorityQueue<>(new Comparator<people>() {
         		@Override 
         		public int compare(people a,people b) {
         			return b.arr[idx]-a.arr[idx];
         		}
         	});
     	}
     	

     	for(int i=0;i<N;i++) {
     		st=new StringTokenizer(br.readLine());
     		people p=new people(i);
     		for(int k=0;k<5;k++) {
     			p.arr[k]=Integer.parseInt(st.nextToken());
     			
     		}
     		for(int k=0;k<5;k++)pq[k].offer(p);
     	}
     	for(int i=0;i<5;i++) {
     		for(int k=0;k<5;k++) {
     			arr[i][k]=pq[i].poll();
     		}
     	}
     	 ans=0;
     	find(0,0);
     	
     	System.out.println(ans);
     	
    }
    public static void find(int idx,int sum) {
    	if(idx==5) {
    		ans=Math.max(ans, sum);
    		return;
    	}
    	
    	for(int i=0;i<5;i++) {
    		people p=arr[idx][i];
    		if(p.use==-1) {
    			p.use=idx;
    			find(idx+1, sum+p.arr[idx]);
    			p.use=-1;
    		}
    		
    	}
    	
    	
    }
}