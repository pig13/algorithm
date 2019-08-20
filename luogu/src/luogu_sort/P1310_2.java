package luogu_sort;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1310_2 {
	static InputReader sc = new InputReader(new BufferedInputStream(System.in));
	static person[] arr;
	static person[] arr1;
	static person[] arr2;
	static int n;

	public static void main(String[] args) {
		n = sc.nextInt();
		int r = sc.nextInt();
		int q = sc.nextInt();
		person p;
		arr = new person[2 * n];
		arr1 = new person[n];
		arr2 = new person[n];
		for (int i = 1; i <= 2 * n; i++) {
			p = new person();
			arr[i - 1] = p;
			p.id = i;
			p.grade = sc.nextInt();

		}
		for (int i = 0; i < 2 * n; i++) {
			arr[i].power = sc.nextInt();
		}
		Arrays.sort(arr, new PersonComparator());
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < 2 * n; j += 2) {
//				01 23 45 67 89
				if (arr[j].power > arr[j + 1].power) {
					arr[j].grade += 1;
					arr1[j / 2] = arr[j];
					arr2[j / 2] = arr[j + 1];
				} else {
					arr[j + 1].grade += 1;
					arr1[j / 2] = arr[j + 1];
					arr2[j / 2] = arr[j];
				}
			}
			sort(); // O(N) TLE
		}
		System.out.println(arr[q - 1].id);
	}

	public static void printArr(person[] arr) {
		String res = "";
		for (int i = 0; i < arr.length; i++) {
			res += arr[i].id + ":" + arr[i].grade + " ";
		}
		System.out.println(res);
	}

	public static void sort() {
		int arrIndex = 0;
		int arr1Index = 0;
		int arr2Index = 0;
		for (; arr1Index < n && arr2Index < n;) {
			if (arr1[arr1Index].grade > arr2[arr2Index].grade) {
				arr[arrIndex++] = arr1[arr1Index++];
			} else if (arr1[arr1Index].grade < arr2[arr2Index].grade) {
				arr[arrIndex++] = arr2[arr2Index++];
			} else {
				if (arr1[arr1Index].id < arr2[arr2Index].id) {
					arr[arrIndex++] = arr1[arr1Index++];
				} else {
					arr[arrIndex++] = arr2[arr2Index++];
				}
			}

		}
		for (int i = arr1Index; i < n; i++) {
			arr[arrIndex++] = arr1[arr1Index++];
		}
		for (int i = arr2Index; i < n; i++) {
			arr[arrIndex++] = arr2[arr2Index++];
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
