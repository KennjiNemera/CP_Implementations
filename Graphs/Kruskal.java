package CP_Implementations.Graphs;

import java.io.*;
import java.util.*;

public class Kruskal {
	
	static ArrayList<Tuple> edges;
	static int[] link, size;

	public static void main(String[] args) throws IOException {
		
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = fr.nextInt();
		int m = fr.nextInt();
		
		edges = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();
			edges.add(new Tuple(a,b,c));
		}
		
		Collections.sort(edges, (a,b) -> a.w - b.w);
		
		// UNION FIND IMPLEMENTATION
		
		size = new int[n];
		link = new int[n];
		
		for (int i = 0; i < n; i++) {
			link[i] = i;
			size[i] = 1;
		}
		
		int ans = 0;
		for (Tuple edge : edges) {
			int a = edge.a;
			int b = edge.b;
			if (!same(a, b)) {
				unite(a, b);
				ans += edge.w;
			}
		}
		
		pr.println("Minimum cost: " + ans);
		pr.close();
	}
	
	// UNION FIND MUST INCLUDE:
	/*
	 * SAME(integer a, integer b)
	 * FIND(integer x)
	 * SWAP(integer a, integer b)
	 * 
	 * UNITE(integer a, integer b)
	*/
	
	static boolean same(int a, int b) {
		return find(a) == find(b);
	}
	
	static void unite(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if (size[x] > size[y]) {
			size[x] += size[y];
			link[y] = x;
		} else {
			size[y] += size[x];
			link[x] = y;
		}
	}
	
	static int find(int x) {
		while (x != link[x]) x = link[x];
		return x;
	}
	
	static class Tuple {
		int a, b, w;
		
		public Tuple(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}

}
