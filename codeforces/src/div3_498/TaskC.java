package div3_498;

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
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		long sum = 0;
		int left = 0;
		int right = arr.length - 1;
		long lsum = 0;
		long rsum = 0;
		int ll = -1;
		int rr = arr.length;
		for (; left < right;) {
			if (ll != left) {
				lsum += arr[left];
			}
			if (rr != right) {
				rsum += arr[right];
			}
			if (lsum == rsum) {
				sum = lsum > sum ? lsum : sum;
				ll = left;
				rr = right;
				left++;
			} else if (lsum < rsum) {
				ll = left;
				rr = right;
				left++;
			} else {
				ll = left;
				rr = right;
				right--;
			}
		}
		System.out.println(sum);
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
