package luogu;

import java.util.LinkedList;
import java.util.Scanner;

public class P1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		int n = sc.nextInt();
		if (n == 0) {
			System.out.println(-1);
			return;
		}
		sc.nextLine();
		for (int i = 0; i < n * 4; i++) {
			list.add(sc.nextInt());
		}
		sc.nextLine();
		int x = sc.nextInt();
		int y = sc.nextInt();
		for (int i = list.size() - 1 - 3; i >= 0; i -= 4) {
			if (list.get(i) <= x && x <= list.get(i) + list.get(i + 2) && list.get(i + 1) <= y
					&& y <= list.get(i + 1) + list.get(i + 3)) {
				System.out.println(i / 4 + 1);
				return;
			}

		}
		System.out.println(-1);

	}
}
