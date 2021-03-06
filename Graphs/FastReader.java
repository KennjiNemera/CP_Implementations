package CP_Implementations.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader {
	BufferedReader br;
	StringTokenizer st;
	
	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	String next() throws IOException{
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	
	int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
	
	double nextDouble() throws IOException, NumberFormatException {
		return Double.parseDouble(next());
	}
	
	long nextLong() throws IOException, NumberFormatException{
		return Long.parseLong(next());
	}
	
	String nextLine() {
		String str  = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}