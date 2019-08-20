package luogu;

import java.util.Scanner;

public class P1980 {
	static int count = 0;
	static int x;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		x = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			func(i);
		}
		System.out.println(count);
	}

	public static void func(int num) {
		int tmp;
		for (; num != 0;) {
			tmp = num % 10;
			num /= 10;
			if (tmp == x) {
				count++;
			}
		}

	}

}
