package div3_515;

import java.util.Scanner;

public class TaskA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long L;
		long v;
		long l;
		long r;
		long ans;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			flag = false;
			L = sc.nextLong();
			v = sc.nextLong();
			l = sc.nextLong();
			r = sc.nextLong();
			if (l % v == 0 ) {
				flag = true;
			}
			if (flag) {
				ans = L / v - (r / v - l / v) - 1;
			} else {
				ans = L / v - (r / v - l / v);
			}
			if (ans > 0) {
				System.out.println(ans);
			} else {
				System.out.println(0);
			}
		}

	}
}
