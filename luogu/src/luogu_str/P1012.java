package luogu_str;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1012 {

	static class comparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			
			return (o2+o1).compareTo(o1+o2);

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr, new comparator());
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);

		}

	}
}
