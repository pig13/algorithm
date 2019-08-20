package grade1300_1500;

import java.util.Scanner;

public class IQtest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int odd = 0;
		int even = 0;
		for (int i = 1; i <= n; i++) {
			if (sc.nextInt() % 2 != 0) {
				odd += i;
			} else {
				even += i;
			}
		}
		System.out.println(Math.min(odd, even));

	}
}
