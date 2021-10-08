package CP_Implementations.Graphs;

import java.util.*;
import java.io.*;

public class Djikstra {
	
	static ArrayList<ArrayList<Pair>> adj;
	static int n, m;
	static boolean[] vis;

	public static void main(String[] args) throws IOException{
		
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
		
		n = fr.nextInt();
		m = fr.nextInt();
		vis = new boolean[n];
		
		adj = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		
		int[] dist = new int[n];
		
		Arrays.fill(dist, (int) Math.pow(10, 9));
		
		for (int i = 0; i < m; i++) {
			int a = fr.nextInt()-1;
			int b = fr.nextInt()-1;
			int w = fr.nextInt();
			
			adj.get(a).add(new Pair(b,w));	
		}
		
		// SHORTEST PATH FROM 1 -> N
		dist[0] = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
		
		pq.offer(new Pair(0, 0));
		
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if (vis[p.a]) continue;
			
			vis[p.a] = true;
			
			for (Pair pair : adj.get(p.a)) {
				if (dist[p.a] + pair.w < dist[pair.a]) {
					dist[pair.a] = dist[p.a] + pair.w;
					pq.offer(new Pair(pair.a, dist[pair.a]));
				}
			}	
		}
		
		pr.println("Final Dist: " + dist[n-1]);
		pr.close();		

	}
	
	static class Pair {
		int a, w;
		public Pair(int a, int w) {
			this.a = a;
			this.w = w;
		}
	}
}
