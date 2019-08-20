package div3_486;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TaskB {

	static class StringComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}
		Arrays.sort(arr, new StringComparator());
		boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (!arr[j].contains(arr[i])) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
		}
		if (flag) {
			System.out.println("YES");
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} else {
			System.out.println("NO");
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
