package luogu;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1567 {
	public static void main(String[] args) {
		InputReader sc = new InputReader(new BufferedInputStream(System.in));
		int max = 1;
		int cur = 1;
		int num = sc.nextInt();
		int pre = sc.nextInt();
		int bef = 0;
		for (int i = 0; i < num - 1; i++) {
			bef = sc.nextInt();
			if (bef > pre) {
				cur++;
				max = max < cur ? cur : max;
			} else {
				cur = 1;
			}
			pre = bef;
		}
		System.out.println(max);
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
