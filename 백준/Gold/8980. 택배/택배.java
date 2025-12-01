import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static List<Integer>[] list;
	static long ans;
	static int idx;
	static boolean[] visit;
	static int[] diy= {-1,0,1,0};
	static int[] dix= {0,-1,0,1};
	static StringBuilder sb;
	static BufferedReader br;
	static class box implements Comparable<box>{
		int quantity;
		int start;
		int end;
		
		box(int start,int end,int quantity){
			this.start=start;
			this.end=end;
			this.quantity=quantity;
		}
		
		public int compareTo(box a) {
			if(a.end!=this.end) return this.end-a.end;
			else  return this.start-a.start;

		}
		
	}
	
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());	
        N= Integer.parseInt(st.nextToken());
        int C= Integer.parseInt(st.nextToken());
         M= Integer.parseInt(br.readLine());
        box[] boxes=new box[M];
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());	
        	int start=Integer.parseInt(st.nextToken());
        	int end=Integer.parseInt(st.nextToken());
        	int quantity=Integer.parseInt(st.nextToken());
    
        	boxes[i]=new box(start,end,quantity);
        }
        
        Arrays.sort(boxes);
        int ret=MaxBox(boxes,C);
        System.out.println(ret);
        	
  
    }
    public static int MaxBox(box[] boxes,int C) {
    	int[] town=new int[N+1];
    	int ret=0;
    	Arrays.fill(town, C);
    	for(int i=0;i<M;i++) {
    		box cur=boxes[i];
    		
    		int min=Integer.MAX_VALUE;
    		for(int k=cur.start;k<cur.end;k++) {
    			min=Math.min(min,town[k]);
    		}
    		
    		if(min>=cur.quantity) {
    			for(int k=cur.start;k<cur.end;k++) {
    				town[k]-=cur.quantity;
    			}
    			ret+=cur.quantity;
    		}else {
    			for(int k=cur.start;k<cur.end;k++) {
    				town[k]-=min;
    			}
    			ret+=min;
    		}
    		
    	}
    	return ret;
    	
    }
}