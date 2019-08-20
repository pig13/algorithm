package div3_486;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TaskA {

	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
			if (!map.containsKey(tmp)) {
				map.put(tmp, i + 1);
			}
		}
		if (map.size() < k) {
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
		int[] arr = new int[k];
		for (Integer i : map.keySet()) {
			if (k == 0) {
				break;
			}
			arr[arr.length - k] = map.get(i);
			k--;
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
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
