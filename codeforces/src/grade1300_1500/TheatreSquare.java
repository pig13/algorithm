package grade1300_1500;

import java.util.Scanner;

public class TheatreSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		long col = n % a == 0 ? n / a : n / a + 1;
		long row = m % a == 0 ? m / a : m / a + 1;
		System.out.println(col * row);
	}
}
