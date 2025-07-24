import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      
       
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	
        	int H=Integer.parseInt(st.nextToken());
        	int W=Integer.parseInt(st.nextToken());
        	int N=Integer.parseInt(st.nextToken());
        	int M=Integer.parseInt(st.nextToken());
        	
        	long findhash=0;
            long offset=1;
        	for(int i=0;i<H;i++) {
        		long hash=0;
        		String str=br.readLine();
        		for(int k=0;k<W;k++) {
        			hash=hash*3+change(str.charAt(k));
        		}
        		findhash=findhash*37+hash;
        	}
        	
        	
        	long[][] hash=new long[N][M-W+1];
        
        	for(int i=0;i<N;i++) {
        		String str=br.readLine();
        		long rowhash =0;
        		offset=1;
        		for(int k=0;k<W;k++) {
        			rowhash=rowhash*3+change(str.charAt(k));
        			if(k==W-1)continue;
        			offset*=3;
        		}
        		hash[i][0]=rowhash;
        		int idx=1;
        		while(idx<=M-W) {
        			hash[i][idx]=(hash[i][idx-1]-change(str.charAt(idx-1))*offset)*3+change(str.charAt(W-1+idx));
        			idx++;
        		}
        		
        	}
        	
        	int cnt=0;
        	for(int i=0;i<=M-W;i++) {
        		long realhash=0;
        		offset=1;
        		for(int k=0;k<H;k++) {
        			realhash=realhash*37+hash[k][i];
        			if(k==H-1)continue;
        			offset*=37;
        		}
        		if(realhash==findhash) cnt++;
        		int idx=1;
        		while(idx<=N-H) {
        			realhash=(realhash-hash[idx-1][i]*offset)*37+hash[H-1+idx][i];
        			if(realhash==findhash)cnt++;
        			idx++;
        		}
        		
        		
        	}
        	System.out.println(cnt);
        
        
	}
	public static int change(char a) {
		if(a=='o') {
			return 2;
		}else {
			return 1;
		}
	}
}