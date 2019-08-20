package luogu;

import java.util.Scanner;

public class P1035 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double res = 0;
		int count = 0;
		for (; num >= res;) {
			res += (double) 1 / ++count;
		}
		System.out.println(count);
	}
}
