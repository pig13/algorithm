package div3_531;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class TaskE {
	static InputReader sc = new InputReader(new BufferedInputStream(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	static class Node {
		int start;
		int end;

	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		Map<Long, Node> map = new LinkedHashMap<Long, Node>();
		Node node;
		long tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextLong();
			if (map.containsKey(tmp)) {
				map.get(tmp).end = i;
			} else {
				node = new Node();
				node.start = i;
				node.end = i;
				map.put(tmp, node);
			}
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (Map.Entry<Long, Node> item : map.entrySet()) {
			if (!list.isEmpty() && list.getLast() >= item.getValue().start) {
				list.addLast(Math.max(item.getValue().end, list.removeLast()));
			} else {
				list.add(item.getValue().end);
			}
		}
		System.out.println(new BigInteger("2").pow(list.size()).divide(new BigInteger("2"))
				.mod(new BigInteger("998244353")).toString());

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

		public long nextLong() {
			return Long.parseLong(next());
		}

	}
}
