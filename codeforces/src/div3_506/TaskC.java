package div3_506;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskC {
	static InputReader sc = new InputReader(new BufferedInputStream(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) {
		// 这种算法实现太慢了。。。
		int n = sc.nextInt();
		int[] left = new int[n];
		int[] right = new int[n];
		for (int i = 0; i < right.length; i++) {
			left[i] = sc.nextInt();
			right[i] = sc.nextInt();
		}
		int[][] ll = new int[n][2];
		int[][] rr = new int[n][2];
		ll[0][0] = left[0];
		ll[0][1] = right[0];
		for (int i = 1; i < ll.length; i++) {
			if (ll[i - 1][0] == -1 && ll[i - 1][1] == -1) {
				// 空集
				ll[i][0] = -1;
				ll[i][1] = -1;
			} else if (ll[i - 1][1] < left[i] || right[i] < ll[i - 1][0]) {
				// 空集
				ll[i][0] = -1;
				ll[i][1] = -1;
			} else {
				// 交集
				ll[i][0] = Math.max(left[i], ll[i - 1][0]);
				ll[i][1] = Math.min(right[i], ll[i - 1][1]);
			}
		}
		rr[n - 1][0] = left[n - 1];
		rr[n - 1][1] = right[n - 1];
		for (int i = rr.length - 2; i >= 0; i--) {
			if (rr[i + 1][0] == -1 && rr[i + 1][1] == -1) {
				// 空集
				rr[i][0] = -1;
				rr[i][1] = -1;
			} else if (rr[i + 1][1] < left[i] || right[i] < rr[i + 1][0]) {
				// 空集
				rr[i][0] = -1;
				rr[i][1] = -1;
			} else {
				// 交集
				rr[i][0] = Math.max(left[i], rr[i + 1][0]);
				rr[i][1] = Math.min(right[i], rr[i + 1][1]);
			}
		}
		int max = Integer.MIN_VALUE;
		int cur;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				cur = rr[1][1] - rr[1][0];
			} else if (i == n - 1) {
				cur = ll[n - 2][1] - ll[n - 2][0];
			} else {
				if (ll[i - 1][1] < rr[i + 1][0] || rr[i + 1][1] < ll[i - 1][0]) {
					cur = 0;
				} else {
					cur = Math.min(ll[i - 1][1], rr[i + 1][1]) - Math.max(ll[i - 1][0], rr[i + 1][0]);
				}
			}
			max = cur > max ? cur : max;
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
