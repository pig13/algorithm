package div3_547;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (m % n != 0) {
			System.out.println(-1);
			return;
		}
		int a = m / n;
		int count = 0;
		for (; a % 2 == 0;) {
			a /= 2;
			count++;
		}
		for (; a % 3 == 0;) {
			a /= 3;
			count++;
		}
		if (a != 1) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}

	}
}
