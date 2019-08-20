package div3_481;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
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
		if (Math.abs(min) > w || Math.abs(max) > w) {
			System.out.println(0);
			return;
		}
		long res;
		if (min <= 0 && max <= 0) {
			res = w - Math.abs(min) + 1;
		} else if (min <= 0 && max > 0) {
			if (Math.abs(min) + w - max > w) {
				res = w - max - (Math.abs(min) + w - max) + 1;
			} else if (max == Math.abs(min)) {
				res = w - max;
			} else {
				res = w - max + 1;
			}
		} else if (min > 0 && max < 0) {
//			不存在
			res = Long.MAX_VALUE;

		} else {
			// if (min > 0 && max >= 0)
			res = w - max + 1;
		}
		System.out.println(res);
	}
}
