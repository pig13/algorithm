package div3_535;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int l1;
		int r1;
		int l2;
		int r2;
		for (int i = 0; i < num; i++) {
			l1 = sc.nextInt();
			r1 = sc.nextInt();
			l2 = sc.nextInt();
			r2 = sc.nextInt();
			if (l1 <= l2) {
				System.out.println(l1 + " " + (l2 + 1));
			} else {
				System.out.println((l1 + 1) + " " + l2);
			}

		}
	}

}
