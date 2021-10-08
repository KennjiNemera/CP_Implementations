package Range_Queries;

import java.io.*;

public class SegmentTree {

	static int len;
	static int tree[];

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
//		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

		// we will be building a segment tree that will perform a sum query because
		// that's probably the hardest implementation for me

		int n = fr.nextInt();

		len = (int) Math.pow(2, Math.ceil(Math.log10(n) / Math.log10(2)));

		tree = new int[2 * len]; // there will be 2n - 1 elements

		for (int i = 0; i < n; i++) {
			update(i, fr.nextInt());
		}

		// QUERY WITH GET_SUM(a, b) TO FIND THE SUM IN RANGE
	}

	static void update(int pos, int val) {
		pos += len - 1;
		while (pos >= 1) {
			tree[pos] += val;
			pos /= 2;
		}
	}

	static long getSum(int a, int b) {
		a += len;
		b += len;
		long ans = 0;

		// I don't understand this logic for the life of me, but it is short enough to
		// memorize
		while (a <= b) {
			if (a % 2 == 1)
				ans += tree[a++];
			if (b % 2 == 0)
				ans += tree[b--];
			a /= 2;
			b /= 2;
		}

		return ans;
	}

}
