package div3_544;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class result_B {

	static InputReader scan = new InputReader(new BufferedInputStream(System.in));
	static Map<Integer, Integer> map = new HashMap<>();
	static int k = 0;

	public static void main(String[] args) {
		int n = scan.nextInt();
		k = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int temp = scan.nextInt() % k;
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		int count = 0;
		int data[][] = new int[map.size()][2];
		int j = 0;
		for (Integer i : map.keySet()) {
			data[j][0] = i;
			data[j][1] = map.get(i);
			j++;
		}
		for (int i = 0; i < data.length; i++) {
			int temp = fun(data, i);
			count = count + temp;
		}
		System.out.println(count * 2);
	}

	static int fun(int[][] data, int n) {
		int count = 0;
		for (int i = n; i < data.length; i++) {
			if ((data[n][0] + data[i][0]) % k == 0) {
				if (i == n) {
					count = data[n][1] / 2;
				} else {
					count = Math.min(data[n][1], data[i][1]);
				}
				break;
			}
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
