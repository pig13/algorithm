package div3_498;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TaskD {
	public static void main(String[] args) {
		int n = sc.nextInt();
		String ss = sc.next();
		String tt = sc.next();
		int count = 0;
		if (n % 2 != 0) {
			if (ss.charAt(n / 2) != tt.charAt(n / 2)) {
				count++;
			}
		}
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < n / 2; i++) {
			set.clear();
			set.add(tt.charAt(i));
			set.add(tt.charAt(n - i - 1));
			if (set.size() == 1) {
				if (ss.charAt(i) != ss.charAt(n - i - 1)) {
					count++;
				}
			} else {
				if (set.contains(ss.charAt(i)) && set.contains(ss.charAt(n - i - 1))
						&& ss.charAt(i) != ss.charAt(n - i - 1)) {

				} else if (set.contains(ss.charAt(i)) || set.contains(ss.charAt(n - i - 1))) {
					count++;
				} else {
					count += 2;
				}
			}
		}
		System.out.println(count);

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
