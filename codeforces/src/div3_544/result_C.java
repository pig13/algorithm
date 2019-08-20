package div3_544;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class result_C {

	static InputReader scan = new InputReader(new BufferedInputStream(System.in));
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int temp = scan.nextInt();
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		int max = 0;
		for (Integer i : map.keySet()) {
			int temp = fun(i);
			if (max < temp) {
				max = temp;
			}
		}
		System.out.println(max);
	}

	static int fun(int i) {
		int count = 0;
		if (map.containsKey(i)) {
			count = count + map.get(i);
		}
		if (map.containsKey(i + 1)) {
			count = count + map.get(i + 1);
		}
		if (map.containsKey(i + 2)) {
			count = count + map.get(i + 2);
		}
		if (map.containsKey(i + 3)) {
			count = count + map.get(i + 3);
		}
		if (map.containsKey(i + 4)) {
			count = count + map.get(i + 4);
		}
		if (map.containsKey(i + 5)) {
			count = count + map.get(i + 5);
		}
		return count;
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
