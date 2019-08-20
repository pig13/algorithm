package div3_498;

import java.util.Scanner;

public class TaskA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
			if (tmp % 2 == 0) {
				tmp--;
			}
			System.out.print(tmp + " ");

		}
	}
}
