import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static int N;
	public static TreeSet<Integer> set;

	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
	
			StringTokenizer st=new StringTokenizer(br.readLine());  		 
			 
			 N=Integer.parseInt(st.nextToken());
			 set=new TreeSet<>();
			 List<int[]> list=new ArrayList<>();	
			 for(int i=0;i<N;i++) {
				 st=new StringTokenizer(br.readLine());  
				 int h=Integer.parseInt(st.nextToken());
				 int k=Integer.parseInt(st.nextToken());
				 list.add(new int[] {h,k});
			 }
			 Collections.sort(list,new Comparator<int[]>() {
				 @Override
				 public int compare(int[] a,int[] b) {
					 if(a[0]!=b[0]) return Integer.compare(b[0],a[0]);
					 else return Integer.compare(a[1], b[1]);
				 }
			 });
			 
			 set.add(1);
			 int[] team=new int[N+2];
			 team[1]++;
			 int ret=1;
			 for(int i=1;i<N;i++) {
				 int[] stu=list.get(i);
				 Integer teamsize=set.lower(stu[1]);
				 if(teamsize==null) {
					 set.add(1);
					 team[1]++;
					 ret++;
				 }else {
					 team[teamsize]--;
					 if(team[teamsize]==0) set.remove(teamsize);
					 
					 team[teamsize+1]++;
					 set.add(teamsize+1);
				 }
				 
				 
			 }
			 System.out.println(ret);
		 
	 }
 }