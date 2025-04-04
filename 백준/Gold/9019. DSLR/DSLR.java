import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	public static void bfs(int a,int b) {
		Queue<group> qu = new LinkedList<>();
		qu.offer(new group(a,""));
		
		visited[a]=true;
		while(!qu.isEmpty()) {
			group temp= qu.poll();
		    
			if(temp.num==b) {
				System.out.println(temp.ans);
				break;
			}
	        int D=temp.D2n();  
	        int S=temp.Rminus();
	        int L=temp.Left();
	        int R=temp.Right();
	        
			if(!visited[D]) {
				visited[D]=true;
				qu.offer(new group(D,temp.ans+"D"));}
			
			if(!visited[S]) {
				visited[S]=true;
				qu.offer(new group(S,temp.ans+"S"));}
			
			 if(!visited[L]) {
				 visited[L]=true;
				 qu.offer(new group(L,temp.ans+"L"));}
			 
			if(!visited[R]) {
				visited[R]=true;
				qu.offer(new group(R,temp.ans+"R"));}
	
		}
	}
	
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int A = Integer.parseInt(st.nextToken());
		 int B = Integer.parseInt(st.nextToken());
         visited=new boolean[10000];

		 bfs(A,B);

		}	
	}
	
	static class group {
		int num;
		String ans;
		
		group(int num,String ans) {
			this.num=num;
			this.ans=ans;
		}
		
		int D2n() {
			return (2*num)%10000;
		}

		int Rminus() {
			return (num>=1)? num-1:9999;
		}
		
		 int Left() {
			return num/1000+(num%1000)*10;
		}
		// 1234 4123
		int Right() {
			return num%10*1000+num/10;
		}
	}

  }
