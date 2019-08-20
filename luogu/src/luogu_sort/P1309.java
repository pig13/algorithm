package luogu_sort;

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

public class P1309 {
	static InputReader sc = new InputReader(new BufferedInputStream(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	static ArrayList<person> list;
	static ArrayList<person> l1;
	static ArrayList<person> l2;
	static int n;

//	pw.flush();
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		n = sc.nextInt();
		int r = sc.nextInt();
		int q = sc.nextInt();
		person p;
		list = new ArrayList<person>(2 * n);
		l1 = new ArrayList<person>(n);
		l2 = new ArrayList<person>(n);
		for (int i = 1; i <= 2 * n; i++) {
			p = new person();
			list.add(p);
			p.id = i;
			p.grade = sc.nextInt();

		}
		for (int i = 0; i < 2 * n; i++) {
			list.get(i).power = sc.nextInt();
		}
		list.sort(new PersonComparator());
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < 2 * n; j += 2) {
				if (list.get(j).power > list.get(j + 1).power) {
					list.get(j).grade += 1;
					l1.add(list.get(j));
					l2.add(list.get(j + 1));
				} else {
					list.get(j + 1).grade += 1;
					l1.add(list.get(j + 1));
					l2.add(list.get(j));
				}
			}
			sort();
			l1.clear();
			l2.clear();

		}
		System.out.println(list.get(q - 1).id);
//		System.out.println(System.currentTimeMillis() - time);

	}

	public static void sort() {
		int l1Index = 0;
		int l2Index = 0;
		int listIndex = 0;
		for (; l1Index < n && l2Index < n;) {
			if (l1.get(l1Index).grade > l2.get(l2Index).grade) {
				list.set(listIndex, l1.get(l1Index));
				l1Index++;
			} else if (l1.get(l1Index).grade < l2.get(l2Index).grade) {
				list.set(listIndex, l2.get(l2Index));
				l2Index++;
			} else {
				if (l1.get(l1Index).id < l2.get(l2Index).id) {
					list.set(listIndex, l1.get(l1Index));
					l1Index++;
				} else {
					list.set(listIndex, l2.get(l2Index));
					l2Index++;
				}
			}
			listIndex++;
		}
		for (int i = l1Index; i < n; i++) {
			list.set(listIndex, l1.get(l1Index));
			l1Index++;
			listIndex++;
		}
		for (int i = l2Index; i < n; i++) {
			list.set(listIndex, l2.get(l2Index));
			l2Index++;
			listIndex++;
		}
	}

	static class person {
		int id;
		int grade;
		int power;

		@Override
		public String toString() {
			return "" + this.id + ":" + this.grade;
		}

	}

	static class PersonComparator implements Comparator<person> {
		@Override
		public int compare(person o1, person o2) {
			int tmp;
			tmp = o2.grade - o1.grade;
			if (tmp == 0) {
				return o1.id - o2.id;
			}
			return tmp;
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
