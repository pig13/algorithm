package div3_506;

import java.util.Scanner;

public class TaskA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String ss = sc.next();
		if (n == 1) {
			for (int i = 0; i < k; i++) {
				System.out.print(ss);
			}
			return;
		}
		if (k == 1) {
			System.out.println(ss);
			return;
		}
		int index = ss.length() - 1;
		for (int i = index; i > 0; i--) {
			if (ss.startsWith(ss.substring(i))) {
				index = i - 1;
			}
		}
		System.out.print(ss);
		if (index == 0) {
			for (int i = 0; i < k - 1; i++) {
				System.out.print(ss.substring(ss.length() - 1));
			}
			return;
		}
		for (int i = 0; i < k - 1; i++) {
			System.out.print(ss.substring(ss.length() - index - 1));

		}

	}
}
