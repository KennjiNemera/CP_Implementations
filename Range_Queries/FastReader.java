package CP_Implementations.Range_Queries;

import java.util.*;
import java.io.*;

public class FastReader {
	BufferedReader br;
	StringTokenizer st;
	
	public FastReader() throws FileNotFoundException {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	
	int nextInt() {
		return Integer.parseInt(next());
	}
	
	double nextDouble() {
		return Double.parseDouble(next());
	}
	
	long nextLong() {
		return Long.parseLong(next());
	}
	
	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}	
}
