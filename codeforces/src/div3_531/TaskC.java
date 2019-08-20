package div3_531;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		LinkedList<Integer> less = new LinkedList<Integer>();
		LinkedList<Integer> more = new LinkedList<Integer>();
		int tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
			if (tmp <= x) {
				less.add(tmp);
			} else {
				more.add(tmp);
			}
		}
		Collections.sort(less);
		Collections.sort(more);
		int count = 0;
		long time = System.currentTimeMillis();
		for (;;) {
			if (less.isEmpty()) {
				if (x > y) {
					count += more.size();
				}
				break;
			}
			if (System.currentTimeMillis() > time + 800) {
				break;
			}

			less.removeLast();
			count++;
			if (less.isEmpty()) {
				if (x > y) {
					count += more.size();
				}
				break;
			}
			if (less.getLast() + y > x) {
				more.add(less.removeLast() + y);
			} else {
				less.addLast(less.removeLast() + y);
			}

			Collections.sort(less);
			Collections.sort(more);
		}
		System.out.println(count);

	}
}
