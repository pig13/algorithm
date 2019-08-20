package luogu;

import java.util.Scanner;

public class P1424 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int week = sc.nextInt();
		long num = sc.nextLong();
		int[] arr = { 1, 1, 1, 1, 1, 0, 0 };
		long res = 0;
		for (int i = 1; i <= num; i++) {
			if (arr[week - 1] == 1) {
				res += 250;
			}
			week = (week + 1) == 8 ? 1 : ++week;
		}
		System.out.println(res);

	}
}
