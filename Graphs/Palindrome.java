package Graphs;

import java.util.*;
import java.io.*;

public class Palindrome {
	public static void main(String[] args) throws IOException {

		FastRead fr;

		PrintWriter pr;

		for (int i = 1; i <= 2; i++) {
			String filename;
			String outputname;

			if (i < 10) {
				filename = "input_0" + i + ".txt";
				outputname = "output_0" + i + ".txt";
			} else {
				filename = "input_" + i + ".txt";
				outputname = "output_" + i + ".txt";
			}

			fr = new FastRead(filename);
			pr = new PrintWriter(new FileWriter(outputname));

			String str = fr.nextLine();

			if (isPalindrome(str)) {
				pr.println("palindrome");
			} else
				pr.println("not a palindrome");

			pr.close();
		}

	}

	static boolean isPalindrome(String str) {
		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1))
				return false;
		}
		return true;
	}
}

class FastRead {
	BufferedReader br;
	StringTokenizer st;

	public FastRead(String filename) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(filename));
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
