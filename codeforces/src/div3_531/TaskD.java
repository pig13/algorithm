package div3_531;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class TaskD {
	static InputReader sc = new InputReader(new BufferedInputStream(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	static class Node {
		LinkedList<Integer> index = new LinkedList<Integer>();
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		String str = sc.next();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.substring(i, i + 1));
		}
		int zero = 0;
		int one = 0;
		int two = 0;
		int mid = n / 3;
		Map<String, Node> map = new HashMap<String, Node>();
		map.put("0", new Node());
		map.put("1", new Node());
		map.put("2", new Node());
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("0")) {
				zero++;
				map.get("0").index.add(i);
			} else if (list.get(i).equals("1")) {
				one++;
				map.get("1").index.add(i);
			} else {
				two++;
				map.get("2").index.add(i);
			}
		}
		int index;
		if (zero < mid) {
			for (int i = zero; i < mid; i++) {
				if (two > one) {
					index = map.get("2").index.removeFirst();
					list.set(index, "0");
					zero++;
					two--;
				} else {
					index = map.get("1").index.removeFirst();
					list.set(index, "0");
					zero++;
					one--;
				}
			}
		}
		if (two < mid) {
			for (int i = two; i < mid; i++) {
				if (one > zero) {
					index = map.get("1").index.removeLast();
					list.set(index, "2");
					two++;
					one--;
				} else {
					index = map.get("0").index.removeLast();
					list.set(index, "2");
					zero--;
					two++;
				}
			}
		}
		if (one < mid) {
			for (int i = one; i < mid; i++) {
				if (two > zero) {
					index = map.get("2").index.removeFirst();
					list.set(index, "1");
					one++;
					two--;
				} else {
					index = map.get("0").index.removeLast();
					list.set(index, "1");
					zero--;
					one++;
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			pw.append(list.get(i));
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
