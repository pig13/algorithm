package div3_494;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskB {

	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();
		String out;
		if (a > b) {
			out = "01";
		} else {
			out = "10";
		}
		for (int i = 0; i < x / 2; i++) {
			System.out.print(out);
			a--;
			b--;
		}
		if (x % 2 == 0) {
			if (a > b) {
				for (int i = 0; i < b; i++) {
					System.out.print('1');
				}
				for (int i = 0; i < a; i++) {
					System.out.print('0');
				}
			} else {
				for (int i = 0; i < a; i++) {
					System.out.print('0');
				}
				for (int i = 0; i < b; i++) {
					System.out.print('1');
				}
			}
		} else {
			if (a > b) {
				for (int i = 0; i < a; i++) {
					System.out.print('0');
				}
				for (int i = 0; i < b; i++) {
					System.out.print('1');
				}

			} else {
				for (int i = 0; i < b; i++) {
					System.out.print('1');
				}
				for (int i = 0; i < a; i++) {
					System.out.print('0');
				}
			}
		}

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
