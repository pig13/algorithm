package div3_547;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class result_D {

	static InputReader scan = new InputReader(new BufferedInputStream(System.in));
	static StringBuffer sb = new StringBuffer();
	static int count = 0, n = 0;
	static LinkedList<Integer>[] left = new LinkedList[27], right = new LinkedList[27];

	public static void main(String[] args) {
		n = scan.nextInt();
		char[] l = scan.next().toCharArray();
		char[] r = scan.next().toCharArray();
		for (int i = 0; i < 27; i++) {
			left[i] = new LinkedList<>();
			right[i] = new LinkedList<>();
		}
		for (int i = 0; i < l.length; i++) {
			if (l[i] == '?') {
				left[26].add(i);
			} else {
				left[l[i] - 97].add(i);
			}
			if (r[i] == '?') {
				right[26].add(i);
			} else {
				right[r[i] - 97].add(i);
			}
		}
		for (int i = 0; i < 26; i++) {
			fun(i);
		}
		LinkedList<Integer> lastleft = new LinkedList<>();
		LinkedList<Integer> lastright = new LinkedList<>();
		for (int i = 0; i < 26; i++) {
			lastleft.addAll(left[i]);
			lastright.addAll(right[i]);
		}
		int len = n - count;
		if (left[26].size() + right[26].size() > len) {
			count = n;
			lastleft.addAll(left[26]);
			lastright.addAll(right[26]);
			for(;!lastleft.isEmpty();) {
				sb.append((lastleft.removeFirst()+1)+" "+(lastright.removeLast()+1)+"\n");
			}
			
		} else {
			count = count + left[26].size() + right[26].size();
			for (; !right[26].isEmpty();) {
				sb.append((lastleft.removeFirst() + 1) + " " + (right[26].removeFirst() + 1+"\n"));
			}
			for (; !left[26].isEmpty();) {
				sb.append((left[26].removeFirst() + 1) + " " + (lastright.removeFirst() + 1)+"\n");
			}

		}

		System.out.println(count);
		System.out.println(sb);
	}

	static void fun(int n) {
		LinkedList<Integer> l = left[n];
		LinkedList<Integer> r = right[n];
		for (; !l.isEmpty() && !r.isEmpty();) {
			sb.append((l.removeFirst() + 1) + " " + (r.removeFirst() + 1)+"\n");
			count++;
		}
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
