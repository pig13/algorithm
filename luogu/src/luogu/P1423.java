package luogu;

import java.util.Scanner;

public class P1423 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float num = sc.nextFloat();
		double res = 2;
		double cur = 2;
		int count = 1;
		for (; num > res;) {
			cur *= 0.98;
			res += cur;
			count++;
		}
		System.out.println(count);
	}
}
