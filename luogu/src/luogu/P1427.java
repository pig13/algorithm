package luogu;

import java.util.LinkedList;
import java.util.Scanner;

public class P1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		int tmp;
		for (;;) {
			tmp = sc.nextInt();
			if (tmp == 0) {
				break;
			}
			list.add(tmp);
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			if (i == 0) {
				System.out.println(list.get(i));
				break;
			} else {
				System.out.print(list.get(i) + " ");
			}

		}
	}
}
