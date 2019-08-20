package div3_531;

import java.util.Scanner;

public class TaskA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n %= 4;
		if (n == 3) {
			n = 0;
		}
		if (n == 2) {
			n = 1;
		}
		System.out.println(n);
	}
}
