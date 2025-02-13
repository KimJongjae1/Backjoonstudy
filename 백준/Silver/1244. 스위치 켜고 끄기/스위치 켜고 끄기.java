import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		int[] light =new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			light[i]=Integer.parseInt(st.nextToken());
		}
		
		int button = Integer.parseInt(br.readLine());
		
		for(int i=0;i<button;i++) {
			st = new StringTokenizer(br.readLine());
			int sex=Integer.parseInt(st.nextToken());
			int buttonnum=Integer.parseInt(st.nextToken());
			
			if(sex==1) {
				int time=buttonnum;
				while(buttonnum<=N) {
					if(light[buttonnum]==1)light[buttonnum]=0;
					else {light[buttonnum]=1;}
				
					buttonnum+=time;
				}
			}else {
				int count=0;
				while(buttonnum-count>=1&&buttonnum+count<=N) {
					int low =buttonnum-count; int high = buttonnum+count;
					if(light[low]==light[high]) {
						
						if(light[low]==1)light[high]=light[low]=0;
						else {light[low]=light[high]=1;}
						
					}else {break;}
						count++;
					
				}
			}
			
		}
		
	    for(int i=1;i<=N;i++) {
	    	sb.append(light[i]).append(" ");
	    	if(i%20==0)
		    sb.append("\n");
	    	
	    }
		System.out.println(sb);
	}
  }
