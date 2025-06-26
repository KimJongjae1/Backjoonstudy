import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a,int[] b) {
        		if(a[0]!=b[0])return Integer.compare(a[0], b[0]);
        		else if(a[1]!=b[1]) return Integer.compare(b[1], a[1]);
        		else return Integer.compare(b[2], a[2]);
        	}
        });
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	int s=Integer.parseInt(st.nextToken());
        	int h=Integer.parseInt(st.nextToken());
        	int e=Integer.parseInt(st.nextToken());
        	pq.offer(new int[] {s,h,e});
        	
        }
        StringBuilder sb=new StringBuilder();
        List<int[]> ans=new ArrayList<>();
        int[] tall=pq.poll();
        while(!pq.isEmpty()) {
        	int[] building=pq.poll();
        	
        	if(tall[2]<=building[0]) { 	
        		if(tall[2]==building[0]&&tall[1]==building[1]) {
        			tall=new int[] {tall[0],tall[1],building[2]};
        			continue;
        		}
        		
        		ans.add(new int[] {tall[0],tall[1],tall[2]});  	
        		tall=building;
        	}
        	else if(tall[2]<=building[2]){
        		if(tall[1]<building[1]) {
        			ans.add(new int[] {tall[0],tall[1],building[0]});
        			tall=building;
        		}else if(tall[1]==building[1]) {
        			tall=new int[] {tall[0],tall[1],building[2]};
        		}else {
        			if(tall[2]==building[2])continue;
        			pq.offer(new int[] {tall[2],building[1],building[2]});
        		}
        	}else if(tall[2]>building[2]){
        		if(building[1]>tall[1]) {
        			ans.add(new int[] {tall[0],tall[1],building[0]});
        			pq.offer(new int[] {building[2],tall[1],tall[2]});
        			tall=building;
        		}
        	}
 
        }
       
        ans.add(tall);

        for(int i=0;i<ans.size();i++) {
        	int[] building=ans.get(i);
        	sb.append(building[0]).append(" ").append(building[1]).append(" ");
  
        	
        	if(i!=ans.size()-1) {
        		if(building[2]!=ans.get(i+1)[0])
        			sb.append(building[2]).append(" ").append(0).append(" ");
        	}else {
        		sb.append(building[2]).append(" ").append(0).append(" ");
        	}
        	
        	

        }
 
        	System.out.println(sb);
    }
    
}