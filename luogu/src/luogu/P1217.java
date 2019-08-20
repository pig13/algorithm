package luogu;

import java.util.Scanner;

public class P1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		a = a % 2 == 0 ? a + 1 : a;
		b = b % 2 == 0 ? b - 1 : b;
		for (int i = a; i <= b; i += 2) {
			if (backToText(i) && isPrime(i)) {
				System.out.println(i);
			}
			if (i == 9989899) {
				return;
			}
		}
	}

	public static boolean backToText(int num) {
		if (num < 10) {
			return true;
		}
		String ss = new Integer(num).toString();
		int i = 0;
		int j = ss.length() - 1;
		for (; i < j;) {
			if (ss.charAt(i) != ss.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i < Math.sqrt(num) + 1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
