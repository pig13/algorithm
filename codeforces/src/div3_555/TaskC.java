package div3_555;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskC {
	public static void main(String[] args) {
		StringBuilder pw = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int l = 0;
		int r = n - 1;
		int pre = Integer.MIN_VALUE;
		int count = 0;
		for (; l <= r;) {
			if (arr[l] > pre && arr[r] > pre) {
				if (arr[l] < arr[r]) {
					pre = arr[l];
					l++;
					pw.append("L");
				} else {
					pre = arr[r];
					r--;
					pw.append("R");
				}
			} else if (arr[l] > pre) {
				pre = arr[l];
				l++;
				pw.append("L");
			} else if (arr[r] > pre) {
				pre = arr[r];
				r--;
				pw.append("R");
			} else {
				break;
			}
			count++;
		}
		System.out.println(count);
		System.out.println(pw.toString());
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
