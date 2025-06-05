import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static class node{
		int num;
		node next;
		node prev;
		
		node(int num){
			this.num=num;
			this.next=null;
			this.prev=null;
		}
		
	}
	public static void delete(node insert) {
		node pre=insert.prev;
		node nxt=insert.next;
		pre.next=nxt;
		nxt.prev=pre;
		insert.prev=null;
		insert.next=null;
		
	}
	
	public static void link(node pre,node nxt,node insert) {
		pre.next=insert;
		nxt.prev=insert;
		insert.next=nxt;
		insert.prev=pre;
		
	}
	static int[] lis;
	static int[][] temp;
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());  		 

			N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			node[] list=new node[N+2];
			list[0]=new node(0);
			for(int i=1;i<=N+1;i++) {
				list[i]=new node(i);
				list[i-1].next=list[i];
				list[i].prev=list[i-1];
			}
			
			for(int i=0;i<M;i++) {
				 st=new StringTokenizer(br.readLine());  
				 char order=st.nextToken().charAt(0);
				 int move=Integer.parseInt(st.nextToken());
				 int place=Integer.parseInt(st.nextToken());
				 if(order=='A') {
					delete(list[move]);
					link(list[place].prev,list[place],list[move]);
				 }else {
					delete(list[move]);
					link(list[place],list[place].next,list[move]);
				 }
			}
			 lis=new int[N+1];
			 temp=new int[N+1][2];
			 int idx=0;
			 node n=list[0].next;
			 int num=n.num;
			 n=n.next;
			for(int i=0;i<N;i++) {
				int t=lowerbound(idx,num);
				
				if(idx==t) idx++;
				lis[t]=num;
				temp[i][0]=t;
				temp[i][1]=num;
					
				 num=n.num;
				 n=n.next;
			}
			System.out.println(N-idx);
			
			List<Integer> movingnum=new ArrayList<>();
			int first=0;
			idx--;		
			for(int i=N-1;i>=0;i--) {

				if(temp[i][0]!=idx) {
				
					movingnum.add(temp[i][1]);
				}else {
					idx--;
					if(idx==-1) {
						first=temp[i][1];
					}
				}
			}
			
			StringBuilder sb=new StringBuilder();
			Collections.sort(movingnum);
	
			for(int i=0;i<movingnum.size();i++) {
				int p=movingnum.get(i);
				if(p!=1) {
					sb.append("B ").append(p).append(" ").append(p-1).append("\n");
				}else {
					sb.append("A ").append(p).append(" ").append(first).append("\n");
				}
				
			}
			System.out.println(sb);
			
	 }
	public static int lowerbound(int idx,int target) {
		int min=0;
		int max=idx;
		
		while(min<max) {
			int mid=(max+min)/2;
			
			if(lis[mid]<target) {
				min=mid+1;
			}else {
				max=mid;
			}
			
		}
		return min;
		
	}
 }
