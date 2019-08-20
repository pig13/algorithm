package div3_555;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TaskB {
	public static void main(String[] args) {
		int n = sc.nextInt();
		String ss = sc.next().trim();
		int[] arr = new int[10];
		for (int i = 1; i <= 9; i++) {
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < ss.length(); i++) {
			list.add(new Integer(ss.substring(i, i + 1)));
		}
		for (int i = 0; i < list.size(); i++) {
			if (arr[list.get(i)] > (int) list.get(i)) {
				for (; i < list.size() && arr[list.get(i)] >= (int) list.get(i);) {
					list.set(i, arr[list.get(i)]);
					i++;
				}
				break;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
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
