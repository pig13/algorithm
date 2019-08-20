package grade1300_1500;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TwoSubstrings {
	public static void main(String[] args) {
		String ss = sc.next();
		if (ss.contains("AB")) {
			String ss2 = ss.replaceFirst("AB", " ");
			String ss3 = new StringBuilder(ss).reverse().toString();
			ss3 = ss3.replaceFirst("BA", " ");
			if (ss2.contains("BA") || ss3.contains("AB")) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	static InputReader sc = new InputReader(new BufferedInputStream(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
//	out.flush();

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

	}
}
