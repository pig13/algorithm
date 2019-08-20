package luogu;

import java.util.LinkedList;
import java.util.Scanner;

public class P1428 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
//		假设没有小鱼，输出0
		if (list.size() == 0 || list.size() == 1) {
			System.err.println(0);
			return;
		}
//		System.out.print(list.get(0) + " ");
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (list.get(i) > list.get(j)) {
					count++;
				}
			}
			if (i == list.size() - 1) {
				System.out.println(count);
			} else {
				System.out.print(count + " ");
			}
			count = 0;

		}

	}
}
