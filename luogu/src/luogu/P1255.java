package luogu;

import java.math.BigInteger;
import java.util.Scanner;

public class P1255 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = n / 2;
		if (m == 0) {
			System.out.println(n);
			return;
		}
		BigInteger count = new BigInteger("2");
		System.out.println(count.pow(m));

	}
}
