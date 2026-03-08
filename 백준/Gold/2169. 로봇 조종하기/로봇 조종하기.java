import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.Arrays;

import java.util.Comparator;

import java.util.PriorityQueue;

import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[][] arr;


    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st=new StringTokenizer(br.readLine()) ;

     

        N=Integer.parseInt(st.nextToken());

        int M=Integer.parseInt(st.nextToken());

       arr=new int[N+2][M+2];

        for(int i=1;i<=N;i++) {

        	 st=new StringTokenizer(br.readLine());        	for(int k=1;k<=M;k++) {

        		arr[i][k]=Integer.parseInt(st.nextToken());

        	}

        }

        

        int[][] dist=new int[N+2][M+2];

        dist[1][1]=arr[1][1];

        for(int i=2;i<=M;i++) {

        	dist[1][i]=dist[1][i-1]+arr[1][i];

        }


        int[][] tmp=new int[2][M+2];

        for(int i=2;i<=N;i++) { 
            tmp[0][0]=-Integer.MAX_VALUE/2;
        	tmp[0][1]=dist[i-1][1];

        	for(int k=1;k<=M;k++) 
        		tmp[0][k]=Math.max(dist[i-1][k], tmp[0][k-1])+arr[i][k];

        		

        		tmp[1][M]=dist[i-1][M];
                tmp[1][M+1]=-Integer.MAX_VALUE/2;
        		for(int k=M;k>=1;k--) 

        			tmp[1][k]=Math.max(tmp[1][k+1], dist[i-1][k])+arr[i][k];

        		

        		

        		for(int k=1;k<=M;k++)

        			dist[i][k]=Math.max(tmp[0][k], tmp[1][k]);

        }

        	

 

        System.out.println(dist[N][M]);

    }

}