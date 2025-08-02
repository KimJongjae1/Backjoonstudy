import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[] diy= {-1,-1,1,1,0,0,-1,1};
	static int[] dix= {1,-1,1,-1,1,-1,0,0};
	public static class trienode{
		Map<Character, trienode> map=new TreeMap<>();
		
		Character a;
		boolean terminal;
		
		trienode(){}
		
		trienode(char a){
			this.a=a;
		}
		
		public  void insert(String str) {
			trienode cur=this;
			for(int i=0;i<str.length();i++) {
				char nxt=str.charAt(i);
				cur.map.putIfAbsent(nxt, new trienode(nxt));
				cur=cur.map.get(nxt);
				if(i==str.length()-1)
					cur.terminal=true;
			}
		}
		
		
	}
	
	public static Set<String> set;
	public static int ret=0;
	public static int score=0;
	public static String max;
	public static boolean[][] visit;
	public static void dfs(int y,int x,trienode trie,String str) {
		if(trie.terminal) {
			if(!set.contains(str)) {
				set.add(str);
				ret++;
				score+=sco(str);
				if(str.length()>max.length())max=str;
				else if(str.length()==max.length()) {
					if(max.compareTo(str)>0)max=str;
				}
			}
			
		}
		if(str.length()==8)
		return;
		
		for(int i=0;i<8;i++) {
			int Y=y+diy[i];
			int X=x+dix[i];
			if(Y<0||Y>=4||X<0||X>=4) continue;
			if(visit[Y][X])continue;
			if(!trie.map.containsKey(arr[Y][X])) continue;		
			visit[Y][X]=true;
			String newstr=str+arr[Y][X];

			dfs(Y,X,trie.map.get(arr[Y][X]),newstr);
			visit[Y][X]=false;
		}
		
	}
	
	
	public static int sco(String a) {
		int len=a.length();
		if(len<=2) return 0;
		else if(len<=4) return 1;
		else if(len<=5) return 2;
		else if(len<=6) return 3;
		else if(len<=7) return 5;
		else  return 11;
	}
	public static trienode start;
	public static char[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start=new trienode();
        for(int i=0;i<N;i++){
        	String strin=br.readLine();
        	start.insert(strin);
        }
        StringBuilder sb=new StringBuilder();
        br.readLine();
        int M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
        	
        	   arr=new char[5][5];
        	for(int k=0;k<4;k++) {
        		String s=br.readLine();
        		for(int q=0;q<4;q++) {
        			arr[k][q]=s.charAt(q);
        		}
        	}

        set=new TreeSet<>();
        visit=new boolean[4][4];
    	ret=0;
		score=0;
		max="";
        for(int k=0;k<4;k++) {
        	for(int q=0;q<4;q++) {
        		
        		char ch = arr[k][q];
        		if (start.map.containsKey(ch)) {
        		    visit[k][q] = true;
        		    dfs(k, q, start.map.get(ch), "" + ch);
        		    visit[k][q] = false;
        		}

        	}
        }
       sb.append(score+" ").append(max+" ").append(ret).append("\n"); 
       if(i!=M-1)
       br.readLine();
        }
        System.out.println(sb);
    }
}
