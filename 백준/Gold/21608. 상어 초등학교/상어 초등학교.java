
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Set<Integer>[] list;
	static int[][] school;
	static int[] diy= {-1,0,0,1};
	static int[] dix= {0,-1,1,0};
	
   public static void main(String args[]) throws IOException{
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		 
        N=Integer.parseInt(br.readLine());
       
         school=new int[N+1][N+1];
         list=new HashSet[N*N+1];
         
         for(int i=0;i<=N*N;i++) {
        	 list[i]=new HashSet<>();
         }
         Queue<Integer> order=new LinkedList<>();
         
         for(int i=1;i<=N*N;i++) {
        	 StringTokenizer st=new StringTokenizer(br.readLine());
        	 int start=Integer.parseInt(st.nextToken());
        	 order.offer(start);
        	 list[start].add(Integer.parseInt(st.nextToken())); 
        	 list[start].add(Integer.parseInt(st.nextToken())); 
        	 list[start].add(Integer.parseInt(st.nextToken())); 
        	 list[start].add(Integer.parseInt(st.nextToken())); 
         }
         school[2][2]=order.poll();
      while(!order.isEmpty()) {
        	 int next=order.poll();
        	 
        	 insert(next);

         }
      
        int ans=0;
         for(int i=1;i<=N;i++) {
        	 for(int k=1;k<=N;k++) {
        		 ans+=checkscore(i,k);
        	 }
         }
       System.out.println(ans);
   }
   
   public static void insert(int studentnum) {
	   PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
		   @Override
		   public int compare(int[] a,int[] b) {
			   if(a[2]!=b[2]) return Integer.compare(b[2],a[2]);
			   else if(a[3]!=b[3]) return Integer.compare(b[3],a[3]);
			   else if(a[0]!=b[0])return Integer.compare(a[0], b[0]);
			   else return Integer.compare(a[1], b[1]);
		   }
	   });
	   
	
	   for(int i=1;i<=N;i++) {
		   for(int k=1;k<=N;k++) {
			
			   if(school[i][k]>0) continue;
		
			   int bcnt=0; int lcnt=0;
			   
			   for(int q=0;q<4;q++) {
				   int Y= i+diy[q];
				   int X= k+dix[q];
				   
				   if(1<=Y&&Y<=N&&1<=X&&X<=N) {
			          if(school[Y][X]==0) {
			        	  bcnt++;
			          }else if(school[Y][X]>0&&list[studentnum].contains(school[Y][X])){ 
			        	  lcnt++;
			          }
			     
		    }
	      }
		  pq.offer(new int[] {i,k,lcnt,bcnt}); 
	   }
	   
	 }
	  
	   int[] next=pq.poll();
	   school[next[0]][next[1]]=studentnum;
	   
   }
   
   public static  int checkscore(int y,int x) {
	   
	   int sum=1;
	   int cnt=0;
	   for(int i=0;i<4;i++) {
		   int Y= y+diy[i];
		   int X= x+dix[i];
		   if(1<=Y&&Y<=N&&1<=X&&X<=N) {
			  if(list[school[y][x]].contains(school[Y][X])) {
				  cnt++;
			  }
		   }
	   }
	   if(cnt==0)sum=0;
	   else {sum*=(int)Math.pow(10, cnt-1);}
	   return sum;
   }
   
}