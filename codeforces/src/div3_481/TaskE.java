package div3_481;

import java.util.Scanner;

public class TaskE {
	public static void main(String[] args) {
//		数学问题，分析问题，全模拟
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long w = sc.nextLong();
		long[] arr = new long[n];
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		long tmp = 0;
		for (int i = 0; i < n; i++) {
			tmp += sc.nextLong();
			arr[i] = tmp;
			min = tmp < min ? tmp : min;
			max = tmp > max ? tmp : max;
		}
		if (-min > w || max > w) {
			System.out.println(0);
		} else if (min >= 0) {
			System.out.println(w - max + 1);
		} else if (max <= 0) {
			System.out.println(w + min + 1);
		} else {
			if (w - max + min + 1 > 0 && w - max + min + 1 <= w) {
				System.out.println(w - max + min + 1);
			} else {
				System.out.println(0);
			}
		}
	}
}
