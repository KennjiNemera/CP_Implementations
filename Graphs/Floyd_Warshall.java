package Graphs;

import java.io.*;
import java.util.*;

public class Floyd_Warshall {
	
	static int[][] adj;
	public static void main(String[] args) throws IOException {
		// WHY WOULD I NEED THIS STRUCTURE
		
		/*
		 
		  If we are queried to find the shortest path between any 
		  two nodes!
		 
		 */
		
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = fr.nextInt();
		int m = fr.nextInt();
		int q = fr.nextInt();
		
		adj = new int[n][n];
		
		int inf = (int) Math.pow(10, 9);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;		
				adj[i][j] = inf; 
			}
		}
		
		for (int i = 0; i < m; i++) {
			int a = fr.nextInt()-1;
			int b = fr.nextInt()-1;
			int w = fr.nextInt();
			
			adj[a][b] = w;
			adj[b][a] = w;
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[k][j] + adj[i][k]);
				}
			}
		}
		
		while (q-- > 0) {
			int a = fr.nextInt()-1;
			int b = fr.nextInt()-1;
			
			if (adj[a][b] == inf) {
				pr.println(-1);
			} else pr.println(adj[a][b]);
		}
		
		pr.close();		
	}
}
