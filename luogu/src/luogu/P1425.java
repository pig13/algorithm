package luogu;

import java.util.Scanner;

public class P1425 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h1 = sc.nextInt();
		int m1 = sc.nextInt();
		int h2 = sc.nextInt();
		int m2 = sc.nextInt();
		if (m2 < m1) {
			System.out.print(h2 - h1 - 1 + " ");
			System.out.println(Math.abs(60 + m2 - m1));
		} else {
			System.out.println((h2 - h1) + " " + (m2 - m1));
		}
	}
}
