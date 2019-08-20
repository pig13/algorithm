package ccpcnetdemo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F {

	static InputReader scan = new InputReader(new BufferedInputStream(System.in));
	static int n, m, inf = Integer.MAX_VALUE - 5;// ���
	static int[][] map;

	public static void main(String[] args) {

		n = scan.nextInt();
		m = scan.nextInt();
		map = new int[n + 2][m + 2];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = inf;
			}
		}
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				int temp = scan.nextInt();
				if (temp == 1) {
					map[i][j] = 0;
				}
			}
		}
		for (; fun();) {
		}

		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean fun() {
		boolean flag = false;

		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				if (check(i, j)) {
					int temp = map[i][j];
					map[i][j] = Math.min(temp, Math.min(Math.min(map[i - 1][j] + 1, map[i + 1][j] + 1),
							Math.min(map[i][j - 1] + 1, map[i][j + 1] + 1)));
					if (temp != map[i][j]) {
						flag = true;
					}
				}
			}
		}

		return flag;
	}

	static boolean check(int i, int j) {
		boolean flag = false;
		if (map[i - 1][j] != inf || map[i + 1][j] != inf || map[i][j - 1] != inf || map[i][j + 1] != inf) {
			flag = true;
		}
		return flag;
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
