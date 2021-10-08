package CP_Implementations.Range_Queries;

import java.io.*;

public class LazySegmentTree {
	
	static Pair[] arr;
	static int len;

	public static void main(String[] args) throws IOException {
		
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = fr.nextInt();
		int q = fr.nextInt();
		
		len = (int) Math.pow(2, Math.ceil(Math.log10(n) / Math.log10(2)));
		
		arr = new Pair[2 * len];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Pair(0,0);
		}
		
		for (int i = 1; i <= n; i++) {
			int val = fr.nextInt();
			summate(i, val);
		}
		
		while (q-- > 0) {
			int a = fr.nextInt() + len;
			int b = fr.nextInt() + len;
			int add = fr.nextInt();
			
			update(1, 1, 2*len-1, a, b, add);
		}
		
		for (Pair p : arr) {
			pr.println(p.toString());
		}
		
		pr.close();		
	}
	
	// UPDATE FUNCTION -> (currentIndex, curLeft, curRight, rangeLeft , rangeRight, value)
	
	static void update(int v, int rl, int rr, int l, int r, int add) {
		if (l > r) return;
		
		if (rl == l && rr == r) {
			arr[v].y += add;
		} else {
			int rm = (rl + rr) / 2;
			update(v*2,rl,rm, l, Math.min(r, rm), add);
			update(v*2+1,rm+1,rr, Math.max(l, rm + 1), r, add);
		}		
	}
	
	static void summate(int x, int val) {
		x += len;
		while (x >= 1) {
			arr[x].x += val;
			x /= 2;
		}
	}
	
	static class Pair {
		int x, y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return x + " " + y;	
		}
	}

}
