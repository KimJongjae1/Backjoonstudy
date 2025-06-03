import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	 public static void main(String[] args) throws IOException{
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());  
			int T=Integer.parseInt(st.nextToken());
			for(int t=1;t<=T;t++) {
				
				st=new StringTokenizer(br.readLine()); 
				int N=Integer.parseInt(st.nextToken());
				int P=Integer.parseInt(st.nextToken());
				
				
				st=new StringTokenizer(br.readLine()); 
				if(N==1) {
					System.out.println("#"+t+" "+(P+1));
					continue;
				}
	
				int[] day=new int[N];
				for(int i=0;i<N;i++) {
					day[i]=Integer.parseInt(st.nextToken());
					
				}
					
				
				int result=0;
				for(int i=0;i<N;i++) {
					int start=i;
					int end=N-1;
					while(start<=end) {
						int mid=(start+end)/2;
						int range=mid-i;
						if(day[mid]-day[i]-range<=P) {
							start=mid+1;
						}else {
							end=mid-1;
						}
					}
					result=Math.max(result,start-i+P);
					
				}
					
				System.out.println("#"+t+" "+result);
					
				}
				
			
				
			}
	 }
