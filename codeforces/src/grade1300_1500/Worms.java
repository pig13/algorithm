package grade1300_1500;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Worms {

	static class Node {
		int index;
		int value;
	}

	static class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.value - o2.value;
		}
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[][] sec = new int[n][2];
		sec[0][0] = 1;
		sec[0][1] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sec[i][0] = sec[i - 1][1] + 1;
			sec[i][1] = sec[i - 1][1] + arr[i];
		}

		int m = sc.nextInt();
		ArrayList<Node> list = new ArrayList<Node>();
		Node node;
		for (int i = 0; i < m; i++) {
			node = new Node();
			node.index = i;
			node.value = sc.nextInt();
			list.add(node);
		}
		list.sort(new NodeComparator());
		int[] res = new int[m];
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			for (; index < sec.length; index++) {
				if (list.get(i).value >= sec[index][0] && list.get(i).value <= sec[index][1]) {
					res[list.get(i).index] = index + 1;
					break;
				}
			}
		}
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
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
