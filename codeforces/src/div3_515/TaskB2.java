package div3_515;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		boolean[] arr = new boolean[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (sc.nextInt() == 1) {
				list.add(i);
			}
		}
		int preIndex = 0;
		int index = 0;
		int arrIndex = 0;
		int times = 0;
		long time = System.currentTimeMillis();
		boolean flag = false;
		for (;;) {
			flag = false;
			if (System.currentTimeMillis() - time > 800 || list.isEmpty()) {
				break;
			}
			for (; index < list.size(); index++) {
				if (list.get(index) - r + 1 > arrIndex) {
					break;
				}
				preIndex = index;
			}
			int end = Math.min(list.get(preIndex) + r - 1, n - 1);
			int start = Math.max(list.get(preIndex) - r + 1, arrIndex);
			for (; start <= end; start++) {
				arr[start] = true;
				flag = true;
			}
			arrIndex = start;
			if (flag) {
				times++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (!arr[i]) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(times);

	}
}
