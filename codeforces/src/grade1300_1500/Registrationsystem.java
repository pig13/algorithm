package grade1300_1500;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Registrationsystem {

	public static void main(String[] args) {
		int n = sc.nextInt();
		Map<String, Integer> map = new HashMap<String, Integer>();
		String tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.next();
			if (map.containsKey(tmp)) {
				pw.append(tmp + map.get(tmp) + "\n");
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
				pw.append("OK\n");
			}
		}
		pw.flush();
		
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
