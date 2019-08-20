package div3_494;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TaskD {
	static class Node {
		int value;
		int times;
	}

	static class comparator implements Comparator<Long> {
		@Override
		public int compare(Long o1, Long o2) {
			return (int) (o2 - o1);
		}
	}

	public static void main(String[] args) {
		Map<Long, Integer> map = new TreeMap<Long, Integer>(new comparator());
		int n = sc.nextInt();
		int q = sc.nextInt();
		long tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextLong();
			if (map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
			}
		}
		for (int i = 0; i < q; i++) {
			tmp = sc.nextLong();
			int ans = 0;
			int times = 0;
			for (long j = 1 << 30; j >= 1; j /= 2) {
				if (map.containsKey(j)) {
					times = (int) Math.min(map.get(j), tmp / j);
				} else {
					times = 0;
				}
				ans += times;
				tmp -= times * j;
			}
			if (tmp != 0) {
				ans = -1;
			}
			pw.append(ans + "\n");
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
