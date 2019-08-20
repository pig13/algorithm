package div3_544;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class result_D {

	static InputReader scan = new InputReader(new BufferedInputStream(System.in));
	static Map<BigDecimal, Integer> map = new HashMap<>();
	static ArrayList<BigDecimal> list = new ArrayList<>();
	static int n = 0;

	public static void main(String[] args) {
		n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(new BigDecimal(scan.next()));
		}
		map.put(BigDecimal.ZERO, 0);
		int mustzero = 0;
		for (int i = 0; i < n; i++) {
			BigDecimal in = new BigDecimal(scan.nextInt());
			if (list.get(i).equals(BigDecimal.ZERO) || in.equals(BigDecimal.ZERO)) {
				if (list.get(i).equals(BigDecimal.ZERO) && in.equals(BigDecimal.ZERO)) {
					map.put(BigDecimal.ZERO, map.get(BigDecimal.ZERO) + 1);
				} else if (in.equals(BigDecimal.ZERO)) {
					mustzero++;
				}
			} else {
				BigDecimal temp = list.get(i).divide(in, 19, BigDecimal.ROUND_HALF_DOWN);
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
				} else {
					map.put(temp, 1);
				}
			}
		}
		int max = 0;
		for (BigDecimal bigint : map.keySet()) {
			int temp = map.get(bigint);
			if (!bigint.equals(BigDecimal.ZERO)) {
				temp = temp + map.get(BigDecimal.ZERO);
			} else {
				temp = temp + mustzero;
			}
			if (temp > max) {
				max = temp;
			}
		}
		System.out.println(max);

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
