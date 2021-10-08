package CP_Implementations.Graphs;

import java.util.*;
import java.io.*;

public class Bellman_Ford {
	
	static ArrayList<Tuple> edges;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// IO Routine
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = fr.nextInt(), m = fr.nextInt();
		
		int[] arr = new int[n+1];
		
		edges = new ArrayList<Tuple>();
		
		Arrays.fill(arr, (int)Math.pow(10,9));
		
		for (int i = 0; i < m; i++) {
			int a = fr.nextInt();
			int b = fr.nextInt();
			int w = fr.nextInt();
			
			edges.add(new Tuple(a, b, w));
		}
		
		arr[1] = 0;
		
		// we start at node 1!
		
		boolean changed = false;
		
		for (int i = 0; i < n-1; i++) {
			changed = false;
			for (Tuple edge : edges) {
				if (arr[edge.a] + edge.w < arr[edge.b]) {
					changed = true;
					arr[edge.b] = arr[edge.a] + edge.w;
				}
			}
			if (!changed) break;
		}
		
		if (changed) {
			pr.println("THERE IS A CYCLE");
		} else {
			pr.println(arr[n-1]);
		}
		
		pr.close();	
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
