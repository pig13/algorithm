package luogu;

import java.util.LinkedList;
import java.util.Scanner;

public class P1540 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();// size
		int n = sc.nextInt();// n个数
		if (m == 0) {
			System.out.println(n);
			return;
		}
		int count = 0;
		int tmp;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
			if (!list.contains(tmp)) {
				if (list.size() != m) {
					list.add(tmp);
				} else {
					list.poll();
					list.add(tmp);
				}
				count++;
			}
		}
		System.out.println(count);

	}
}
