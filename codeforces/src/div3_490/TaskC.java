package div3_490;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TaskC {

	static class Node {
		int times;
		ArrayList<Integer> index;
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		String ss = sc.next();
		HashMap<Character, Node> map = new HashMap<Character, Node>();
		boolean[] flag = new boolean[n];
		char tmp;
		Node node;
		for (int i = 0; i < ss.length(); i++) {
			tmp = ss.charAt(i);
			if (map.containsKey(tmp)) {
				map.get(tmp).times++;
				map.get(tmp).index.add(i);
			} else {
				node = new Node();
				node.index = new ArrayList<Integer>();
				node.times = 1;
				node.index.add(i);
				map.put(tmp, node);
			}
		}
		for (int i = 0; i < k; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				j = (char) j;
				if (map.containsKey(j)) {
					flag[map.get(j).index.get(map.get(j).index.size() - map.get(j).times)] = true;
					map.get(j).times--;
					if (map.get(j).times == 0) {
						map.remove(j);
					}
					break;
				}
			}
		}
		for (int i = 0; i < ss.length(); i++) {
			if (!flag[i]) {
				System.out.print(ss.charAt(i));
			}
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
