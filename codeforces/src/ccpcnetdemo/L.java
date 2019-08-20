package ccpcnetdemo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L {

	static InputReader scan = new InputReader(new BufferedInputStream(System.in));
	static int n;

	public static void main(String[] args) {
		n = scan.nextInt();
		int in = 0;
		int out = 0;
		for (int i = 0; i < n; i++) {
			int temp = scan.nextInt();
			if (temp < 0) {
				out = out + temp;
			} else {
				in = in + temp;
			}
		}
		int result = in + out;
		if (result > 0) {
			System.out.println("icebound is happy.");
		} else if (result == 0) {
			System.out.println("icebound is ok.");
		} else if(result<0){
			System.out.println("icebound is sad.");
		}

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
