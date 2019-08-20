package div3_486;

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

	static class Node {
		int i; // 第 i个序列
		int j;// 删去 第j个元素
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		Map<Long, Node> map = new HashMap<Long, Node>();
		Node node;
		long sum = 0;
		int m;
		int tmp;
		int[] arr = new int[500000];

		for (int i = 1; i <= n; i++) {
			m = sc.nextInt();
			sum = 0;
			for (int j = 0; j < m; j++) {
				tmp = sc.nextInt();
				arr[j] = tmp;
				sum += tmp;
			}
			for (int j = 0; j < m; j++) {
				if (map.containsKey(sum - arr[j]) && map.get(sum - arr[j]).i != i) {
					System.out.println("YES");
					System.out.println(i + " " + (j + 1));
					System.out.println(map.get(sum - arr[j]).i + " " + map.get(sum - arr[j]).j);
					return;
				}
				node = new Node();
				node.i = i;
				node.j = j + 1;
				map.put(sum - arr[j], node);
			}
		}
		System.out.println("NO");

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
