package div3_515;

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

public class TaskC {
	static InputReader sc = new InputReader(new BufferedInputStream(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) {
		int n = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		sc.next();
		map.put(sc.nextInt(), 0);
		int letf = -1;
		int right = 1;
		String tmpS;
		int tmpI;
		for (int i = 0; i < n - 1; i++) {
			tmpS = sc.next();
			tmpI = sc.nextInt();
			if (tmpS.equals("L")) {
				map.put(tmpI, letf--);
			} else if (tmpS.equals("R")) {
				map.put(tmpI, right++);
			} else {
				int index = map.get(tmpI);
				int tmp = Math.min(Math.abs(letf - index), Math.abs(right - index)) - 1;
				pw.append(tmp + "\n");
			}

		}
		pw.flush();

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
