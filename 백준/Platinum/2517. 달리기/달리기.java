import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] tree;
	public static int[] arr;
	public static Integer[] copy;
	public static int result;
	public static class runner{
		int idx;
		int skill;
		
		runner(int idx,int skill){
			this.idx=idx;
			this.skill=skill;
		}
	}
	public static void main(String args[]) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	N=Integer.parseInt(st.nextToken());
		
	tree=new int[4*N];
	List<runner> list =new ArrayList<>();	
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<N;i++) {
		list.add(new runner(i,Integer.parseInt(br.readLine())));
	}
	Collections.sort(list,new Comparator<runner>() {
		@Override
		public int compare(runner a,runner b) {
			return Integer.compare(a.skill, b.skill);
		}
	});
	for(int i=0;i<N;i++) {
		runner a=list.get(i);
		a.skill=i+1;
	}
	Collections.sort(list,new Comparator<runner>() {
		@Override
		public int compare(runner a,runner b) {
			return Integer.compare(a.idx, b.idx);
		}
	});
	for(int i=0;i<N;i++) {
		int skill=list.get(i).skill;
		sb.append(i+1-count(1,N,1,1,skill)).append("\n");
		insert(1,N,1,skill);
	}
	
	System.out.println(sb);
	}
	public static void insert(int start,int end,int idx,int num) {
		if(num<start||end<num) {
			return;
		}
		
		tree[idx]++;
		if(start==end) return;
		int mid=(start+end)/2;
		insert(start,mid,idx*2,num);
		insert(mid+1,end,idx*2+1,num);
		
		
	}
	
	public static int count(int start,int end,int idx,int ts,int te) {
		if(te<start||end<ts) return 0;
		
		if(ts<=start&&end<=te) {
			return tree[idx];
		}
	
		int mid=(start+end)/2;
		return count(start,mid,idx*2,ts,te)+count(mid+1,end,idx*2+1,ts,te);
		
	}
	
}