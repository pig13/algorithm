package grade1300_1500;

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

public class TPrimes {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 2; i < 1000000; i++) {
			if (isPrime(i)) {
				set.add(i);
			}
		}
		int n = sc.nextInt();
		long tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextLong();
			if (Math.sqrt(tmp) == (int) Math.sqrt(tmp) && set.contains((int) (Math.sqrt(tmp)))) {
				pw.append("YES\n");
			} else {
				pw.append("NO\n");
			}
		}
		pw.flush();

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

	public static boolean isPrime(int n) {
		for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;

	}

}
