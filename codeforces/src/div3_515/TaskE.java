package div3_515;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskE {
	static InputReader sc = new InputReader(new BufferedInputStream(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) {
		int aLen = sc.nextInt();
		int bLen = sc.nextInt();
		String a = sc.next();
		String b = sc.next();
		long MOD = 998244353;
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		int count = 0;
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '1') {
				count++;
			}
		}
		long res = 0;
		for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
			if (a.charAt(i) == '1') {
				res += fastPow(2, i, MOD) % MOD * count % MOD;
			}
			if (b.charAt(i) == '1') {
				count--;
			}
		}
		System.out.println(res % MOD);
	}

	public static long fastPow(long a, long b, long MOD) {
		long ans = 1;
		long base = a;
		for (; b != 0;) {
			if ((b & 1) == 1) {
				ans = (ans * base) % MOD;
			}
			base = (base % MOD) * (base % MOD) % MOD;
			b = b >> 1;
		}
		return ans;
	}

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

	}
}
