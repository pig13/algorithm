package luogu;

import java.util.Scanner;

public class P1426 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		double s = sc.nextInt();
//		double x = sc.nextInt();
//		double a = 0;
//		double v = 7;
//		for (; a < s - x;) {
//			a += v;
//			v *= 0.98;
//		}
//		if (a + v > s + x) {
//			System.out.println('n');
//		} else {
//			System.out.println('y');
//
//		}

		Scanner sc = new Scanner(System.in);
		double s = sc.nextInt();
		double x = sc.nextInt();
		if (x >= s) {
			if (s + x >= 7) {
				System.out.println('y');
			} else {
				System.out.println('n');
			}
			return;
		}
		double preDistance = 0;
		double preSpend = 7;
		double curDisance = 0;
		double curSpend = 7;
		for (; curDisance <= s - x;) {
			preDistance = curDisance;
			preSpend = curSpend;
			curDisance += curSpend;
			curSpend *= 0.98;
		}
		double t1 = (s - x - preDistance) / preSpend;
		double t2 = 1 - t1;
		if (t2 * preSpend + t1 * curSpend > 2 * x) {
			System.out.println('n');
		} else {
			System.out.println('y');
		}

	}
}
