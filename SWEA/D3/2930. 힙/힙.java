import java.io.*;
import java.util.*;

public class Solution {
    static int[] heap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 빠르게 받기

        int T = Integer.parseInt(br.readLine()); 
        for (int t = 1; t <= T; t++) {
        	StringBuilder sb=new StringBuilder();
        	int N=Integer.parseInt(br.readLine());
        	heap=new int[N+1];
        	int size=0;
        	for(int i=0;i<N;i++) {
        		StringTokenizer st=new StringTokenizer(br.readLine());
        		int order=Integer.parseInt(st.nextToken());
        		
        		if(order==1) {
        		  int num=Integer.parseInt(st.nextToken());
        		  heap[++size]=num;
        		  int idx=size;
        		  int parent=idx/2;
        		  if(parent>0) {
        			  while(parent>0) {
        				  if(heap[parent]<heap[idx]) {
        					  swap(parent,idx);
        					  idx=parent;
        					  parent/=2;
        				  }else {
        					  break;
        				  }
        			  }
        		  }
        		  
        		}else {
        			if(size==0) {
        				sb.append(-1).append(" ");
        				continue;
        			}
        			else sb.append(heap[1]).append(" ");
        			
        			int idx=1;
        			heap[1]=heap[size];
        			size--;
        			
        			while(idx*2<=size) {
        				int left= idx*2;
                        int right=idx*2+1;
                        int large=left;
                        
                        if(right<=size&&heap[right]>heap[left]) {
                        	large=right;
                        }
        				
                        if(heap[idx]>=heap[large]) break;
        				
                        swap(idx,large);
                        idx=large;
        				
        			}
        				
        			
        		}
        		
        	}
        	
        	System.out.println("#"+t+" "+sb);
        }
    }
    static void swap(int a,int b) {
    	heap[0]=heap[a];
    	heap[a]=heap[b];
    	heap[b]=heap[0];
    }
    
}