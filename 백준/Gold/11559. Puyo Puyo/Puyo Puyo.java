import java.io.*;
import java.util.*;

public class Main {
    static char arr[][];
    static boolean[][] visit;
    static int[] diy= {-1,1,0,0};
    static int[] dix= {0,0,1,-1};
    static int ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr=new char[12][6];
        visit=new boolean[12][6];
       for(int i=0;i<12;i++) {
    	   String str=br.readLine();
    	   for(int k=0;k<6;k++) {
    		  arr[i][k]=str.charAt(k);   
    	   }
       }
       
       while(true) {
          int change=0;
	       for(int i=0;i<12;i++) {
	    	   for(int k=0;k<6;k++) {
	    		   if(!visit[i][k]&&arr[i][k]!='.') {
	    			   change+=bfs(arr[i][k],i,k);
	    			   
	    		   }
	    	   }
	       }
	       
	       if(change==0) break;
	       else {
	    	   ans++;
	    	   visit=new boolean[12][6];
	       }
	       
	       for(int i=0;i<6;i++) {
	    	   while(!gravitation(i)) {
	    		   
	    	   }
	       }
	
	       
       }
       
       System.out.println(ans);
      
    }
    public static int bfs(char a,int y,int x) {
    	Queue<int[]> qu =new LinkedList<>();
    	List<int[]> list=new ArrayList<>();
    	qu.offer(new int[] {y,x});
    	list.add(new int[] {y,x});
    	visit[y][x]=true;
    	int cnt=1;
    	while(!qu.isEmpty()) {
    		int[] now=qu.poll();
    		
    		for(int i=0;i<4;i++) {
    			int Y=now[0]+diy[i];
    			int X=now[1]+dix[i];
    			if(Y>=0&&Y<12&&X>=0&&X<6) {
    				if(!visit[Y][X]&&arr[Y][X]==a) {
    					visit[Y][X]=true;
    					cnt++;
    					qu.offer(new int[] {Y,X});
    					list.add(new int[] {Y,X});
    				}
    			}
    		}
    		
    		
    	}
    	int change=0;
    	if(cnt>=4) {
    		change++;
    		for(int[] yo:list) {
    			arr[yo[0]][yo[1]]='.';
    		}
    	}
    	return change;
    }
    
    public static boolean gravitation(int x) {
    	int start=-1; int yo=-1;
    	for(int i=11;i>=0;i--) {
    		if(arr[i][x]=='.') {
    			start=i;
    			for(int k=start;k>=0;k--) {
    				if(arr[k][x]!='.') {
    					yo=k;
    					break;
    				}
    			}
    			break;
    		}
    	}
    	if(yo==-1||start==-1) return true;
    	while(arr[yo][x]!='.') {
    		arr[start][x]=arr[yo][x];
    		arr[yo][x]='.';
    		start--;
    		yo--;
    		
    		if(yo<0)
    		  return true;
    	}
    	 return false;
    	
    }
}