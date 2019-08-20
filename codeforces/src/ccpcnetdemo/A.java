package ccpcnetdemo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {

	static InputReader scan = new InputReader(new BufferedInputStream(System.in));
	static int n;

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int size = scan.nextInt();
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < size; j++) {
				set.add(scan.nextInt());
			}
			for (int j = 0; j < size + 1; j++) {
				if (!set.contains(j)) {
					sb.append(j + "\n");
					break;
				}
			}

		}
		System.out.println(sb);
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
